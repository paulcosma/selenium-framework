package pages.tk.bebeonline;

import base.BasePageObject;
import data.tk.bebeonline.Constants;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePageObject<HomePage> {
    public static Logger log = LogManager.getLogger(HomePage.class.getName());
    // Page elements description - used for test steps and clarity of errors.
    private String logoDescription = "HomePage Logo";
    // Page elements.
    private By logo = By.id("logo");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openHomePage() {
        log.info("Steps to reproduce:");
        log.info("Step: Go to homepage: " + Constants.URL);
        goTo(Constants.URL, "home");
        return this;
    }

    public HomePage waitForHomePageToLoad() {
        log.info("Step: Wait for Home Page to load");
        waitForVisibilityOf(logo, logoDescription);
        return this;
    }
}
