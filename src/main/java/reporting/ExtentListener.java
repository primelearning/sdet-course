package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import factory.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.SeleniumUtils;

import static reporting.ExtentFactory.*;

public class ExtentListener implements ITestListener {
    private static Logger LOG = LogManager.getLogger(ExtentListener.class);
    private ExtentReports extentReports;
//    private ExtentTest extentTest;

    @Override
    public void onStart(ITestContext context) {
        LOG.info("======TEST SUITE STARTED =========");
        LOG.info("=== INITIALIZING REPORT=====");
        extentReports = ExtentReportManager.initialize();
    }

    @Override
    public void onTestStart(ITestResult result) {
        setExtentTest(extentReports.createTest(result.getMethod().getMethodName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        getExtentTest().pass("Test case is Pass");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        getExtentTest().fail("Test case is Failed");
        getExtentTest().log(Status.FAIL,result.getThrowable());
        String base64ScreenshotImage=SeleniumUtils.takeScreenShotAsBase64(DriverFactory.getDriver());
        getExtentTest().info("Click below base64Img icon to view Screenshot");
        getExtentTest().fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64ScreenshotImage).build());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        getExtentTest().skip("Test case is Skipped: ");
    }

    @Override
    public void onFinish(ITestContext context) {
        LOG.info("Writing TEST REPORT=====");
        removeExtentTest();
        ExtentReportManager.writeReportData(extentReports);
        LOG.info("==== TEST SUITE EXECUTION ENDED=======");
    }
}
