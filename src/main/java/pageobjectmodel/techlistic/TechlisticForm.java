package pageobjectmodel.techlistic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TechlisticForm {

    WebDriver driver;
    By firstName = By.xpath("//input[@name='firstname']");
    By lastName = By.xpath("//input[@name='lastname']");

    By sexMale = By.xpath("//input[@id='sex-0']");
    By sexFemale = By.xpath("//input[@id='sex-1']");

    By radioExperience = By.xpath("//input[@id='exp-1']");

    By dateElement = By.xpath("//input[@id = 'datepicker']");
    By professionElement = By.xpath("//input[@id = 'profession-1']");
    By continentDropdown = By.xpath("//select[@name= 'continents']");
    By toolElement = By.xpath("//input[@id= 'tool-2']");
    By commandOptions = By.xpath("//select[@id= 'selenium_commands']");
    By fileUploadElement = By.xpath("//input[@type= 'file']");

    public TechlisticForm(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFirstNameBox(){
        return driver.findElement(firstName);
    }
    public WebElement getLastNameBox(){
        return driver.findElement(lastName);
    }

    public WebElement getSexMale(){
        return driver.findElement(sexMale);
    }
    public WebElement getSexFemale(){
        return driver.findElement(sexFemale);
    }
    public WebElement getRadioExp(){
        return driver.findElement(radioExperience);
    }
    public WebElement getDateElement(){
        return driver.findElement(dateElement);
    }
    public WebElement getProfessionElement(){
        return driver.findElement(professionElement);
    }
    public WebElement getContinentDropDown(){
        return driver.findElement(continentDropdown);
    }
    public WebElement getTool(){
        return driver.findElement(toolElement);
    }
    public WebElement getCommandOptions(){
        return driver.findElement(commandOptions);
    }
    public WebElement getFileUploadElement(){
        return driver.findElement(fileUploadElement);
    }
}
