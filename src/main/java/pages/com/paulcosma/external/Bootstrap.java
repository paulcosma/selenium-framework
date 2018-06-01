package pages.com.paulcosma.external;

import base.BasePageObject;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Bootstrap extends BasePageObject<Bootstrap> {
    public static Logger log = LogManager.getLogger(Bootstrap.class.getName());
    // Page elements.

    public Bootstrap(WebDriver driver) {
        super(driver);
    }

}
