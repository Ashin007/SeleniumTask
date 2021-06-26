package testcases;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjectmodel.google.GoogleMainPage;

import java.io.IOException;
import java.util.List;

public class AssignmentFour extends Base {

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
    public void testOne(){
        /*
        Test Steps:
        1.Launch the chrome ✓
        2.Open URL - http://www.google.com ✓
        3.Enter keyword "Malayalam" in search bar ✓
        4.Wait for ajax suggestion box to appear ✓
        5.Get/store all the options of suggestion box in a list ✓
        6.Print all the suggestions one by one.✓
         */

        driver.get("http://www.google.com");
        GoogleMainPage mainPage = new GoogleMainPage(driver);
        mainPage.getSearchBox().sendKeys("Malayalam");
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPage.getSearchBoxElement()));

        List<WebElement> searchList = mainPage.getSearchLists();
        for (WebElement list : searchList){
            System.out.println(list.getText());
//            if (list.getText().equalsIgnoreCase("malayalam songs")){
//                list.click();
//                break;
//            }
        }



    }


    @AfterTest
    public void tearDownTest(){
        driver.quit();

    }
}
