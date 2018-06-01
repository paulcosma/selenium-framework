package pages.tk.cosma;

import base.MyDriver;
import data.tk.cosma.Constants;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends MyDriver<HomePage> {
    public static Logger log = LogManager.getLogger(HomePage.class.getName());
    // Page elements description - used for test steps and clarity of errors.
    private String logoDescription = "HomePage Logo";
    private String introTitleDescription = "HomePage Intro Title displayed below Logo";
    // Page elements.
    private By logo = By.className("logo");
    private By introTitle = By.cssSelector(".intro-title.black-text.text-uppercase");

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
        waitForVisibilityOf(introTitle, introTitleDescription, 30);
        return this;
    }

    public boolean isLogoDisplayed() {
        Boolean logoDisplayed = isDisplayed(logo, logoDescription);
        log.info("Step: Verify logo is displayed");
        return logoDisplayed;
    }

    public boolean isIntroTitleDisplayed() {
        Boolean logoDisplayed = isDisplayed(logo, logoDescription);
        log.info("Step: Verify intro title is displayed");
        return logoDisplayed;
    }

    public String getIntroTitleMessage() {
        log.info("Step: Get intro title message");
        return getText(introTitle, introTitleDescription);
    }
}
