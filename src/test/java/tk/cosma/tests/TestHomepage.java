package tk.cosma.tests;

import base.BaseTest;
import org.testng.annotations.Test;

public class TestHomepage extends BaseTest {

    @Test
    public void homepageLoaded() {
        driver.get("https://cosma.tk");
    }

}
