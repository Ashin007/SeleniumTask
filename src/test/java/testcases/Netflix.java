package testcases;

import ExcelUtil.ExcelUtility;
import base.Base;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Netflix extends Base {
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
    public void NetflixAuthenticationTest() throws IOException, InterruptedException {


        ExcelUtility excel = new ExcelUtility();
        ArrayList<String> email;
        ArrayList<String> password;
        email = excel.getColumnData("C:\\Users\\ashin\\Downloads\\AuthenticationTest.xlsx","NetFlix","Email");
        password = excel.getColumnData("C:\\Users\\ashin\\Downloads\\AuthenticationTest.xlsx","NetFlix","Password");

        Actions actions = new Actions(driver);

        for(int i=0;i<10;i++) {
            driver.get("https://www.netflix.com/login");
            driver.findElement(By.xpath("//input[@name='userLoginId']")).sendKeys(email.get(i));
            driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password.get(i));
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Thread.sleep(3000);


            if(driver.getCurrentUrl().contentEquals("https://www.netflix.com/browse")){
                System.out.println("login success");
//                if(driver.findElements(By.xpath("//a[@class='profile-link']")).get(0).isDisplayed())
//                driver.findElements(By.xpath("//a[@class='profile-link']")).get(0).click();
                Thread.sleep(4000);
                driver.get("https://www.netflix.com/YourAccount");

                Thread.sleep(4000);
                String loc = "C:\\Users\\ashin\\Downloads\\src\\netflix\\"+email.get(i)+".png";
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                try {
                    FileUtils.copyFile(screenshot, new File(loc));
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                driver.get("https://www.netflix.com/SignOut");
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

