package pages.com.paulcosma;

import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePageObject<HomePage> {
    private static final String URL = "https://paulcosma.com";
    // Page elements
    private By emailFIeld = By.id("exampleInputEmail1");
    private By getNotified = By.cssSelector("input[type='submit']");
    private By logo = By.xpath("//img[@alt='Paul Cosma Logo']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openHomePage() {
        driver.get(URL);
        return this;
    }

    public HomePage enterEmail(String email) {
        type(email, emailFIeld);
        return this;
    }

    public HomePage clickGetNotification() {
        click(getNotified);
        return this;
    }

    public HomePage waitForHomePageToLoad() {
        waitForVisibilityOf(logo);
        waitForVisibilityOf(emailFIeld, 10);
        return this;
    }
}
