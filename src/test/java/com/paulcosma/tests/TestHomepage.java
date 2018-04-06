package com.paulcosma.tests;

import base.BaseTest;
import data.CsvDataProvider;
import data.com.paulcosma.Constants;
import data.com.paulcosma.HomepageData;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.com.paulcosma.HomePage;

import java.util.Map;

import static org.testng.Assert.*;

public class TestHomepage extends BaseTest {
    public static Logger log = LogManager.getLogger(TestHomepage.class.getName());

    @Test
    public void homepageLoaded() {
        HomePage homePage = new HomePage(driver);
        homePage
                .openHomePage()
                .waitForHomePageToLoad();

        assertEquals(homePage.getCurrentUrl(), Constants.URL);
        assertEquals(homePage.getTitle(), Constants.HOMEPAGE_TITLE);
        //if you use JUnit, put the expected value first. If you use TestNG, put the actual value first.
    }

    @Test
    public void homepageElementsLoaded() {
        HomePage homePage = new HomePage(driver);
        homePage
                .openHomePage()
                .waitForHomePageToLoad();
        Boolean isLogoDisplayed = homePage.isLogoDisplayed();
        assertTrue(isLogoDisplayed, "\nLogo is not displayed.\nActual: Logo is displayed = " + isLogoDisplayed +
                "\nExpected: Logo is displayed = " + "true" + "\n");
        assertEquals(homePage.getHelloMessage(), Constants.HELLO_MESSAGE);
        assertEquals(homePage.getFooterMessage(), Constants.FOOTER_MESSAGE);
    }

    @Test(dataProvider = "validEmails", dataProviderClass = HomepageData.class)
    public void enterValidEmail(String email, String testNumber) {
        log.info("Test enterValidEmail number #" + testNumber + " with email = " + email);
        HomePage homePage = new HomePage(driver);
        homePage
                .openHomePage()
                .waitForHomePageToLoad()
                .enterEmail(email)
                .clickGetNotification();
        assertEquals(homePage.getAlertText(), Constants.EMAIL_ALERT_VALID);
        homePage.acceptAlert();
        Boolean isAlertDisplayed = homePage.isAlertDisplayed();
        assertFalse(isAlertDisplayed, "\nAlert is not closed.\nActual: Alert is displayed = " + isAlertDisplayed +
                "\nExpected: Alert is displayed = " + "false" + "\n");
    }

    @Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
    public void enterInvalidEmail(Map<String, String> testData) {
        String testNumber = testData.get("no");
        String email = testData.get("email");
        String description = testData.get("description");
        log.info("Test enterInvalidEmail number #" + testNumber + " with: " + description + " where email" + " " +
                "= " + email);

        HomePage homePage = new HomePage(driver);
        homePage
                .openHomePage()
                .waitForHomePageToLoad()
                .enterEmail(email)
                .clickGetNotification();
        assertEquals(homePage.getAlertText(), Constants.EMAIL_ALERT_INVALID);
        homePage.acceptAlert();
        Boolean isAlertDisplayed = homePage.isAlertDisplayed();
        assertFalse(isAlertDisplayed, "\nAlert is not closed.\nActual: Alert is displayed = " + isAlertDisplayed +
                "\nExpected: Alert is displayed = " + "false" + "\n");
    }

    @Ignore
    @Test
    public void openSocialLinks() {
        HomePage homePage = new HomePage(driver);
        homePage
                .openHomePage()
                .waitForHomePageToLoad();

    }

    @Ignore
    @Test
    public void openFooterLink() {
        HomePage homePage = new HomePage(driver);
        homePage
                .openHomePage()
                .waitForHomePageToLoad();

    }

}
