package com.paulcosma.tests;

import base.BaseTest;
import base.CsvDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.com.paulcosma.HomePage;

import java.util.Map;

public class TestHomepage extends BaseTest {


    @Test
    public void homepageLoaded() {
        HomePage homePage = new HomePage(driver);
        String expectedPageTitle = "Paul Cosma";

        homePage
                .openHomePage()
                .waitForHomePageToLoad();
//        String actualPageTitle = homePage.getTitle();
//        Assert.assertTrue(expectedPageTitle.equals(actualPageTitle), "\nPage title does not match.\nExpected: " +
//                expectedPageTitle + " \nActual: " + actualPageTitle + "\n");
//        Assert.assertEquals(expectedPageTitle,actualPageTitle);
        Assert.assertTrue(homePage.isCorrectPageTitleDisplayed(expectedPageTitle), "Page title does not match");
    }

    @Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
    public void enterInvalidEmail(Map<String, String> testData) {
        String testNumber = testData.get("no");
        String email = testData.get("email");
        String description = testData.get("description");

        System.out.println("Test enterInvalidEmail number #" + testNumber + " with: " + description + " where \nEmail" +
                " " +
                "= " + email);

        HomePage homePage = new HomePage(driver);
        homePage
                .openHomePage()
                .waitForHomePageToLoad()
                .enterEmail(email)
                .clickGetNotification();
    }

}
