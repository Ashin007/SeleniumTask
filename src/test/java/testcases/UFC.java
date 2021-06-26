package testcases;

import ExcelUtil.ExcelUtility;
import base.Base;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class UFC extends Base {
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
    public void UfcAuthenticationTest() throws IOException, InterruptedException {


        ExcelPOItest excel = new ExcelPOItest();
        ArrayList<String> email;
        ArrayList<String> password;
        email = excel.getColumnData("C:\\Users\\ashin\\Downloads\\AuthenticationTest.xlsx","UFC","Email");
        password = excel.getColumnData("C:\\Users\\ashin\\Downloads\\AuthenticationTest.xlsx","UFC","Pssword");



        for(int i=0;i<email.size();i++) {
            driver.get("https://ufcfightpass.com/login");
            driver.findElement(By.id("email")).sendKeys(email.get(i));
            driver.findElement(By.id("secret")).sendKeys(password.get(i));
            driver.findElement(By.xpath("//input[@type='submit']")).click();
            Thread.sleep(3000);
            if(driver.findElement(By.xpath("//a[@class='logged-in']")).isDisplayed()){

                System.out.println(driver.getCurrentUrl());
                System.out.println(driver.getTitle());
                driver.get("https://ufcfightpass.com/account");

                Thread.sleep(4000);
                String loc = "C:\\Users\\ashin\\Downloads\\src\\"+email.get(i)+".png";
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                try {
                    FileUtils.copyFile(screenshot, new File(loc));
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

                driver.findElement(By.xpath("//a[@class='logout-btn smart-link']")).click();
                System.out.println("PASS");
            }
            else{
                System.out.println("failed");
            }
        }

    }

//    @AfterTest
//    public void tearDownTest(){
//        driver.quit();
//
//    }
}
