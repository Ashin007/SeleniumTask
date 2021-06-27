package testcases;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.List;

public class PopulationTest extends Base {

    WebDriver driver;

    @BeforeTest
    public void initializeTest() throws IOException {

        driver = initialize();
    }
    @AfterMethod
    public void timeout() throws InterruptedException {
        Thread.sleep(3000);
    }

    @Test
    public void mainTest(){

        driver.get("https://worldpopulationreview.com/");
//        WebElement element = driver.findElements(By.xpath("//table[@class='jsx-1487038798 table table-striped tp-table-body']")).get(0);
//        List<WebElement> dataList = element.findElements(By.tagName("tr"));
//
//        for (WebElement webElement:dataList){
//            System.out.println(webElement.getText());
//        }


        String heading_xpath_first = "//*[@id='liveWorldPop']/div[1]/div/div/div/div/div[2]/div[2]/div[2]/table/thead/tr/th[";
        String heading_xpath_last = "]/span/a";

        String table_row_first = "//*[@id='liveWorldPop']/div[1]/div/div/div/div/div[2]/div[2]/div[2]/table/tbody/tr[";
        String table_row_last = "]/td[";
        String table_data_last = "]";
        int k=0;

        for(int i=1;i<=232;i++){

            for(int j=1;j<10;j++){
                System.out.print(driver.findElement(By.xpath(heading_xpath_first+j+heading_xpath_last)).getText()+"  : ");
                System.out.println(driver.findElement(By.xpath(table_row_first+i+table_row_last+j+table_data_last)).getText());

            }
        }



    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }


}
