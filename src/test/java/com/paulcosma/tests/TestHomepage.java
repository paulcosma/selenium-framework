package com.paulcosma.tests;

import base.BaseTest;
import org.testng.annotations.Test;

public class TestHomepage extends BaseTest {

    @Test
    public void homepageLoaded() {
        driver.get("https://paulcosma.com");
    }

}
