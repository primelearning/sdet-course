package factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public final class DriverFactory {
    private static Logger LOG = LogManager.getLogger(DriverFactory.class);
    private DriverFactory(){}

    /**
     * Making the ThreadLocal public will result in misusing the code while calling threadlocal driver
     */
    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    public static void setDriver(WebDriver driver){
        if(Objects.nonNull(driver)){
            LOG.info("Driver is Set.");
            threadLocalDriver.set(driver);
        }else {
            throw new RuntimeException("Driver is null, check for BaseTest class");
        }
    }
    public static WebDriver getDriver(){
        return threadLocalDriver.get();
    }
    public static void closeBrowser(){
        threadLocalDriver.get().quit();
        threadLocalDriver.remove();
        LOG.info("Driver is terminated");
    }
}
