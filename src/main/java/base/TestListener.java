package base;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListener extends TestListenerAdapter {

    @Override
    public void onTestSuccess(ITestResult var1) {
        System.out.println(var1.getTestContext().getClass().getName() + "Test Success");
    }

    @Override
    public void onTestFailure(ITestResult var1) {
        System.out.println(var1.getTestContext().getName() + "Test Failure");
    }

    @Override
    public void onStart(ITestContext var1) {
        System.out.println(var1.getName() + "Test Start");
    }

    @Override
    public void onFinish(ITestContext var1) {
        System.out.println(var1.getName() + "Test Finish");
    }
}
