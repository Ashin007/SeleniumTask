package testcases;

import base.Base;
import downloadtasks.DownloadImage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

public class ThePersonDoesNotExit extends Base {

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

    @Test
    public void firstTask() throws IOException {
        Random random = new Random();
        int j=0;
        while (j<100) {
            int i = random.nextInt(1000);
            int k = random.nextInt(1000);

            DownloadImage image = new DownloadImage();
            image.downloadImageFromLink("https://thispersondoesnotexist.com/image", "C:\\Users\\ashin\\Downloads\\src\\This Persons Does Not Exists\\image" + i + k + ".jpg");
            j++;
        }
    }


    @AfterTest
    public void tearDownTest() {
        driver.quit();

    }

}
