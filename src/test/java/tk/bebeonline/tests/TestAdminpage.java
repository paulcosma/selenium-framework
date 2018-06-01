package tk.bebeonline.tests;

import base.Setup;
import data.tk.bebeonline.Constants;
import navigator.Navigator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestAdminpage extends Setup {
    public static Logger log = LogManager.getLogger(TestAdminpage.class.getName());

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
