package pageobjectmodel.techlistic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TechListicMainPage {
    WebDriver driver;
    By mainPageJavaLink = By.linkText("Java");
    By mainPageSeleniumLink = By.xpath("//a[@href='https://www.techlistic.com/p/selenium-tutorials.html']");
    By mainPageTestNGLink = By.xpath("//a[@href='https://www.techlistic.com/p/testng.html']");
    By mainPageSeleniumBlogLink = By.xpath("//a[@href='https://www.techlistic.com/p/selenium.html']");

    public TechListicMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnJavaLink(){
        driver.findElement(mainPageJavaLink).click();
    }
    public void clickOnSeleniumLink(){
        driver.findElement(mainPageSeleniumLink).click();
    }
    public void clickOnTestNgLink(){
        driver.findElement(mainPageTestNGLink).click();
    }
    public void clickOnSeleniumBlogsLink(){
        driver.findElement(mainPageSeleniumBlogLink).click();
    }
}
