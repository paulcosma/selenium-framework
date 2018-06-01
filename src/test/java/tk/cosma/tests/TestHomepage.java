package tk.cosma.tests;

import base.Setup;
import data.tk.cosma.Constants;
import navigator.Navigator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.tk.cosma.HomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestHomepage extends Setup {
    public static Logger log = LogManager.getLogger(tk.cosma.tests.TestHomepage.class.getName());

    @Test
    public void homepageLoaded() {
        Navigator navigator = new Navigator(driver);

        navigator
                .cosma
                .goToHomepage()
                .waitForHomePageToLoad();
        assertEquals(navigator.getCurrentUrl(), Constants.URL);
        assertEquals(navigator.getTitle(), Constants.HOMEPAGE_TITLE);
    }

    @Test
    public void homepageElementsLoaded() {
        Navigator navigator = new Navigator(driver);

        HomePage homePage = navigator
                .cosma
                .goToHomepage()
                .waitForHomePageToLoad();
        Boolean isLogoDisplayed = homePage.isLogoDisplayed();
        assertTrue(isLogoDisplayed, "\nLogo is not displayed.\nActual: Logo is displayed = " + isLogoDisplayed +
                "\nExpected: Logo is displayed = " + "true" + "\n");
        Boolean isIntroTitleDisplayed = homePage.isIntroTitleDisplayed();
        assertTrue(isIntroTitleDisplayed, "\nIntro Title is not displayed.\nActual: Intro Title is displayed = " +
                isIntroTitleDisplayed +
                "\nExpected: Intro Title is displayed = " + "true" + "\n");
        assertEquals(homePage.getIntroTitleMessage(), Constants.INTRO_TITLE);
    }
}
