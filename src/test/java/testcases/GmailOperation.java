package testcases;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjectmodel.gmail.Gmail;

import java.io.IOException;

public class GmailOperation extends Base {
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
    public void signInOnGmail(){
        driver.get("https://www.gmail.com");

        Gmail gmail = new Gmail(driver);
        //gmail.clickOnSignInElement();
        gmail.typeOnEmailElement().sendKeys("email");
        gmail.clickOnNext();
        gmail.clickOnMoreWayToSignIn();
        gmail.clickOnPassword();
        gmail.typeOnPasswordElement().sendKeys("password");
        gmail.clickOnNext();
    }


    @AfterTest
    public void tearDownTest(){
        driver.quit();

    }
}
