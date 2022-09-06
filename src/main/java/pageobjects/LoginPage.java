package pageobjects;

import factory.BrowserFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class LoginPage {
  private static Logger LOG = LogManager.getLogger(LoginPage.class);
  private WebDriver localDriver;

  //Step1: Implement JAVA coding standards to enable locators and usage of this class
  public LoginPage(WebDriver driverObject)
    {
      this.localDriver = driverObject;
      PageFactory.initElements(localDriver, this);
      LOG.info("LoginPage Elements initialized.");
    }

  //Step2: Identify all locators
  //Locators
  private String usernameTxt = "#user-name";
  //Using By Type as Locator
  private By passwordTxt = By.cssSelector("#password");
  //Using Page Factory method
  @FindBy(css = "#login-button")
  WebElement loginBtn;
  @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
  WebElement errorMessageInvalidLogin;

  //Step3: Add user behavior methods
  public void enterUserName(String username)
    {
      localDriver.findElement(By.cssSelector(usernameTxt)).sendKeys(username);
    }

  public void enterPassword(String password)
    {
      localDriver.findElement(passwordTxt).sendKeys(password);
    }

  public ProductsPage clickLoginBtn()
    {
      loginBtn.click();
      return new ProductsPage(localDriver);
    }

  public String getErrorMessageForInvalidLogin()
    {
      return errorMessageInvalidLogin.getText();
    }


}
