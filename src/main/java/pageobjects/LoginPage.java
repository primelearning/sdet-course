package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver localDriver;

    //Step1: Implement JAVA coding standards to enable locators and usage of this class
    public LoginPage(WebDriver driverObject) {
        this.localDriver = driverObject;
    }

    //Step2: Identify all locators
    //Locators
    String usernameTxt = "#user-name";
    String passwordTxt = "#password";
    String loginBtn = "#login-button";

    String errorMessageInvalidLogin = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3";

    //Step3: Add user behavior methods
    public void enterUserName(String username) {
        localDriver.findElement(By.cssSelector(usernameTxt)).sendKeys(username);
    }

    public void enterPassword(String password) {
        localDriver.findElement(By.cssSelector(passwordTxt)).sendKeys(password);
    }

    public void clickLoginBtn() {
        localDriver.findElement(By.cssSelector(loginBtn)).click();
    }

    public String getErrorMessageForInvalidLogin() {
       return localDriver.findElement(By.xpath(errorMessageInvalidLogin)).getText();
    }


}
