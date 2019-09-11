package base;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserFactory {
    public static Logger log = LogManager.getLogger(BrowserFactory.class.getName());

    public static WebDriver getDriver(String browserParameter) {
        WebDriver driver = null;
        String browser = System.getenv("browser");
        URL url = null;
        try {
            url = new URL("http://192.168.99.100:4444/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if (browser == null) {
            browser = browserParameter;
        }
        log.debug("Starting " + browser + " driver");
        switch (browser) {
            case "chrome":
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                driver = new RemoteWebDriver(url, capabilities);
                break;
            case "firefox":
                capabilities = DesiredCapabilities.firefox();
                driver = new RemoteWebDriver(url, capabilities);
                break;
            case "chrome-local":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox-local":
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
     * Get testing environment
     * Use system environment variables if specified else use defaultEnv.
     * If defaultEnv variable is empty or null testingEnvironment will be production.
     *
     * @param defaultEnv
     * @return
     */
    public static String getTestingEnvironment(String defaultEnv) {
        String testingEnv = System.getenv("testEnv");
        log.debug("Default environment defaultEnv = " + defaultEnv);
        log.debug("Environment variable System.getenv(testEnv) = " + testingEnv);
        if (testingEnv == null || testingEnv.isEmpty()) {
            testingEnv = defaultEnv;
        }
        if (testingEnv.equals("production") || testingEnv == null || testingEnv.isEmpty()) {
            return "";
        } else {
            return testingEnv.toLowerCase() + "."; // Add a dot because testing environment is used as a subdomain.
        }
    }
}
