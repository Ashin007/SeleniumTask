package pageobjectmodel.techlistic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TechlisticTable {
    WebDriver driver;
    By structureHeadings = By.xpath("//th[@scope='row']");
    By total_element = By.xpath("//td[@colspan='7']");
    By total_table = By.xpath("//tr[@style='margin: 0px; padding: 0px;']");

    public TechlisticTable(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getStructureHeadings(){
        return driver.findElements(structureHeadings);
    }
    public WebElement getTotalNumberElement(){
        return driver.findElement(total_element);
    }
    public List<WebElement> getTableRow(){
        return driver.findElements(total_table);
    }



}
