package Factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public final class BrowserFactory {

    private BrowserFactory(){

    }

    public static WebDriver getDriver(String browserName){
        return setDriver(browserName);
    }

    private static WebDriver setDriver(String browserName){
        WebDriver driver;
        String browser=browserName.toLowerCase();
        switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            default ->
                    throw new RuntimeException("not a valid browser,it should be chrome or firefox or edge. check it in frameworkProperties");
        }
        return driver;

    }
}
