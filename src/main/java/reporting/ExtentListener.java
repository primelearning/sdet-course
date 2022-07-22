package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import static reporting.ExtentFactory.*;

public class ExtentListener implements ITestListener {
    private ExtentReports extentReports;
//    private ExtentTest extentTest;

    @Override
    public void onStart(ITestContext context) {
        System.out.println("======TEST SUITE STARTED =========");
        System.out.println("=== INITIALIZING REPORT=====");
        extentReports = ExtentReportManager.initialize();
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("I am inside onTestStart");
        setExtentTest(extentReports.createTest(result.getMethod().getMethodName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("I am inside onTestSuccess");
        System.out.println(result.getMethod().getMethodName());
        getExtentTest().pass("Test case is Pass");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("== It Failed and I took Screenshot====");
        System.out.println(result.getMethod().getMethodName());
        getExtentTest().fail("Test case is Failed");
        getExtentTest().log(Status.FAIL,result.getThrowable());
        // TODO: screenshot method will be called here

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("I am inside onTestSkipped");
        System.out.println(result.getMethod().getMethodName());
        getExtentTest().skip("Test case is Skipped: ");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Writing TEST REPORT=====");
        removeExtentTest();
        ExtentReportManager.writeReportData(extentReports);
        System.out.println("==== TEST SUITE EXECUTION ENDED=======");
    }
}
