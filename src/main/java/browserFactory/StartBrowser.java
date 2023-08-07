package browserFactory;

import helper.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

import java.time.Duration;

public class StartBrowser {

    static WebDriver driver = null;
    public static WebDriver startBrowser(String browsername){

        if(browsername.contains("gc") || browsername.contains("Chrome")){
           driver = new ChromeDriver();
           DriverManager.setDriver(driver);
        } else if(browsername.contains("Safari")){
            driver = new SafariDriver();
            DriverManager.setDriver(driver);
        } else if(browsername.contains("Firefox")){
            driver = new FirefoxDriver();
            DriverManager.setDriver(driver);
        } else {
            Reporter.log("sorry "+ browsername+"not supported anymore please check the version of selenium");
            driver = new ChromeDriver();
            DriverManager.setDriver(driver);
        }

        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
        DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        DriverManager.getDriver().get(ConfigReader.readConfigProp("url"));
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return DriverManager.getDriver();
    }

}
