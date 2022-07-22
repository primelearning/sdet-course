package reporting;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public final class ExtentFactory {
    private ExtentFactory(){}

    /**
     * Making the ThreadLocal public will result in misusing the code while calling threadlocal driver
     */
    private static ThreadLocal<ExtentTest> extentThreadLocal = new ThreadLocal<>();

    public static void setExtentTest(ExtentTest extentTest){
        if(Objects.nonNull(extentTest)){
            extentThreadLocal.set(extentTest);
        }else {
            throw new RuntimeException("Extent Test is null, check for ExtentReportManager class");
        }
    }
    public static ExtentTest getExtentTest(){
        return extentThreadLocal.get();
    }
    public static void removeExtentTest(){
        extentThreadLocal.remove();
    }
}
