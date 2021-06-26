package testcases;

import ExcelUtil.ExcelUtility;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class SampleTest {
    @Test
    public void getDataFromExcel() throws IOException {

        ExcelUtility excel = new ExcelUtility();
        ArrayList<String> emails;
        ArrayList<String> passwords;
        emails = excel.getColumnData("C:\\Users\\ashin\\Downloads\\AuthenticationTest.xlsx", "NetFlix", "Email");
        passwords = excel.getColumnData("C:\\Users\\ashin\\Downloads\\AuthenticationTest.xlsx", "NetFlix", "Password");


        for (String email:emails){
            System.out.println(email);
        }
        System.out.println(emails.size());

        for (String pass:passwords){
            System.out.println(pass);
        }
        System.out.println(passwords.size());


    }
}
