package com.paulcosma.tests;

import base.Setup;
import data.com.paulcosma.Constants;
import navigator.Navigator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.com.paulcosma.HomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestHomepage extends Setup {
    public static Logger log = LogManager.getLogger(TestHomepage.class.getName());

    @Test
    public void homepageLoaded() {
        Navigator navigator = new Navigator(driver);

        navigator
                .paulcosma
                .goToHomePage()
                .waitForHomePageToLoad();
        assertEquals(navigator.getCurrentUrl(), Constants.URL);
        assertEquals(navigator.getTitle(), Constants.HOMEPAGE_TITLE);
        //if you use JUnit, put the expected value first. If you use TestNG, put the actual value first.
    }

    @Test
    public void homepageElementsLoaded() {
        Navigator navigator = new Navigator(driver);

        HomePage homePage = navigator
                .paulcosma
                .goToHomePage()
                .waitForHomePageToLoad();
        Boolean isLogoDisplayed = homePage.isLogoDisplayed();
        assertTrue(isLogoDisplayed, "\nLogo is not displayed.\nActual: Logo is displayed = " + isLogoDisplayed +
                "\nExpected: Logo is displayed = " + "true" + "\n");
        assertEquals(homePage.getHelloMessage(), Constants.HELLO_MESSAGE);
        assertEquals(homePage.getFooterMessage(), Constants.FOOTER_MESSAGE);
    }
}
