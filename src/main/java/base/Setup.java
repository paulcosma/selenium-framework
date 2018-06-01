package base;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;

public class Setup {
    public static Logger log = LogManager.getLogger(Setup.class.getName());
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void handleTestMethodName(Method method) {
        String testName = method.getName();
        log.info("@Test = " + testName);
    }

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    protected void setUp(String browser) {
        log.debug("SetUp driver");
        driver = BrowserFactory.getDriver(browser);
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDown(Method method) {
        MyDriver myDriver = new MyDriver(driver);
        String testName = method.getDeclaringClass().getSimpleName() + "_" + method.getName();
        myDriver.takeScreenshot(testName);
        log.debug("Quit driver");
        driver.quit();
    }
}
