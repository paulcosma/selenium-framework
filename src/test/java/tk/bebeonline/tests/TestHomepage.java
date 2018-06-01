package tk.bebeonline.tests;

import base.Setup;
import data.tk.bebeonline.Constants;
import navigator.Navigator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestHomepage extends Setup {
    public static Logger log = LogManager.getLogger(tk.bebeonline.tests.TestHomepage.class.getName());

    @Test
    public void homepageLoaded() {
        Navigator navigator = new Navigator(driver);

        navigator
                .bebeonline
                .goToHomepage()
                .waitForHomePageToLoad();
        assertEquals(navigator.getCurrentUrl(), Constants.URL);
        assertEquals(navigator.getTitle(), Constants.HOMEPAGE_TITLE);
    }

    @Test
    public void adminPageLoaded() {
        Navigator navigator = new Navigator(driver);

        navigator
                .bebeonline
                .goToAdminPage()
                .waitForAdminPageToLoad();
        assertEquals(navigator.getCurrentUrl(), Constants.ADMIN_URL);
        assertEquals(navigator.getTitle(), Constants.ADMINPAGE_TITLE);
    }
}
