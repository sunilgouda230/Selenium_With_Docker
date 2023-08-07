package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Account {

    WebDriver driver;
    public Account(WebDriver driver) {
        this.driver=driver;
    }

    By logout_btn = By.xpath("//button[text()='Logout']");

    public Account click_logout_btn() {
        driver.findElement(logout_btn).click();
        return new Account(driver);
    }
}
