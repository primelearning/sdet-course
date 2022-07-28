package base;

import factory.BrowserFactory;
import factory.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import reporting.ExtentListener;
import utilities.ConfigManager;

@Listeners(ExtentListener.class)
public class BaseTest {
    private static Logger LOG = LogManager.getLogger(BaseTest.class);

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        String BROWSERNAME=ConfigManager.FRAMEWORK_PROPERTIES.getProperty("BROWSER_NAME");
        boolean HEADLESSMODE=Boolean.parseBoolean(ConfigManager.FRAMEWORK_PROPERTIES.getProperty("HEADLESS_MODE"));

        DriverFactory.setDriver(BrowserFactory.getBrowser(BROWSERNAME,HEADLESSMODE));
        DriverFactory.getDriver().get(ConfigManager.FRAMEWORK_PROPERTIES.getProperty("BASE_URL"));
        LOG.info("Webdriver is initialized.");
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp(){
        DriverFactory.closeBrowser();
    }

}
