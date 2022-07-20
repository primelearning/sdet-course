package manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class BrowserFactory {
private BrowserFactory(){}

public static WebDriver getBrowser(String browserName){
 return setBrowser(browserName);
}

private static WebDriver setBrowser(String browserName){
 WebDriver driver;

 if(browserName.equalsIgnoreCase("chrome")){
  WebDriverManager.chromedriver().setup();
  driver = new ChromeDriver();
 }else if (browserName.equalsIgnoreCase("firefox")){
  WebDriverManager.firefoxdriver().setup();
  driver = new FirefoxDriver();
 }else{
  throw new RuntimeException("Invalid Browser name, please select one of these: chrome or firefox");
 }

 return driver;

}
}
