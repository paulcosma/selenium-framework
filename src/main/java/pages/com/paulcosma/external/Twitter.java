package pages.com.paulcosma.external;

import base.BasePageObject;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Twitter extends BasePageObject<Twitter> {
    public static Logger log = LogManager.getLogger(Twitter.class.getName());
    //page elements

    public Twitter(WebDriver driver) {
        super(driver);
    }

}
