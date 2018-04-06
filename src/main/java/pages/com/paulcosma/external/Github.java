package pages.com.paulcosma.external;

import base.BasePageObject;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Github extends BasePageObject<Github> {
    public static Logger log = LogManager.getLogger(Github.class.getName());
    //page elements

    public Github(WebDriver driver) {
        super(driver);
    }

}
