package functionaltest;

import base.BaseTest;
import static factory.DriverFactory.getDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import static reporting.ExtentFactory.getExtentTest;

import static utilities.ConfigManager.ENV_PROPERTIES;
import static utilities.ConfigManager.FRAMEWORK_PROPERTIES;


public class LoginPageTest extends BaseTest {


    @Test
    private void should_Be_Able_To_Login_With_ValidUsernameAndValidPassword1()  {
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
        String expectedUrl = FRAMEWORK_PROPERTIES.getProperty("PRODUCT_LIST_URL");
        String actualUrl = getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        // TODO: make this code do something- pending


    }

    @Test
    private void should_not_Be_Able_To_Login_With_InValidUsernameAndValidPassword1() {
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

    @Test
    private void should_not_Be_Able_To_Login_With_InValidUsernameAndValidPassword2() {
        //Arrange
        LoginPage loginPage = new LoginPage(getDriver());

        //Act
        loginPage.enterUserName("invalidUsername");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginBtn();

        //Assert
        throw new SkipException("Intentionally Skipped for Reporting");

    }

    @Test
    private void should_not_Be_Able_To_Login_With_InValidUsernameAndValidPassword3() {
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


    }


}
