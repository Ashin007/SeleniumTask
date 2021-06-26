package testcases;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjectmodel.amazon.AmazonMainPage;
import pageobjectmodel.techlistic.TechListicMainPage;

import java.io.IOException;

public class AssignmentTwo extends Base {

    WebDriver driver;

    @BeforeTest
    public void initializeTest() throws IOException {
        driver = initialize();
    }
    @AfterMethod
    public void timeOut() throws InterruptedException {
        Thread.sleep(3000);
    }

    @Test(enabled = false)
    public void testOne(){
        /*
        Test Case 1 - Automate first Menu link of amazon.in and print page title

        Steps to Automate:
        1. Launch browser of your choice say., firefox, chrome etc. ✓
        2. Open this URL -  www.amazon.in ✓
        3. Maximize or set size of browser window. ✓
        4. Get the page title and print it. ✓
        5. Now, click on first menu link say 'Amazon Pay' (or choose any other link from the menu list) ✓
        6. Get the page title and print it. ✓
        7. Navigate back to Home Page. ✓
        8. Get the page title and print it. Verify that value matches with output of point no. 4 ✓
        9. Close the browser. ✓
        */

        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        String mainPageTitle = driver.getTitle();

        AmazonMainPage amazonMainPage = new AmazonMainPage(driver);
        amazonMainPage.clickOnFirstMenu();
        driver.navigate().back();
        String mainPageTitleAfterNavigation = driver.getTitle();

        Assert.assertTrue(mainPageTitle.contentEquals(mainPageTitleAfterNavigation));


    }
    @Test(groups = "smoke")
    public void testTwo() {
        System.out.println("smoke");
        /*
        Test Case 2 - Automate all the Menu links of techlistic.com

            Steps to Automate:
            1. Launch browser of your choice say., firefox, chrome etc. ✓
            2. Open this URL -  https://www.techlistic.com/ ✓
            3. Maximize or set size of browser window. ✓
            4. Click on 'Java Tutorial' link and validate page title. ✓
            5. Navigate back to Home Page. ✓
            6. Click on 'Selenium Tutorial' link and validate page title.✓
            7. Navigate back to Home Page.✓
            8. Click on 'Selenium Blogs' link and validate page title.
            9. Navigate back to Home Page.
            10. Click on 'TestNG Blogs' link and validate page title.
            11. Close the browser.
        */
        String javaPageTitle = "Java Tutorial For Beginners - Techlistic";
        String seleniumPageTitle = "Selenium Webdriver Tutorial - Techlistic";
        String seleniumBlogPageTitle = "Best Selenium Blogs";
        String testNgBlogTitle = "Selenium-TestNG Framework Tutorial";
        driver.get("https://www.techlistic.com/");
        driver.manage().window().maximize();

        TechListicMainPage mainPage = new TechListicMainPage(driver);

        mainPage.clickOnJavaLink();
        Assert.assertEquals(javaPageTitle,driver.getTitle());
        driver.navigate().back();
        System.out.println("java done");


        mainPage.clickOnSeleniumLink();
        Assert.assertEquals(driver.getTitle(),seleniumPageTitle);
        driver.navigate().back();
        System.out.println("selenium done ");

        mainPage.clickOnSeleniumBlogsLink();
        Assert.assertEquals(driver.getTitle(),seleniumBlogPageTitle);
        driver.navigate().back();
        System.out.println("blog done ");

        mainPage.clickOnTestNgLink();
        Assert.assertEquals(driver.getTitle(),testNgBlogTitle);
        driver.navigate().back();
        System.out.println("testng done ");







    }


    @AfterTest
    public void tearDownTest(){
        driver.quit();

    }


}
