package base;

import factory.BrowserFactory;
import factory.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import reporting.ExtentListener;
import configurations.ConfigManager;

@Listeners(ExtentListener.class)
public class BaseTest {
    private static Logger LOG = LogManager.getLogger(BaseTest.class);

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        DriverFactory.setDriver(BrowserFactory.getBrowser(ConfigManager.BROWSER_NAME,ConfigManager.IS_HEADLESS));
        DriverFactory.getDriver().get(ConfigManager.ENV_PROPERTIES.getProperty("BASE_URL"));
        LOG.info("WebDriver is initialized.");
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp(){
        DriverFactory.closeBrowser();
    }

}
