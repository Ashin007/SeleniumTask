package pageobjectmodel.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleMainPage {

    private WebDriver driver;
    private By searchBoxElement = By.xpath("//input[@title='Search']");
    private By searchList = By.xpath("//li[@role='presentation']");

    public GoogleMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSearchBox(){
        return driver.findElement(searchBoxElement);
    }

    public List<WebElement> getSearchLists(){
        return driver.findElements(searchList);
    }


    public By getSearchBoxElement() {
        return searchBoxElement;
    }
}
