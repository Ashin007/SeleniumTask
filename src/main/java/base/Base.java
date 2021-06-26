package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    WebDriver driver;
    Properties properties;

    public WebDriver initialize() throws IOException {

        properties = new Properties();
        FileInputStream propertiesFile = new FileInputStream("C:\\Users\\ashin\\Documents\\SeleniumTasks\\src\\main\\resources\\data.properties");
        properties.load(propertiesFile);
        String data = properties.getProperty("browser");


        if(data.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\ashin\\Documents\\Software Testing\\chromedriver\\chromedriver.exe");
            driver = new ChromeDriver(options);
        }
        else if (data.equalsIgnoreCase("firefox")){

            System.setProperty("webdriver.gecko.driver","C:\\Users\\ashin\\Documents\\Software Testing\\geckodriver\\geckodriver.exe");
            driver=new FirefoxDriver();
        }
        else{
            System.out.println("----WebDriver Not Found----");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }
}
