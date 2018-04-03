package tk.bebeonline.tests;

import base.BaseTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class TestHomepage extends BaseTest {
    public static Logger log = LogManager.getLogger(com.paulcosma.tests.TestHomepage.class.getName());

    @Test
    public void homepageLoaded() {
        driver.get("https://bebeonline.tk");
    }

}
