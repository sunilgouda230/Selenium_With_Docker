package listeners;

import base.BaseClass;
import browserFactory.DriverManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import helper.Utility;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class ExtentTestNGITestListener implements ITestListener {

    ExtentReports extentReports = ExtentManager.createInstance();
    ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
    public void onTestStart(ITestResult result) {
        //test start
        ExtentTest extentTest = extentReports.createTest(result.getMethod().getMethodName());
        parentTest.set(extentTest);
    }

    public void onTestSuccess(ITestResult result) {
        // add pass logs
        parentTest.get().pass("Test Passed",
                MediaEntityBuilder.createScreenCaptureFromBase64String(Utility.takeScreenShotInBase64(DriverManager.getDriver())).build());
    }

    public void onTestFailure(ITestResult result) {
        // add fail log, exception
        parentTest.get().fail("Test Failed"+result.getThrowable().getMessage(),
                MediaEntityBuilder.createScreenCaptureFromBase64String(Utility.takeScreenShotInBase64(DriverManager.getDriver())).build());
    }

    public void onTestSkipped(ITestResult result) {
        parentTest.get().skip("Test Failed "+ result.getThrowable().getMessage());
    }

    public void onFinish(ITestContext context) {
        // test finish flush
        extentReports.flush();
    }
}
