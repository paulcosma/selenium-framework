package base;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListener extends TestListenerAdapter {
    public static Logger log = LogManager.getLogger(TestListener.class.getName());

    @Override
    public void onTestSuccess(ITestResult testResult) {
        log.info(testResult.getTestClass().getRealClass().getName() + " - "
                + testResult.getMethod().getMethodName()
                + " Test Success");
    }

    @Override
    public void onTestFailure(ITestResult testResult) {
        log.info(testResult.getTestClass().getRealClass().getName() + " - "
                + testResult.getMethod().getMethodName()
                + " Test Failure");
    }

    @Override
    public void onStart(ITestContext testContext) {
        log.info("Suite: " + testContext.getSuite().getName());
        log.info(testContext.getName() + " Test Start");
    }

    @Override
    public void onFinish(ITestContext testContext) {
        log.info("Suite: " + testContext.getSuite().getName());
        log.info(testContext.getName() + " Test Finish\n");
    }
}
