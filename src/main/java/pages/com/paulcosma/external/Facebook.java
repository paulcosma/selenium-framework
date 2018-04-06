package pages.com.paulcosma.external;

import base.BasePageObject;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Facebook extends BasePageObject<Facebook> {
    public static Logger log = LogManager.getLogger(Facebook.class.getName());
    //page elements

    public Facebook(WebDriver driver) {
        super(driver);
    }

}