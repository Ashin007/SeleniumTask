package testcases;

import org.testng.annotations.*;

public class TestNGSample1 {



    @BeforeTest(groups = {"smoke"})
    public void beforeTest(){
        System.out.println("Before Test");
    }
    @Test(groups = {"smoke"})
    public void testOne(){

        System.out.println("Sample 1: Test One");
    }
    @Test
    public void testTwo(){
        System.out.println("Sample 1: Test Two");
        System.out.println("Executing me before : sample 1 test five because he is depends on me");
    }
    @Test(groups = {"smoke"})
    public void testThree(){
        System.out.println("Sample 1: Test Three");
    }
    @Test(groups = {"smoke"})
    public void testFour(){
        System.out.println("Sample 1: Test Four");
    }
    @Test(dependsOnMethods = {"testTwo"})
    public void testFive(){
        System.out.println("Sample 1: Test Five");
    }
    @AfterTest(groups = {"smoke"})
    public void afterTest(){
        System.out.println("After Test");
    }
    @BeforeMethod(groups = {"smoke"})
    public void beforeMethod(){
        System.out.println("before each method");
    }
    @AfterClass(groups = {"smoke"})
    public void afterClass(){
        System.out.println("after class");
    }
    @BeforeClass(groups = {"smoke"})
    public void beforeClass() {
        System.out.println("Before class");
    }
    @AfterMethod(groups = {"smoke"})
    public void afterMethod(){
        System.out.println("after each method");
    }
    @BeforeSuite(groups = {"smoke"})
    public void beforeSuite(){
        System.out.println("Before Suite");
    }
    @AfterSuite(groups = {"smoke"})
    public void afterSuite(){
        System.out.println("After Suite");
    }
    @BeforeGroups(groups = {"smoke"})
    public void beforeGroup(){
        System.out.println("before group");
    }
    @AfterGroups(groups = {"smoke"})
    public void afterGroup(){
        System.out.println("after group");
    }

}
