package base;

import factory.BrowserFactory;
import factory.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigManager;

public class BaseTest {


    @BeforeMethod
    public void setup(){
        DriverFactory.setDriver(BrowserFactory.getBrowser(ConfigManager.FRAMEWORK_PROPERTIES.getProperty("BROWSER_NAME")));
        DriverFactory.getDriver().get(ConfigManager.FRAMEWORK_PROPERTIES.getProperty("BASE_URL"));
    }

    @AfterMethod
    public void cleanUp(){
        DriverFactory.closeBrowser();
    }

}
