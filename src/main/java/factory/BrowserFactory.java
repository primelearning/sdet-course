package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import utilities.SeleniumUtils;


public final class BrowserFactory {
//    private final static Logger LOGGER =  Logger.getLogger(BrowserFactory.class.getName());
   private static Logger LOG = LogManager.getLogger(BrowserFactory.class);
    private BrowserFactory(){}

    public static WebDriver getBrowser(String browserName,boolean isHeadless){
        return setBrowser(browserName,isHeadless);
    }

    private static WebDriver setBrowser(String browserName,boolean isHeadless){
        WebDriver driver;

        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            if(isHeadless){
                driver = new ChromeDriver(SeleniumUtils.getHeadlessOptions(browserName));
                LOG.info("Getting the chrome Browser with headless mode.");
            }else{
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                LOG.info("Getting the chrome Browser with Normal mode.");
            }


        }else if (browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            LOG.info("Getting the firefox Browser.");
        } else if (browserName.equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
            LOG.info("Getting the safari Browser.");
        } else{
            LOG.error("Browser error.");
            throw new RuntimeException("Invalid Browser name, please select one of these: chrome or firefox");
        }
        return driver;
    }
}
