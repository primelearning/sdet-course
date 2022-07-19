package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.LoadConfig;
import utilities.ReadFiles;

import java.util.Properties;

public class BaseTest {


    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // chrome / firefox - default
        driver.get(LoadConfig.FRAMEWORK_PROPERTIES.getProperty("BASE_URL"));
    }

    @AfterMethod
    public void cleanUp(){
        driver.quit();
    }

}
