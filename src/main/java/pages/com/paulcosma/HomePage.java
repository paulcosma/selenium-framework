package pages.com.paulcosma;

import base.BasePageObject;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePageObject<HomePage> {
    private static final String URL = "https://paulcosma.com";
    public static Logger log = LogManager.getLogger(HomePage.class.getName());
    // Page elements
    private By emailField = By.id("exampleInputEmail1");
    private By getNotified = By.cssSelector("input[type='submit']");
    private By logo = By.xpath("//img[@alt='Paul Cosma Logo']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openHomePage() {
        log.info("Steps to reproduce:");
        log.info("Step: Go to page: " + URL);
        getPage(URL);
        return this;
    }

    public HomePage enterEmail(String email) {
        log.info("Step: Enter: " + email + " on Enter your email address field");
        System.out.println("vaca1 " + emailField.toString());
        type(email, emailField);
        return this;
    }

    public HomePage clickGetNotification() {
        log.info("Step: Click on Get notified! button");
        click(getNotified);
        return this;
    }

    public HomePage waitForHomePageToLoad() {
        log.info("Step: Wait for Home Page to load, logo to be displayed and enter your email address field" +
                " to be displayed");
        waitForVisibilityOf(logo);
        waitForVisibilityOf(emailField, 10);
        return this;
    }

    public boolean isCorrectPageTitleDisplayed(String correctPageTitle) {
        String actualPageTitle = getTitle();
        log.info("Step: Verify page title");
        log.info("Expected result: " + "Page title is " + correctPageTitle);
        log.info("Actual result: " + "Page title is " + actualPageTitle);
        if (actualPageTitle.equals(correctPageTitle)) {
            return true;
        }
        return false;
    }
}
