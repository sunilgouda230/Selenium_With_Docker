package pages;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseClass {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By customerLogin = By.xpath("//button[contains(text(),'Customer')]");
    By titleOfBank = By.xpath("//strong[@class='mainHeading']");

    public CustomerLogin customerLoginBtn(){
        driver.findElement(customerLogin).click();
        return new CustomerLogin(driver);
    }

    public Account verifyBankTitle(){
        driver.findElement(titleOfBank).isDisplayed();
        return new Account(driver);
    }

}
