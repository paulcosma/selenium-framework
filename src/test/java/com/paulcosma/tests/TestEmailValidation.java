package com.paulcosma.tests;

import base.BaseTest;
import data.CsvDataProvider;
import data.com.paulcosma.Constants;
import data.com.paulcosma.EmailData;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.com.paulcosma.HomePage;

import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class TestEmailValidation extends BaseTest {
    public static Logger log = LogManager.getLogger(TestEmailValidation.class.getName());

    @Test(dataProvider = "validEmails", dataProviderClass = EmailData.class)
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
}
