package FunctionalTest;

import Base.BaseTest;
import PageObjects.LoginPage;
import Utilities.LoadConfig;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

@Test
   private void shouldBeAbleToLoginWithValidUserNameAndPassword()  {


    driver.get(LoadConfig.FRAMEWORK_PROPERTIES.getProperty("BASEURL"));
    driver.manage().window().maximize();
    LoginPage login=new LoginPage(driver);
    login.clickLoginLink();
    login.enterMailId(LoadConfig.ENVIRONMENT_PROPERTIES.getProperty("emailID"));
    login.clickOnNext();
    login.enterPassword(LoadConfig.ENVIRONMENT_PROPERTIES.getProperty("password"));
    login.clickOnNext();


    
}


}
