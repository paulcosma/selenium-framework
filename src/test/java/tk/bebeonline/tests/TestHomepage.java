package tk.bebeonline.tests;

import base.Setup;
import data.tk.bebeonline.Constants;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.tk.bebeonline.HomePage;

import static org.testng.Assert.assertEquals;

public class TestHomepage extends Setup {
    public static Logger log = LogManager.getLogger(tk.bebeonline.tests.TestHomepage.class.getName());

    @Test
    public void homepageLoaded() {
        HomePage homePage = new HomePage(driver);

        homePage
                .openHomePage()
                .waitForHomePageToLoad();
        assertEquals(homePage.getCurrentUrl(), Constants.URL);
        assertEquals(homePage.getTitle(), Constants.HOMEPAGE_TITLE);
    }

}
