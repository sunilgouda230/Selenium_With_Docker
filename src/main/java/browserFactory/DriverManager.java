package browserFactory;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void setDriver(WebDriver driverrefrence){
        driver.set(driverrefrence);
    }

    public static void closeDriver(){
        driver.remove();
    }
}
