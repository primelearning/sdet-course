package Base;

import Factory.BrowserFactory;
import Utilities.LoadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
     public void loginSetup(){

       // WebDriverManager.chromedriver().setup();
         driver = BrowserFactory.getDriver(LoadConfig.FRAMEWORK_PROPERTIES.getProperty("BROWSER-NAME" ));
    }
    @AfterTest
    public void cleanup(){
        driver.close();
    }

}
