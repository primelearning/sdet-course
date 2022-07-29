package Factory;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public final class DriverFactory {
    private DriverFactory() {
    }

   private static final ThreadLocal<WebDriver> threadLocal=new ThreadLocal<>();

    public static void setDriver(WebDriver driver){

        if(Objects.nonNull(driver)){
            threadLocal.set(driver);
        }
    }

    public static WebDriver getDriver(){
        return threadLocal.get();
    }

    public static void cleanup() {
        threadLocal.get().quit();
        threadLocal.remove();
    }
}


