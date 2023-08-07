package DDT;

import helper.ConfigReader;
import helper.CustomDataProvider;
import helper.ExcelReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleDDT {

    @Test(dataProvider = "Sample", dataProviderClass = CustomDataProvider.class)
    public void sample(String username, String password) {
        System.out.println(username);
        System.out.println(password);
    }

    @Test
    public void test() {
        String bname = ConfigReader.readConfigProp("brower");
        System.out.println(bname);
    }


}
