package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import utilities.ConfigManager;

public final class ExtentReportManager {
    private ExtentReportManager(){}
    private static ExtentReports extentReports;


    //initilize report
    public static ExtentReports initialize(){
        extentReports= new ExtentReports();

        //Create HTML reporter and decorate
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("Report/report.html");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(ConfigManager.FRAMEWORK_PROPERTIES.getProperty("DOCUMENT_TITLE"));
        htmlReporter.config().setReportName(ConfigManager.FRAMEWORK_PROPERTIES.getProperty("REPORT_NAME"));

        //Set TEST ENV info
        extentReports.setSystemInfo("Execution Environment",ConfigManager.FRAMEWORK_PROPERTIES.getProperty("TEST_ENV"));
        extentReports.setSystemInfo("Test Browser",ConfigManager.FRAMEWORK_PROPERTIES.getProperty("BROWSER_NAME"));
        extentReports.setSystemInfo("TEST OS",ConfigManager.FRAMEWORK_PROPERTIES.getProperty("TEST_OS"));

        //Attaching the HTML reporter with extentReport
        extentReports.attachReporter(htmlReporter);

        return extentReports;
    }

    public static void writeReportData(ExtentReports extentReports){
        extentReports.flush();
    }



}
