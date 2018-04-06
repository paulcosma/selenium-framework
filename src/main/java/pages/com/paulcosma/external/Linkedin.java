package pages.com.paulcosma.external;

import base.BasePageObject;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Linkedin extends BasePageObject<Linkedin> {
    public static Logger log = LogManager.getLogger(Linkedin.class.getName());
    //page elements

    public Linkedin(WebDriver driver) {
        super(driver);
    }

}
