package testcases;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class RandomBlankTest extends Base {

    WebDriver driver;

    @BeforeTest
    public void initializeTest() throws IOException {
        driver = initialize();
    }
    @AfterMethod
    public void timeOut() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test
    public void dragAndDrop(){
        driver.get("http://jqueryui.com/droppable/");
        String dropText;

        Actions actions = new Actions(driver);
        WebElement frameElement = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(frameElement);

        WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement destination = driver.findElement(By.xpath("//div[@id='droppable']"));

        dropText = driver.findElement(By.xpath("//div[@id='droppable']")).getText();
        System.out.println("Test Before Drop---: "+dropText);

        actions.dragAndDrop(source,destination).build().perform();
        dropText = driver.findElement(By.xpath("//div[@id='droppable']")).getText();
        System.out.println("Test After Drop---: "+dropText);

    }


    @AfterTest
    public void tearDownTest(){
        driver.quit();

    }
}
