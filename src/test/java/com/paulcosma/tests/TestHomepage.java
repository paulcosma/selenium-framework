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

import static org.testng.Assert.assertEquals;

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
//        String actualUrl = homePage.getCurrentUrl();
//        String actualPageTitle = homePage.getTitle();
//        Assert.assertTrue(expectedPageTitle.equals(actualPageTitle), "\nPage title does not match.\nExpected: " +
//                expectedPageTitle + " \nActual: " + actualPageTitle + "\n");
//        Assert.assertTrue(homePage.isCorrectPageTitleDisplayed(expectedPageTitle), "Page title does not match");
    }

    @Ignore
    @Test
    public void homepageElementsLoaded() {
        //Verify Logo is displayed
        //Verify Hello message is displayed
        //Verify footer message is displated
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
//        assertTrue(homePage.isAlertPresent());
//        log.info("Expected result: " + "Alert is displayed = true");
//        homePage.acceptAlert();
//        assertFalse(homePage.isAlertPresent());
//        log.info("Expected result: " + "Alert is displayed = false");
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
//        assertTrue(homePage.isAlertPresent());
//        log.info("Expected result: " + "Alert is displayed = true");
//        homePage.acceptAlert();
//        assertFalse(homePage.isAlertPresent());
//        log.info("Expected result: " + "Alert is displayed = false");
    }

    @Ignore
    @Test
    public void openSocialLinks() {

    }

    @Ignore
    @Test
    public void openFooterLink() {

    }

}
