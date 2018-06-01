package pages.com.paulcosma.external;

import base.MyDriver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Linkedin extends MyDriver<Linkedin> {
    public static Logger log = LogManager.getLogger(Linkedin.class.getName());
    // Page elements.

    public Linkedin(WebDriver driver) {
        super(driver);
    }

}
