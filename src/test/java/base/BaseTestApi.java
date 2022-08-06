package base;

import configurations.ConfigManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import reporting.ExtentListener;



@Listeners(ExtentListener.class)
public class BaseTestApi {
    private static Logger log = LogManager.getLogger(ConfigManager.class);
    @BeforeSuite(alwaysRun = true)
    public void apiSetup(){
        log.info("===== API Test Suite started ====== ");
    }


}
