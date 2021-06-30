package testcases;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageobjectmodel.worldpopulation.WorldPopulation;

import java.io.IOException;

public class PopulationTest extends Base {

    WebDriver driver;

    @BeforeTest(groups = {"smoke"})
    public void initializeTest() throws IOException {

        driver = initialize();
    }

    @AfterMethod(groups = {"smoke"})
    public void timeout() throws InterruptedException {
        Thread.sleep(3000);
    }

    @Test(groups = {"smoke"})
    public void mainTest() {

        //target url
        driver.get("https://worldpopulationreview.com/");

        WorldPopulation population = new WorldPopulation(driver);
        population.getTableData();

    }

    @AfterTest(groups = {"smoke"})
    public void tearDown() {
        driver.quit();
    }


}
