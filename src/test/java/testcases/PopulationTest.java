package testcases;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pageobjectmodel.worldpopulation.WorldPopulation;

import java.io.IOException;
import java.util.List;

public class PopulationTest extends Base {

    WebDriver driver;

    @BeforeTest
    public void initializeTest() throws IOException {

        driver = initialize();
    }
    @AfterMethod
    public void timeout() throws InterruptedException {
        Thread.sleep(3000);
    }

    @Test
    public void mainTest(){

        //target url
        driver.get("https://worldpopulationreview.com/");

        WorldPopulation population = new WorldPopulation(driver);
        population.getTableData();

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }


}
