package FunctionalTest;

import Base.BaseTest;
import Factory.DriverFactory;
import PageObjects.LoginPage;
import Utilities.LoadConfig;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

@Test
   private void shouldBeAbleToLoginWithValidUserNameAndPassword()  {

    DriverFactory.getDriver().get(LoadConfig.FRAMEWORK_PROPERTIES.getProperty("BASEURL"));
    DriverFactory.getDriver().manage().window().maximize();
    LoginPage login=new LoginPage(DriverFactory.getDriver());
    login.clickLoginLink();
    login.enterMailId(LoadConfig.ENVIRONMENT_PROPERTIES.getProperty("emailID"));
    login.clickOnNext();
    login.enterPassword(LoadConfig.ENVIRONMENT_PROPERTIES.getProperty("password"));
    login.clickOnNext();
    
}


}
