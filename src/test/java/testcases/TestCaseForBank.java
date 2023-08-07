package testcases;

import base.BaseClass;
import browserFactory.DriverManager;
import org.testng.annotations.Test;
import pages.HomePage;

public class TestCaseForBank extends BaseClass {

    @Test(description = "customer login and checked balance")
    public void loginAndCheckBalance() {
       HomePage homePage = new HomePage(DriverManager.getDriver());
       homePage.verifyBankTitle();
       homePage.customerLoginBtn().
               select_customer("Harry Potter").
               login_btn_click().
               click_logout_btn();
    }
}
