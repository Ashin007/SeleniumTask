package testcases;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;

public class NoonTask extends Base {
    WebDriver driver;

    @BeforeTest(groups = {"smoke"})
    public void initializeTest() throws IOException {
        driver = initialize();
    }
    @AfterMethod(groups = {"smoke"})
    public void timeOut() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test(groups = {"smoke"})
    public void yourTest() throws InterruptedException {

      JavascriptExecutor js = (JavascriptExecutor) driver;

      Set<String> productList = new HashSet<String>();

        driver.get("https://www.noon.com/uae-en/");

        js.executeScript("window.scrollTo(0, document.body.scrollHeight/4)");
        Thread.sleep(10000);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight/2)");
        Thread.sleep(10000);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");


        List<WebElement> elementList = driver.findElements(By.xpath("//div[@class='swiper-wrapper' and @style='transform: translate3d(0px, 0px, 0px);']"));

        for (int i=0;i<driver.findElements(By.xpath("//div[@class='swiper-wrapper' and @style='transform: translate3d(0px, 0px, 0px);']")).size();i++) {
            WebElement containers = driver.findElements(By.xpath("//div[@class='swiper-wrapper' and @style='transform: translate3d(0px, 0px, 0px);']")).get(i);
            for(int j=0;j<containers.findElements(By.xpath("//div[@class='kcs0h5-0 diNcmV grid']")).size();j++){
                productList.add(containers.findElements(By.xpath("//div[@class='kcs0h5-0 diNcmV grid']")).get(j).getAttribute("title"));
            }
        }

        List<String>list = new ArrayList<String>(productList);
        Collections.sort(list);
        for (String product:list){
            System.out.println(product);
        }
    }









    @AfterTest(groups = {"smoke"})
    public void tearDownTest(){
        driver.quit();

    }
}
