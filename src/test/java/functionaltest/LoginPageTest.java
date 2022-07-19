package functionaltest;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import static utilities.LoadConfig.*;
import utilities.ReadFiles;

public class LoginPageTest extends BaseTest{



    @Test
    private void should_Be_Able_To_Login_With_ValidUsernameAndValidPassword()  {
        //Arrange
        LoginPage loginPage = new LoginPage(driver);

        //Act
        loginPage.enterUserName(FRAMEWORK_PROPERTIES.getProperty("USERNAME"));
        loginPage.enterPassword(FRAMEWORK_PROPERTIES.getProperty("USERNAME"));
        loginPage.clickLoginBtn();

        //Assert
        String expectedUrl =FRAMEWORK_PROPERTIES.getProperty("PRODUCT_LIST_URL");
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);



    }

    @Test
    private void should_not_Be_Able_To_Login_With_InValidUsernameAndValidPassword(){
        //Arrange
        LoginPage loginPage = new LoginPage(driver);

        //Act
        loginPage.enterUserName("invalidUsername");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginBtn();

        //Assert
        String expectedUrl ="Epic sadface: Username and password do not match any user in this service";
        String actualUrl= loginPage.getErrorMessageForInvalidLogin();
        Assert.assertEquals(actualUrl,expectedUrl);


    }




}
