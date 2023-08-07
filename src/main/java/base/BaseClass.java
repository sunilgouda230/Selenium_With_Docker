package base;

import browserFactory.DriverManager;
import browserFactory.StartBrowser;
import helper.ConfigReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
    @BeforeClass
    public void setUpBrowser() {
        StartBrowser.startBrowser(ConfigReader.readConfigProp("browser"));
    }

    @AfterClass
    public void tearDown(){
        DriverManager.getDriver().quit();
    }
}
