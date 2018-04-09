package base;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
    public static Logger log = LogManager.getLogger(BrowserFactory.class.getName());

    public static WebDriver getDriver(String browserParameter) {
        WebDriver driver = null;
        String browser = System.getenv("browser");
        if (browser == null) {
            browser = browserParameter;
        }
        log.debug("Starting " + browser + " driver");
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }

    /**
     * Get application environment
     * Use first the environment variables
     * If no environment variable is specified, use the defaultEnv
     *
     * @param defaultEnv
     * @return
     */
    public static String getAppEnvironment(String defaultEnv) {
        //get environment variable
        String envValue = System.getenv("appenv");
        //if environment variable is not specified use defaultEnv
        if (envValue == null) {
            envValue = defaultEnv;
        }
        //if production environment is specified leave variable empty, else add a dot a environment is a subdomain
        if (envValue == "production") {
            return "";
        } else {
            return envValue + ".";
        }
    }
}
