package pages.com.paulcosma.external;

import base.MyDriver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Github extends MyDriver<Github> {
    public static Logger log = LogManager.getLogger(Github.class.getName());
    // Page elements.

    public Github(WebDriver driver) {
        super(driver);
    }

}
