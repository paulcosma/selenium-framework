package com.paulcosma.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestHomepage {
    WebDriver driver;

    @BeforeMethod
    public void methodSetUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void methodTearDown() {
        driver.quit();
    }

    @Test
    public void homepageLoaded() {
        driver.get("https://paulcosma.com");
    }

}
