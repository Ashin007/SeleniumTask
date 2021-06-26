package testcases;

import base.Base;
import downloadtasks.DownloadImage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class GoogleImage extends Base {
    WebDriver driver;

    @BeforeTest
    public void initializeTest() throws IOException {
        driver = initialize();
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void timeOut() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test
    public void getImage() throws IOException, InterruptedException {
        //search key word
        String search = "Keralam";
        String path="C:\\Users\\ashin\\Downloads\\src\\Google Images\\"+search+"\\";
        File file = new File(path);

        Random random = new Random();


        //opening google image
        driver.get("https://www.google.co.in/imghp");
        //passing the search keyword
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(search);
        driver.findElement(By.xpath("//span[@class='z1asCe MZy1Rb']")).click();

        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);

        //get all the image div elements
        List<WebElement> links = driver.findElements(By.xpath("//a[@jsname='sTFXNd']"));
        DownloadImage downloadImage = new DownloadImage();
        Actions actions = new Actions(driver);

        for (int i =0; i<links.size();i++){
            //random number for unique image name
            int m = random.nextInt(1000);
            int l = random.nextInt(1000);

            //open link in new tab
            actions.moveToElement(links.get(i)).click().keyDown(Keys.CONTROL).keyDown(Keys.ALT).build().perform();

            //first link is not openable
            if(i==0)
                continue;


            //get window handler ids
            Set<String> ids = driver.getWindowHandles();
            Iterator<String>iterator = ids.iterator();
            String parent = iterator.next();
            String child = iterator.next();

            //switch to new tab
            driver.switchTo().window(child);

            //get the image url and pass to the download image api
            String imgUrl = driver.findElement(By.xpath("//img[@class='n3VNCb']")).getAttribute("src");

            //url validation
            if(imgUrl!=null && imgUrl.startsWith("https://")) {
                //creating new directory if its not exists
                if (!file.exists()) {
                    file.mkdir();
                }
                downloadImage.downloadImageFromLink(imgUrl, "C:\\Users\\ashin\\Downloads\\src\\Google Images\\"+search+"\\" + search + m +""+l+".jpg");
            }
            else
                System.out.println("something wrong");
            driver.close();

            //change focus to the parent tab
            driver.switchTo().window(parent);

        }
    }


    @AfterTest
    public void tearDownTest(){
        driver.quit();

    }
}
