package functionaltest;

import base.BaseTestUI;
import static factory.DriverFactory.getDriver;

import dataproviders.LoginDataProvider;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import static reporting.ExtentFactory.getExtentTest;

import static configurations.ConfigManager.ENV_PROPERTIES;


public class LoginPageTest extends BaseTestUI {


    @Test(groups = {"regression","sanity","login"})
     void should_Be_Able_To_Login_With_ValidUsernameAndValidPassword1()  {
        //Arrange
        LoginPage loginPage = new LoginPage(getDriver());

        //Act
        loginPage.enterUserName(ENV_PROPERTIES.getProperty("USERNAME"));
        getExtentTest().info("Entering username "+ENV_PROPERTIES.getProperty("USERNAME"));
        loginPage.enterPassword(ENV_PROPERTIES.getProperty("PASSWORD"));
        getExtentTest().info("Entering password "+ENV_PROPERTIES.getProperty("PASSWORD"));
        getExtentTest().info("Clicking on Login Button");
        loginPage.clickLoginBtn();

        //Assert
        String expectedUrl = ENV_PROPERTIES.getProperty("PRODUCT_LIST_URL");
        String actualUrl = getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        // TODO: make this code do something- pending


    }

    @DataProvider(name = "invalidUsernamesAndPasswords")
    public Object[][] invalidUsernamesAndPasswords(){
        return new Object[][]{
                {"invalidUsername1","invalidPassword1"}, {"invalidUsername2","invalidPassword2"}
        };
    }
    @Test(groups = {"sanity","login"},dataProvider = "invalidUsernamesAndPasswords")
     void should_not_Be_Able_To_Login_With_InValidUsernameAndValidPassword1(String username, String password) {
        //Arrange
        LoginPage loginPage = new LoginPage(getDriver());

        //Act
        loginPage.enterUserName(username);
        getExtentTest().info("Username:"+username);
        loginPage.enterPassword(password);
        getExtentTest().info("Password:"+password);

        loginPage.clickLoginBtn();

        //Assert
        String expectedUrl = "Epic sadface: Username and password do not match any user in this service";
        String actualUrl = loginPage.getErrorMessageForInvalidLogin();
        Assert.assertEquals(actualUrl, expectedUrl);

    }

    @Test(groups = {"sanity","login"},dataProvider = "validUsernamesAndinvalidPasswords",dataProviderClass = LoginDataProvider.class)
    void should_not_Be_Able_To_Login_With_InValidUsernameAndValidPassword2(String username, String password) {
        //Arrange
        LoginPage loginPage = new LoginPage(getDriver());

        //Act
        loginPage.enterUserName(username);
        getExtentTest().info("Username:"+username);
        loginPage.enterPassword(password);
        getExtentTest().info("Password:"+password);
        loginPage.clickLoginBtn();

        //Assert
        String expectedUrl = "Epic sadface: Username and password do not match any user in this service";
        String actualUrl = loginPage.getErrorMessageForInvalidLogin();
        Assert.assertEquals(actualUrl, expectedUrl);

    }

    @Test(groups = {"sanity","login"},dataProvider = "invalidUsernamesAndvalidPasswordsFromFaker",dataProviderClass = LoginDataProvider.class)
    private void should_not_Be_Able_To_Login_With_InValidUsernameAndValidPassword2b(String username, String password) {
        //Arrange
        LoginPage loginPage = new LoginPage(getDriver());

        //Act
        loginPage.enterUserName(username);
        getExtentTest().info("Username:"+username);
        loginPage.enterPassword(password);
        getExtentTest().info("Password:"+password);
        loginPage.clickLoginBtn();

        //Assert
        String expectedUrl = "Epic sadface: Username and password do not match any user in this service";
        String actualUrl = loginPage.getErrorMessageForInvalidLogin();
        Assert.assertEquals(actualUrl, expectedUrl);

    }

    @Test(groups = {"regression", "login"})
    private void should_not_Be_Able_To_Login_With_InValidUsernameAndValidPassword3() {
        //Arrange
        LoginPage loginPage = new LoginPage(getDriver());

        //Act
        loginPage.enterUserName("username");
        loginPage.enterPassword("username");
        loginPage.clickLoginBtn();

        //Assert
        throw new SkipException("Intentionally Skipped for Reporting");

    }

    @Test(groups = {"regression", "login"})
    private void should_not_Be_Able_To_Login_With_InValidUsernameAndValidPassword4() {
        //Arrange
        LoginPage loginPage = new LoginPage(getDriver());

        //Act
        loginPage.enterUserName("invalidUsername");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginBtn();

        //Assert
        String expectedUrl = "Epic sadface: Username and password do not match any user in this service";
        String actualUrl = loginPage.getErrorMessageForInvalidLogin();
        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.fail("Intentional Fail");

    }


}
