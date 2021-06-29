package testcases;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjectmodel.worldpopulation.WorldPopulation;

import java.io.IOException;

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
    public void mainTest() {

        //target url
        driver.get("https://worldpopulationreview.com/");

        WorldPopulation population = new WorldPopulation(driver);
        population.getTableData();

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }


}
