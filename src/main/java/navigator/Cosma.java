package navigator;

import base.MyDriver;
import data.tk.cosma.Constants;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.tk.cosma.HomePage;

public class Cosma extends MyDriver<Cosma> {
    public static Logger log = LogManager.getLogger(Cosma.class.getName());

    public Cosma(WebDriver driver) {
        super(driver);
    }

    public HomePage goToHomepage() {
        log.info("Steps to reproduce:");
        log.info("Step: Go to homepage: " + Constants.URL);
        goTo(Constants.URL, "home");
        return new HomePage(driver);
    }
}
