package navigator;

import base.MyDriver;
import data.com.paulcosma.Constants;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.com.paulcosma.HomePage;

public class PaulCosma extends MyDriver {
    public static Logger log = LogManager.getLogger(PaulCosma.class.getName());

    public PaulCosma(WebDriver driver) {
        super(driver);
    }

    public HomePage goToHomePage() {
        log.info("Steps to reproduce:");
        log.info("Step: Go to homepage: " + Constants.URL);
        goTo(Constants.URL, "home");
        return new HomePage(driver);
    }
}
