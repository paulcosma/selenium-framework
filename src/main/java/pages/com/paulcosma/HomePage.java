package pages.com.paulcosma;

import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePageObject<HomePage> {
    private static final String URL = "https://paulcosma.com";
    // Page elements
    private By emailField = By.id("exampleInputEmail1");
    private By getNotified = By.cssSelector("input[type='submit']");
    private By logo = By.xpath("//img[@alt='Paul Cosma Logo']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openHomePage() {
        System.out.println("\nSteps to reproduce:");
        System.out.println("Step: Go to page: " + URL);
        driver.get(URL);
        return this;
    }

    public HomePage enterEmail(String email) {
        System.out.println("Step: Enter: " + email + " on Enter your email address field");
        type(email, emailField);
        return this;
    }

    public HomePage clickGetNotification() {
        System.out.println("Step: Click on Get notified! button");
        click(getNotified);
        return this;
    }

    public HomePage waitForHomePageToLoad() {
        System.out.println("Step: Wait for Home Page to load, logo to be displayed and enter your email address field" +
                " to be displayed");
        waitForVisibilityOf(logo);
        waitForVisibilityOf(emailField, 10);
        return this;
    }

    public boolean isCorrectPageTitleDisplayed(String correctPageTitle) {
        String actualPageTitle = getTitle();
        System.out.println("Step: Verify page title");
        System.out.println("\nExpected result: " + "Page title is " + correctPageTitle);
        System.out.println("Actual result: " + "Page title is " + actualPageTitle);
        if (actualPageTitle.equals(correctPageTitle)) {
            return true;
        }
        return false;
    }
}
