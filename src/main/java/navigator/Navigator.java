package navigator;

import base.MyDriver;
import org.openqa.selenium.WebDriver;

/**
 * Class used for Navigation on hosted apps, paulcosma.com, bebeonline.tk, cosma.tk
 */
public class Navigator extends MyDriver<Navigator> {
    public PaulCosma paulcosma;
    public Cosma cosma;
    public BebeOnline bebeonline;

    /**
     * Constructor
     *
     * @param driver
     */
    public Navigator(WebDriver driver) {
        super(driver);
        this.paulcosma = new PaulCosma(driver);
        this.cosma = new Cosma(driver);
        this.bebeonline = new BebeOnline(driver);
    }
}
