package testcases;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjectmodel.techlistic.TechlisticTable;

import java.io.IOException;
import java.util.List;

public class AssignmentFive extends Base {
    WebDriver driver;

    @BeforeTest
    public void initializeTest() throws IOException {
        driver = initialize();
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void timeOut() throws InterruptedException {
        Thread.sleep(3000);
    }

    @Test
    public void testOne(){
        /*
        Assignment 1: Verify that there are only 4 structure values present.
        Read the 'Structure' column and find out the total number of structures present.
        Read the value of 'Total' column and match with the previous step.
         */

        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
        TechlisticTable table = new TechlisticTable(driver);
        int noOfStructure = 0;

        List<WebElement> data_row = table.getStructureHeadings();
        for (WebElement element:data_row){
            if (!element.getText().contains("Total")){
                noOfStructure++;
                System.out.println(element.getText());
            }
        }
        int total_structure = Integer.parseInt(table.getTotalNumberElement().getText().substring(0,1));
        System.out.println(total_structure);
        Assert.assertEquals(total_structure,noOfStructure);
    }

    @Test
    public void testTwo(){
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");

        List<WebElement> row_value = driver.findElements(By.xpath("//th[@scope='row']"));
        int row_count = row_value.size();
        List<WebElement> col_value = driver.findElements(By.xpath("//th[@scope='col']"));
        int col_count = col_value.size();

        String row_xpath_before = "//*[@id=\"post-body-5867683659713562481\"]/div/div[1]/table/tbody/tr[";
        String row_xpathe_after = "]/th";

        String col_xpath_before = "//*[@id=\"post-body-5867683659713562481\"]/div/div[1]/table/tbody/tr[";
        String col_xpath_middle = "]/td[";
        String  col_xpath_after = "]";

        for(int i=1;i<row_count;i++){
            System.out.println(driver.findElement(By.xpath(row_xpath_before+i+row_xpathe_after)).getText());
            for (int j=1;j<col_count;j++){
                System.out.println(driver.findElement(By.xpath(col_xpath_before+i+col_xpath_middle+j+col_xpath_after)).getText());
            }
            System.out.println("-------------------------------------");
        }

    }

    @AfterTest
    public void tearDownTest(){
        driver.quit();

    }
}
