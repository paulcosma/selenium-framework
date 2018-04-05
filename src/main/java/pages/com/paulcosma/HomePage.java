package pages.com.paulcosma;

import base.BasePageObject;
import data.com.paulcosma.Constants;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePageObject<HomePage> {
    public static Logger log = LogManager.getLogger(HomePage.class.getName());
    //page elements
    private By logo = By.xpath("//img[@alt='Paul Cosma Logo']");
    private By emailField = By.id("exampleInputEmail1");
    private By getNotifiedButton = By.cssSelector("input[type='submit']");

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
        log.info("Step: Wait for Home Page to load, logo to be displayed and enter your email address field" +
                " to be displayed");
        waitForVisibilityOf(logo, "HomePage Logo");
        waitForVisibilityOf(emailField, "Enter your email address field", 30);
        return this;
    }

    public HomePage enterEmail(String email) {
        log.info("Step: Enter: " + email + " on Enter your email address field");
        type(email, emailField, "Enter your email address field");
        return this;
    }

    public HomePage clickGetNotification() {
        log.info("Step: Click on Get notified! button");
        click(getNotifiedButton, "Get notified! button");
        return this;
    }

    public boolean isCorrectPageTitleDisplayed(String correctPageTitle) {
        String actualPageTitle = getTitle();
        log.info("Step: Verify page title");
        log.info("Actual result: " + "Page title is " + actualPageTitle);
        log.info("Expected result: " + "Page title is " + correctPageTitle);
        if (actualPageTitle.equals(correctPageTitle)) {
            return true;
        }
        return false;
    }
}
