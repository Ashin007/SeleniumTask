package testcases;

import base.Base;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class AssignmentOne extends Base {
    WebDriver driver;

    @BeforeTest
    public void initializeTest() throws IOException {
        driver = initialize();
        driver.manage().window().maximize();
        System.out.println("before test");
    }
    @AfterMethod
    public void timeOut() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test(groups = {"smoke"})
    public void testOne(){
        System.out.println("smoke");
        /*
        Test Case 1 - Open Godaddy.com and maximize browser window.

        Steps to Automate:
        1. Launch browser of your choice say., Firefox, chrome etc.
        2. Open this URL - https://www.godaddy.com/
        3. Maximize or set size of browser window.
         */
        driver.get("https://www.godaddy.com/");

    }

    @Test
    public void testTwo(){
        /*
        Test Case 2 - Open Godaddy.com and Print it's Page title.

        Steps to Automate:
        1. Launch browser of your choice say., Firefox, chrome etc.
        2. Open this URL - https://www.godaddy.com/
        3. Maximize or set size of browser window.
        4. Get Title of page and print it.
        5. Close browser.
         */

        driver.get("https://www.godaddy.com/");
        Dimension dimension = new Dimension(400,200);
        driver.manage().window().setSize(dimension);
        System.out.println(driver.getTitle());

    }

    @Test
    public void testThree(){
        /*
        Test Case 3 - Open Godaddy.com and Print Page source.

        Steps to Automate:
        1. Launch browser of your choice say., Firefox, chrome etc.
        2. Open this URL - https://www.godaddy.com/
        3. Maximize or set size of browser window.
        4. Get Page source and print it.
        5. Close browser.
         */

        driver.get("https://www.godaddy.com/");
        Dimension dimension = new Dimension(800,800);
        driver.manage().window().setSize(dimension);
        System.out.println(driver.getPageSource());

    }

    @Test
    public void testFour() throws IOException {
        /*
        Test Case 6 - Open Godaddy.com and Validate Page Title

            Steps to Automate:
            1. Launch browser of your choice say., Firefox, chrome etc.
            2. Open this URL - https://www.godaddy.com/
            3. Maximize or set size of browser window.
            4. Get Title of page and validate it with expected value.
            5. Get URL of current page and validate it with expected value.
            6. Get Page source of web page.
            7. And Validate that page title is present in page source.
            8. Close browser.
         */




        driver.get("https://www.godaddy.com/");
        driver.manage().window().maximize();
        Assert.assertEquals("Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IN", driver.getTitle(), "Strings are not matching");
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        //Copy the file to a location and use try catch block to handle exception
        try {
            FileUtils.copyFile(screenshot, new File("C:\\Users\\ashin\\Downloads\\src\\homePageScreenshot.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        String pageSource = driver.getPageSource();
        boolean pageTitleFlag = pageSource.contains("Domain Names, Websites, Hosting &amp; Online Marketing Tools - GoDaddy IN");
        Assert.assertTrue(pageTitleFlag);

    }



    @AfterTest
    public void tearDownTest(){
        driver.quit();

    }
}
