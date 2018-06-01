package navigator;

import base.MyDriver;
import data.tk.bebeonline.Constants;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.tk.bebeonline.AdminPage;
import pages.tk.bebeonline.HomePage;

public class BebeOnline extends MyDriver<BebeOnline> {
    public static Logger log = LogManager.getLogger(BebeOnline.class.getName());

    public BebeOnline(WebDriver driver) {
        super(driver);
    }

    public HomePage goToHomepage() {
        log.info("Steps to reproduce:");
        log.info("Step: Go to homepage: " + Constants.URL);
        goTo(Constants.URL, "home");
        return new HomePage(driver);
    }

    public AdminPage goToAdminPage() {
        log.info("Steps to reproduce:");
        log.info("Step: Go to admin page: " + Constants.ADMIN_URL);
        goTo(Constants.ADMIN_URL, "admin");
        return new AdminPage(driver);
    }
}
