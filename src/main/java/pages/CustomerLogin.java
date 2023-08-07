package pages;

import helper.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerLogin {

    WebDriver driver;

    public CustomerLogin(WebDriver driver) {
        this.driver = driver;
    }

    By login_btn = By.xpath("//button[text()='Login']");

    public CustomerLogin select_customer(String customername) {
        Utility.selectCustomer(customername,driver);
        return new CustomerLogin(driver);
    }
    public Account login_btn_click(){
        driver.findElement(login_btn).click();
       return new Account(driver);
    }


}
