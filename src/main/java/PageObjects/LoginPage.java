package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class LoginPage {
    public WebDriver localDriver;

    public LoginPage(WebDriver driver){
        this.localDriver=driver;
    }

    String logInLink="//a[text()='Log In']";
    String userMailID="email";
    String userPassword="password";
    String nextButton="//button[@type='submit']";



    public void clickLoginLink(){
        localDriver.findElement(By.xpath(logInLink)).click();
    }

    public void enterMailId(String emailId){
        localDriver.findElement(By.name(userMailID)).sendKeys(emailId);
    }
    public void clickOnNext(){
        localDriver.findElement(By.xpath(nextButton)).click();
    }
    public  void enterPassword(String password){
        localDriver.findElement(By.name(userPassword)).sendKeys(password);
    }

}
