package pageobjectmodel.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonMainPage {
    WebDriver driver;
    By firstMenuLink = By.cssSelector("a[href*='/international']");

    public AmazonMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnFirstMenu(){
        driver.findElement(firstMenuLink).click();
    }
}
