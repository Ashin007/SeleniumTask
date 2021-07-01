package testcases;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listners implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failure");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test Failed within limit");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("Test failed with time out");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Started - context");

    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test finished");
    }
}
