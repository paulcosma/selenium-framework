package base;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;

public class BaseTest {
    public static Logger log = LogManager.getLogger(BaseTest.class.getName());
    protected WebDriver driver;

    @BeforeMethod
    public void handleTestMethodName(Method method)
    {
        String testName = method.getName();
        log.info("@Test = " + testName);
    }

    @Parameters({"browser"})
    @BeforeMethod
    protected void setUp(String browser) {
        log.debug("SetUp driver");
        driver = BrowserFactory.getDriver(browser);
    }

    @AfterMethod
    protected void tearDown() {
        log.debug("Quit driver");
        driver.quit();
    }
}
