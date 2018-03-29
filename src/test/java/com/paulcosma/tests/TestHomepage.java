package com.paulcosma.tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.com.paulcosma.HomePage;

public class TestHomepage extends BaseTest {


    @Test
    public void homepageLoaded() {
        HomePage homePage = new HomePage(driver);
        homePage
                .openHomePage();
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
