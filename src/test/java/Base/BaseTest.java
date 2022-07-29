package Base;

import Factory.BrowserFactory;
import Factory.DriverFactory;
import Utilities.LoadConfig;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
     public void loginSetup(){
        DriverFactory.setDriver(BrowserFactory.getBrowser(LoadConfig.FRAMEWORK_PROPERTIES.getProperty("BROWSER-NAME" )));
        DriverFactory.getDriver();
    }
    @AfterTest
    public void cleanup(){
        DriverFactory.cleanup();
    }

}
