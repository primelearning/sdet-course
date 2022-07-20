package functionaltest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.LoginPage;

import static utilities.LoadConfig.ENV_PROPERTIES;
import static utilities.LoadConfig.FRAMEWORK_PROPERTIES;


public class LoginPage2Test extends BaseTest {


    @Test
    private void should_Be_Able_To_Login_With_ValidUsernameAndValidPassword() {
        //Arrange
        LoginPage loginPage = new LoginPage(driver);

        //Act
        loginPage.enterUserName(ENV_PROPERTIES.getProperty("USERNAME"));
        loginPage.enterPassword(ENV_PROPERTIES.getProperty("PASSWORD"));
        loginPage.clickLoginBtn();

        //Assert
        String expectedUrl = FRAMEWORK_PROPERTIES.getProperty("PRODUCT_LIST_URL");
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        //TODO: make this code do something- pending


    }

    @Test
    private void should_not_Be_Able_To_Login_With_InValidUsernameAndValidPassword() {
        //Arrange
        LoginPage loginPage = new LoginPage(driver);

        //Act
        loginPage.enterUserName("invalidUsername");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginBtn();

        //Assert
        String expectedUrl = "Epic sadface: Username and password do not match any user in this service";
        String actualUrl = loginPage.getErrorMessageForInvalidLogin();
        Assert.assertEquals(actualUrl, expectedUrl);


    }

    @Test
    private void should_not_Be_Able_To_Login_With_InValidUsernameAndValidPassword2() {
        //Arrange
        LoginPage loginPage = new LoginPage(driver);

        //Act
        loginPage.enterUserName("invalidUsername");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginBtn();

        //Assert
        String expectedUrl = "Epic sadface: Username and password do not match any user in this service";
        String actualUrl = loginPage.getErrorMessageForInvalidLogin();
        Assert.assertEquals(actualUrl, expectedUrl);


    }

    @Test
    private void should_not_Be_Able_To_Login_With_InValidUsernameAndValidPassword3() {
        //Arrange
        LoginPage loginPage = new LoginPage(driver);

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
