package base;

import factory.BrowserFactory;
import factory.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import reporting.ExtentListener;
import utilities.ConfigManager;

@Listeners(ExtentListener.class)
public class BaseTest {


    @BeforeMethod(alwaysRun = true)
    public void setup(){
        DriverFactory.setDriver(BrowserFactory.getBrowser(ConfigManager.FRAMEWORK_PROPERTIES.getProperty("BROWSER_NAME")));
        DriverFactory.getDriver().get(ConfigManager.FRAMEWORK_PROPERTIES.getProperty("BASE_URL"));
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp(){
        DriverFactory.closeBrowser();
    }

}
