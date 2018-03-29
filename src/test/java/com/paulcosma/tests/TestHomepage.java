package com.paulcosma.tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.com.paulcosma.HomePage;

public class TestHomepage extends BaseTest {


    @Test
    public void homepageLoaded() {
        HomePage homePage = new HomePage(driver);
        String expectedPageTitle = "Paul Cosma";

        homePage
                .openHomePage()
                .waitForHomePageToLoad();
        String actualPageTitle = homePage.getTitle();
//        Assert.assertTrue(expectedPageTitle.equals(actualPageTitle), "\nPage title does not match.\nExpected: " +
//                expectedPageTitle + " \nActual: " + actualPageTitle + "\n");
//        Assert.assertEquals(expectedPageTitle,actualPageTitle);
        Assert.assertTrue(homePage.isCorrectPageTitleDisplayed(expectedPageTitle), "Page title does not match");
    }

    @Test
    public void enterInvalidEmail() {
        HomePage homePage = new HomePage(driver);
        homePage
                .openHomePage()
                .waitForHomePageToLoad()
                .enterEmail("invalid")
                .clickGetNotification();
    }

}
