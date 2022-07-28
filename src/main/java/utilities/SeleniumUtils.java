package utilities;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

public final class SeleniumUtils {
    private SeleniumUtils(){}
    public static void getTextFromElement(WebElement element){

    }


    public static ChromeOptions getHeadlessOptions(String browserName){
        ChromeOptions options ;
        if(browserName.equalsIgnoreCase("chrome")){
            options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-logging");
            options.addArguments("--log-level=3");
            options.addArguments("window-size=1920,1080");
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        }else {
            throw new RuntimeException("Invalid Browsername.");
        }
        return options;
    }

}
