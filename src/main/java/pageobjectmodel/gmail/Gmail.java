package pageobjectmodel.gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Gmail {

    private WebDriver driver;
    private By signInElement = By.linkText("Sign in\n" +
            "  ");
    private By emailElement = By.cssSelector("input[type='email']");
    private By nextElement = By.cssSelector("span[jsname='V67aGc']");
    private By moreWayToSign = By.cssSelector("span[jsname='V67aGc']");
    private By enterPasswordElement = By.xpath("//div[text()='Enter your password' and @class='vxx8jf']");
    private By passwordElement = By.cssSelector("input[type='password']");


    public Gmail(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOnSignInElement(){
        driver.findElement(signInElement).click();
    }


    public WebElement typeOnEmailElement(){
        return driver.findElement(emailElement);

    }
    public void clickOnNext(){
        driver.findElement(nextElement).click();
    }
    public void clickOnMoreWayToSignIn(){
        driver.findElement(moreWayToSign).click();
    }
    public void clickOnPassword(){
        driver.findElement(enterPasswordElement).click();
    }
    public WebElement typeOnPasswordElement(){
        return driver.findElement(passwordElement);
    }
}
