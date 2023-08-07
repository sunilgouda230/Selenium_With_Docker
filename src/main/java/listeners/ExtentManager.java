package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentManager {

    public static ExtentReports extent;
    public static ExtentReports getInstance(){
        if (extent == null) {
            extent = createInstance();
        }
            return extent;

    }


    public static ExtentReports createInstance(){
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/reports/Automation.html"));
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setReportName("Regression Report");
        sparkReporter.config().setDocumentTitle("Bank Regression Report");

        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);

        return extentReports;
    }
}
