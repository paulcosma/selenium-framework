package com.paulcosma.tests;

import base.BaseTest;
import data.com.paulcosma.Constants;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.com.paulcosma.HomePage;
import pages.com.paulcosma.external.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestExternalLinks extends BaseTest {
    public static Logger log = LogManager.getLogger(TestExternalLinks.class.getName());

    @Test
    public void openFacebookSocialLinks() {
        HomePage homePage = new HomePage(driver);

        Facebook facebook = homePage
                .openHomePage()
                .waitForHomePageToLoad()
                .clickFacebookIcon()
                .switchToWindowTab(1);
        assertEquals(facebook.getCurrentUrl(), Constants.EXTERNAL_LINK_FACEBOOK);
    }

    @Test
    public void openTwitterSocialLinks() {
        HomePage homePage = new HomePage(driver);

        Twitter twitter = homePage
                .openHomePage()
                .waitForHomePageToLoad()
                .clickTwitterIcon()
                .switchToWindowTab(1);
        assertEquals(twitter.getCurrentUrl(), Constants.EXTERNAL_LINK_TWITTER);
    }

    @Test
    public void openGithubSocialLinks() {
        HomePage homePage = new HomePage(driver);

        Github github = homePage
                .openHomePage()
                .waitForHomePageToLoad()
                .clickGithubIcon()
                .switchToWindowTab(1);
        assertEquals(github.getCurrentUrl(), Constants.EXTERNAL_LINK_GITHUB);
    }

    @Test
    public void openLinkedinSocialLinks() {
        HomePage homePage = new HomePage(driver);

        Linkedin linkedin = homePage
                .openHomePage()
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
        HomePage homePage = new HomePage(driver);

        Bootstrap bootstrap = homePage
                .openHomePage()
                .waitForHomePageToLoad()
                .switchToWindowTab(0)
                .clickFooterLink()
                .switchToWindowTab(1);
        assertEquals(bootstrap.getCurrentUrl(), Constants.EXTERNAL_LINK_BOOTSTRAP);
    }
}
