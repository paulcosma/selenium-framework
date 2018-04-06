package pages.com.paulcosma;

import base.BasePageObject;
import data.com.paulcosma.Constants;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.com.paulcosma.external.Facebook;

public class HomePage extends BasePageObject<HomePage> {
    public static Logger log = LogManager.getLogger(HomePage.class.getName());
    String facebookIconDescription = "Facebook icon";
    String twitterIconDescription = "Twitter icon";
    String githubIconDescription = "Github icon";
    String linkedinIconDescription = "Linkedin icon";
    //page elements
    private By logo = By.xpath("//img[@alt='Paul Cosma Logo']");
    private String logoDescription = "HomePage Logo";
    private By emailField = By.id("exampleInputEmail1");
    private String emailFieldDescription = "Enter your email address field";
    private By getNotifiedButton = By.cssSelector("input[type='submit']");
    private String getNotifiedButtonDescription = "Get notified! button";
    private By helloMessage = By.cssSelector(".subtitle");
    private String helloMessageDescription = "Hello! We'll be ready soon ... ";
    private By facebookIcon = By.cssSelector(".icoFacebook");
    private By twitterIcon = By.cssSelector(".icoTwitter");
    private By githubIcon = By.cssSelector(".icoGit");
    private By linkedinIcon = By.cssSelector(".icoLinkedin");
    private By footerMessage = By.cssSelector(".copyright");
    private String footerMessageDescription = "Powered by Bootstrap";
    private By footerLink = By.cssSelector(".copyright [target=_blank]");
    private String footerLinkDescription = "Link from footer";
    private By hiddenFooterElement = By.id("hiddenFooter");
    private String hiddenFooterElementDescription = "Hidden Footer element";

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
        waitForVisibilityOf(logo, logoDescription);
        waitForVisibilityOf(emailField, emailFieldDescription, 30);
        return this;
    }

    public HomePage enterEmail(String email) {
        log.info("Step: Enter: " + email + " on Enter your email address field");
        type(email, emailField, emailFieldDescription);
        return this;
    }

    public HomePage clickGetNotification() {
        log.info("Step: Click on Get notified! button");
        click(getNotifiedButton, getNotifiedButtonDescription);
        return this;
    }

    public boolean isLogoDisplayed() {
        Boolean logoDisplayed = isDisplayed(logo, logoDescription);
        log.info("Step: Verify logo is displayed");
        return logoDisplayed;
    }

    public boolean isHelloMessageDisplayed() {
        Boolean helloMessageDisplayed = isDisplayed(helloMessage, helloMessageDescription);
        log.info("Step: Verify Hello message is displayed");
        return helloMessageDisplayed;
    }

    public boolean isFooterMessageDisplayed() {
        Boolean footerMessageDisplayed = isDisplayed(footerMessage, footerMessageDescription);
        log.info("Step: Verify Footer message is displayed");
        return footerMessageDisplayed;
    }

    public String getHelloMessage() {
        log.info("Step: Get Hello message");
        return getText(helloMessage, helloMessageDescription);
    }

    public String getFooterMessage() {
        log.info("Step: Get Footer message");
        return getText(footerMessage, footerMessageDescription);
    }

    public Facebook clickFacebookIcon() {
        log.info("Step: Click Facebook icon");
        click(facebookIcon, facebookIconDescription);
        return new Facebook(driver);
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
