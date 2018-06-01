package pages.com.paulcosma.external;

import base.MyDriver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Facebook extends MyDriver<Facebook> {
    public static Logger log = LogManager.getLogger(Facebook.class.getName());
    // Page elements.
    // Page elements description - used for test steps and clarity of errors.

    public Facebook(WebDriver driver) {
        super(driver);
    }

}
