package pages.tk.bebeonline;

import base.MyDriver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends MyDriver<HomePage> {
    public static Logger log = LogManager.getLogger(HomePage.class.getName());
    // Page elements.
    private By logo = By.id("logo");
    // Page elements description - used for test steps and clarity of errors.
    private String logoDescription = "HomePage Logo";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage waitForHomePageToLoad() {
        log.info("Step: Wait for Home Page to load");
        waitForVisibilityOf(logo, logoDescription);
        return this;
    }
}
