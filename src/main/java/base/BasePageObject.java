package base;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject<T> {
    public static Logger log = LogManager.getLogger(BasePageObject.class.getName());
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BasePageObject(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 60);
    }

    /**
     * Use this instead of Thread.sleep(milliseconds)
     *
     * @param time
     */
    public void sleep(int time) {
        try {
            log.debug("Waiting for " + time + " milliseconds");
            Thread.sleep(time);
        } catch (InterruptedException e) {
            log.error("Error " + e.toString());
            e.printStackTrace();
        }
    }

    /**
     * Navigate to URL
     *
     * @param url
     * @param pageName
     * @return
     */
    protected T goTo(String url, String pageName) {
        log.debug("Navigate with direct URL to " + pageName + " page (e.g. " + url + " )");
        try {
            driver.get(url);
        } catch (TimeoutException ex) {
            try {
                log.debug("Page was not fully loaded in the expected time. Sending ESC key.");
                driver.findElement(By.tagName("body")).sendKeys(Keys.ESCAPE);
            } catch (Exception e) {
                log.error("Exception when sending ESC key in attempt to stop page load");
            }
        }
        return (T) this;
    }

    /**
     * Get current URL of the page
     *
     * @return
     */
    public String getCurrentUrl() {
        String currentUrl = driver.getCurrentUrl();
        log.debug("Current page url = " + currentUrl);
        return currentUrl;
    }

    /**
     * Get current page Title
     *
     * @return
     */
    public String getTitle() {
        String title = driver.getTitle();
        log.debug("Current page title = " + title);
        return title;
    }

    private WebElement getElement(By element, String elementName) {
        try {
            waitForPresenceOf(element, elementName);
            return driver.findElement(element);
        } catch (Exception e) {
            log.error("Issue: " + elementName + " element was not found! (locator = " + element.toString() + " )");
            log.debug("Error message: " + e);
            throw(e);
        }
    }

    /**
     * Identifies element and performs a click on it
     * @param element
     * @param elementName
     */
    protected void click(By element, String elementName) {
            try {
                waitForElementToBeClickable(element,elementName);
                getElement(element,elementName).click();
            } catch (Exception e) {
                log.error("Issue: " + elementName + " element was not clicked! (locator = " + element.toString() + " )");
                log.debug("Error message: " + e);
                throw(e);
            }
    }

    /**
     * Locates an element and sends keys (performs a clear() before entering the value)
     * @param text
     * @param element
     * @param elementName
     */
    protected void type(String text, By element, String elementName) {
        try {
            log.debug("Filling " + elementName + " with: " + text);
            WebElement webElement = getElement(element,elementName);
            webElement.clear();
            webElement.sendKeys(text);
        } catch (InvalidElementStateException e) {
            log.error("Issue: Can't fill text on " + elementName + " element! (locator = " + element
                    .toString() + " )");
            log.debug("Error message: " + e);
            throw(e);
        } catch (StaleElementReferenceException e) {
        }
    }

    /**
     * Wait for element to be clickable
     * @param locator
     * @param elementName
     * @param timeOutInSeconds
     */
    protected void waitForElementToBeClickable(By locator, String elementName, Integer... timeOutInSeconds) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                waitFor(ExpectedConditions.elementToBeClickable(locator), (timeOutInSeconds.length > 0 ?
                        timeOutInSeconds[0] : null));
                break;
            } catch (TimeoutException e) {
                log.error("Issue: " + elementName + " element is not clickable! (locator = " + locator.toString() + "" +
                        " )");
                log.debug("Error message: " + e);
                throw (e);
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
    }

    /**
     * Wait for the presence of an element
     *
     * verifies that the specified element is somewhere on the page.
     * @param locator
     * @param elementName
     * @param timeOutInSeconds
     */
    protected void waitForPresenceOf(By locator, String elementName, Integer... timeOutInSeconds) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                waitFor(ExpectedConditions.presenceOfElementLocated(locator), (timeOutInSeconds.length > 0 ?
                        timeOutInSeconds[0] : null));
                break;
            } catch (TimeoutException e) {
                log.error("Issue: " + elementName + " element is not present! (locator = " + locator.toString() + " )");
                log.debug("Error message: " + e);
                throw (e);
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
    }

    /**
     * Wait for the visibility of an element
     *
     * determines if the specified element is visible.
     * an element can be rendered invisible by setting the CSS "visibility" property to "hidden",
     * or the "display" property to "none", either for the element itself or one if its ancestors.
     * this method will fail if the element is not present.
     * @param locator
     * @param timeOutInSeconds - optional TimeOut
     */
    protected void waitForVisibilityOf(By locator, String elementName, Integer... timeOutInSeconds) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator), (timeOutInSeconds.length > 0 ?
                        timeOutInSeconds[0] : null));
                break;
            } catch (TimeoutException e) {
                log.error("Issue: " + elementName + " element is not visible! (locator = " + locator.toString() + " )");
                log.debug("Error message: " + e);
                throw (e);
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
    }

    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(condition);
    }
}
