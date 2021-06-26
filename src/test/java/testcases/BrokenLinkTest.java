package testcases;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BrokenLinkTest extends Base {
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
    public void brokenLinkTestWikipedia() throws IOException {
        driver.get("https://en.wikipedia.org/wiki/Mohanlal");
        HttpURLConnection connection;
        String urlLink;
        String responseMessage;

        List<WebElement> linkList = driver.findElements(By.tagName("a"));
        for (WebElement links:linkList) {
            if(!(links.getAttribute("href")==null)){
                //System.out.println(links.getAttribute("href"));

                connection = (HttpURLConnection) new URL(links.getAttribute("href")).openConnection();
                responseMessage = connection.getResponseMessage();
                System.out.println(links.getAttribute("href") + "--->: " + responseMessage);
                connection.disconnect();

            }

        }
    }







    @AfterTest
    public void tearDownTest(){
        driver.quit();

    }
}
