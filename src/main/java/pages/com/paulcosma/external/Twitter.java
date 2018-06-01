package pages.com.paulcosma.external;

import base.MyDriver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Twitter extends MyDriver<Twitter> {
    public static Logger log = LogManager.getLogger(Twitter.class.getName());
    // Page elements.
    // Page elements description - used for test steps and clarity of errors.

    public Twitter(WebDriver driver) {
        super(driver);
    }

}
