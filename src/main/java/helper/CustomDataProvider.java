package helper;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {

    @DataProvider(name="Sample")
    public Object[][] getData() {
        Object[][] arr = ExcelReader.getDataFromSheet("login_cred");
        return arr;
    }
}
