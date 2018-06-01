package com.paulcosma.tests;

import base.Setup;
import data.com.paulcosma.Constants;
import navigator.Navigator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.com.paulcosma.external.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestExternalLinks extends Setup {
    public static Logger log = LogManager.getLogger(TestExternalLinks.class.getName());

    @Test
    public void openFacebookSocialLinks() {
        Navigator navigator = new Navigator(driver);

        Facebook facebook = navigator
                .paulcosma
                .goToHomePage()
                .waitForHomePageToLoad()
                .clickFacebookIcon()
                .switchToWindowTab(1);
        assertEquals(facebook.getCurrentUrl(), Constants.EXTERNAL_LINK_FACEBOOK);
    }

    @Test
    public void openTwitterSocialLinks() {
        Navigator navigator = new Navigator(driver);

        Twitter twitter = navigator
                .paulcosma
                .goToHomePage()
                .waitForHomePageToLoad()
                .clickTwitterIcon()
                .switchToWindowTab(1);
        assertEquals(twitter.getCurrentUrl(), Constants.EXTERNAL_LINK_TWITTER);
    }

    @Test
    public void openGithubSocialLinks() {
        Navigator navigator = new Navigator(driver);

        Github github = navigator
                .paulcosma
                .goToHomePage()
                .waitForHomePageToLoad()
                .clickGithubIcon()
                .switchToWindowTab(1);
        assertEquals(github.getCurrentUrl(), Constants.EXTERNAL_LINK_GITHUB);
    }

    @Test
    public void openLinkedinSocialLinks() {
        Navigator navigator = new Navigator(driver);

        Linkedin linkedin = navigator
                .paulcosma
                .goToHomePage()
                .waitForHomePageToLoad()
                .clickLinkedinIcon()
                .switchToWindowTab(1);
        assertTrue(linkedin.getCurrentUrl().contains(Constants.EXTERNAL_LINK_LINKEDIN), "\nLinkedin link is " +
                "incorrect" +
                ".\nActual: Linkedin link = " + linkedin.getCurrentUrl() +
                "\nExpected: Linkedin link to contain = " + Constants.EXTERNAL_LINK_LINKEDIN + "\n");
    }

    @Test
    public void openFooterLink() {
        Navigator navigator = new Navigator(driver);

        Bootstrap bootstrap = navigator
                .paulcosma
                .goToHomePage()
                .waitForHomePageToLoad()
                .switchToWindowTab(0)
                .clickFooterLink()
                .switchToWindowTab(1);
        assertEquals(bootstrap.getCurrentUrl(), Constants.EXTERNAL_LINK_BOOTSTRAP);
    }
}
