package pages.tk.bebeonline;

import base.MyDriver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage extends MyDriver<AdminPage> {
    public static Logger log = LogManager.getLogger(AdminPage.class.getName());
    // Page elements description - used for test steps and clarity of errors.
    private String logoDescription = "Admin Page Logo";
    // Page elements.
    private By logo = By.id("header-logo");

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public AdminPage waitForAdminPageToLoad() {
        log.info("Step: Wait for Admin Page to load");
        waitForVisibilityOf(logo, logoDescription);
        return this;
    }
}
