package pageobjectmodel.worldpopulation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WorldPopulation {

    //web driver reference
    private WebDriver driver;

    //raw xpath of row and column
    private String table_row_xpath = "//*[@id='liveWorldPop']/div[1]/div/div/div/div/div[2]/div[2]/div[2]/table/tbody/tr";
    private String table_col_xpath = "//*[@id='liveWorldPop']/div[1]/div/div/div/div/div[2]/div[2]/div[2]/table/thead/tr/th";


    private By table_row = By.xpath(table_row_xpath);
    private By table_col = By.xpath(table_col_xpath);

    //splitting col xpath
    private String heading_xpath_first = table_col_xpath + "[";
    private String heading_xpath_last = "]/span/a";

    //splitting row xpath
    private String table_row_first = table_row_xpath + "[";
    private String table_row_last = "]/td[";
    private String table_data_last = "]";

    public WorldPopulation(WebDriver driver) {
        this.driver = driver;
    }

    public int getTable_row_size() {
        return driver.findElements(table_row).size();

    }

    public int getTable_col_size() {
        return driver.findElements(table_col).size();
    }

    public void getTableData() {
        for (int i = 1; i <= getTable_row_size(); i++) {
            for (int j = 1; j < getTable_col_size(); j++) {
                System.out.print(driver.findElement(By.xpath(heading_xpath_first + j + heading_xpath_last)).getText() + "  : ");
                System.out.println(driver.findElement(By.xpath(table_row_first + i + table_row_last + j + table_data_last)).getText());

            }
        }
    }
}
