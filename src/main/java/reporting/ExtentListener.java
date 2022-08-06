package reporting;

import apiutils.ApiLogger;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import factory.DriverFactory;
import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.SeleniumUtils;

import java.util.Arrays;
import java.util.Objects;

import static reporting.ExtentFactory.*;

public class ExtentListener implements ITestListener {
    private static Logger LOG = LogManager.getLogger(ExtentListener.class);
    private ExtentReports extentReports;

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
        if (result.getParameters().length > 0) {
            getExtentTest().info("Test Data: "+ Arrays.asList(result.getParameters()));
        }
        try{
            getExtentTest().info(MarkupHelper.createCodeBlock(ApiLogger.writer.toString()));
        }catch (NullPointerException e){
            LOG.info("No Logs created for API test in this Test run. Returned Null, Can be Ignored.");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        getExtentTest().log(Status.FAIL,result.getThrowable());

        if(Objects.nonNull(DriverFactory.getDriver())){
            String base64ScreenshotImage=SeleniumUtils.takeScreenShotAsBase64(DriverFactory.getDriver());
            getExtentTest().info("Click below base64Img icon to view Screenshot");
            getExtentTest().fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64ScreenshotImage).build());
        }
        try{
            getExtentTest().info(MarkupHelper.createCodeBlock(ApiLogger.writer.toString()));
        }catch (NullPointerException e){
            LOG.info("No Logs created for API test in this Test run. Returned Null, Can be Ignored.");
        }


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
