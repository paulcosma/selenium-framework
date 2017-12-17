package com.paulcosma.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstTest {

    @Test
    public void firstTestMethod() {
        
        WebDriver driver = new ChromeDriver();
        driver.get("https://paulcosma.com");
    }

}
