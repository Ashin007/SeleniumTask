package testcases;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class ScreenShotSample extends Base {
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
    public void showRandomSS() throws InterruptedException {

        int otta;
        int pattu;
        int nooru;
        int aayiram;

        for (aayiram=0;aayiram<10;aayiram++){
            for (nooru=0;nooru<10;nooru++){
                for (pattu=0;pattu<10;pattu++){
                    for (otta=0;otta<10;otta++){
                        System.out.println(aayiram+""+nooru+""+pattu+""+otta);
                        driver.get("https://prnt.sc/lo"+""+aayiram+""+nooru+""+pattu+""+otta);
                    }
                }
            }
        }

            //Thread.sleep(2000);

            //

    }


    @AfterTest
    public void tearDownTest(){
        driver.quit();

    }
}
