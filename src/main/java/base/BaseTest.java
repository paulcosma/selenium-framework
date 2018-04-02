package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;

    @Parameters({"browser"})
    @BeforeMethod
    protected void methodSetUp(String browser) {
        driver = BrowserFactory.getDriver(browser);
    }

    @AfterMethod
    protected void methodTearDown() {
        driver.quit();
    }
}
