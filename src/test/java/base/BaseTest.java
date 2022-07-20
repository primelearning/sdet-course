package base;

import manager.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.LoadConfig;

public class BaseTest {


    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver=BrowserFactory.getBrowser(LoadConfig.FRAMEWORK_PROPERTIES.getProperty("BROWSER_NAME"));
        driver.get(LoadConfig.FRAMEWORK_PROPERTIES.getProperty("BASE_URL"));
    }

    @AfterMethod
    public void cleanUp(){
        driver.quit();
    }

}
