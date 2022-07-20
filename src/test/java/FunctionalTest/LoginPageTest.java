package FunctionalTest;

import Base.BaseTest;
import PageObjects.LoginPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

@Test
   private void shouldBeAbleToLoginWithValidUserNameAndPassword()  {


    driver.get("https://www.docusign.com/");
    driver.manage().window().maximize();
    LoginPage login=new LoginPage(driver);
    login.clickLoginLink();
    login.enterMailId("taruna.cotti@gmail.com");
    login.clickOnNext();
    login.enterPassword("TestPractice@2");
    login.clickOnNext();


    
}


}
