package testcases;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjectmodel.techlistic.TechlisticForm;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

public class AssignmentThree extends Base {

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
    public void testOne(){

       /*
       Steps to automate:
        1.Open this link - https://www.techlistic.com/p/selenium-practice-form.html ✓
        2.Enter first and last name (textbox).✓
        3.Select gender (radio button).✓
        4.Select years of experience (radio button).✓
        5.Enter date.✓
        6.Select Profession (Checkbox).✓
        7.Select Automation tools you are familiar with (multiple checkboxes).✓
        8.Select Continent (Select box).✓
        9.Select multiple commands from a multi select box.✓
        10.If you can handle Upload image then try it or leave this step.✓
        11.Click on Download file link and handle the download file pop-up (leave it if you are beginner).
        12.Click on Submit button.
        */

       driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

        TechlisticForm techlisticForm = new TechlisticForm(driver);
        techlisticForm.getFirstNameBox().sendKeys("Ashin");
        techlisticForm.getLastNameBox().sendKeys("Vijayan");

        techlisticForm.getSexMale().click();

        techlisticForm.getRadioExp().click();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();

        techlisticForm.getDateElement().sendKeys(dtf.format(now));

        techlisticForm.getProfessionElement().click();

        techlisticForm.getTool().click();

        Select selectContinent = new Select(techlisticForm.getContinentDropDown());
        selectContinent.selectByIndex(2);

        Select selectCommand = new Select(techlisticForm.getCommandOptions());
        List<WebElement>elementOptions = selectCommand.getOptions();
        for (WebElement elementOption : elementOptions) {
            elementOption.click();
        }

        techlisticForm.getFileUploadElement().sendKeys("C:\\Users\\ashin\\Documents\\SeleniumTasks\\src\\main\\resources\\images.png");
    }



    @AfterTest
    public void tearDownTest(){
        driver.quit();

    }
}
