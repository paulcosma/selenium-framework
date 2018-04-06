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
     * @param millis
     */
    public void sleep(long millis) {
        try {
            log.debug("Waiting for " + millis + " milliseconds");
            Thread.sleep(millis);
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

    private WebElement getElement(By locator, String elementName) {
        try {
            waitForPresenceOf(locator, elementName);
            return driver.findElement(locator);
        } catch (Exception e) {
            log.error("Issue: " + elementName + " element was not found! (locator = " + locator.toString() + " )");
            log.debug("Error message: " + e);
            throw (e);
        }
    }

    /**
     * Checks if the element identified by locator is displayed or not.
     *
     * @param locator
     * @param elementName
     * @return Boolean, true - if element is displayed, false - otherwise
     */
    protected Boolean isDisplayed(By locator, String elementName) {
        if (getElement(locator, elementName).isDisplayed()) {
            log.debug(elementName + " element is displayed. (locator = " + locator.toString() + " )");
            return true;
        } else {
            log.debug(elementName + " element is displayed. (locator = " + locator.toString() + " )");
            return false;
        }
    }

    /**
     * Identifies element and performs a click on it
     *
     * @param locator
     * @param elementName
     */
    protected void click(By locator, String elementName) {
        try {
            waitForElementToBeClickable(locator, elementName);
            getElement(locator, elementName).click();
        } catch (Exception e) {
            log.error("Issue: " + elementName + " element was not clicked! (locator = " + locator.toString() + " )");
            log.debug("Error message: " + e);
            throw (e);
        }
    }

    /**
     * Locates an element and sends keys (performs a clear() before entering the value)
     *
     * @param text
     * @param locator
     * @param elementName
     */
    protected void type(String text, By locator, String elementName) {
        try {
            log.debug("Filling " + elementName + " with: " + text);
            WebElement webElement = getElement(locator, elementName);
            webElement.clear();
            webElement.sendKeys(text);
        } catch (InvalidElementStateException e) {
            log.error("Issue: Can't fill text on " + elementName + " element! (locator = " + locator
                    .toString() + " )");
            log.debug("Error message: " + e);
            throw (e);
        } catch (StaleElementReferenceException e) {
        }
    }

    /**
     * Get text of element
     *
     * @param locator
     * @param elementName
     * @return
     */
    protected String getText(By locator, String elementName) {
        try {
            String text = getElement(locator, elementName).getText();
            log.debug("Text for element " + elementName + " = " + text);
            return text;
        } catch (Exception e) {
            log.error("Issue: " + elementName + " error! (locator = " + locator.toString() + " )");
            log.debug("Error message: " + e);
            throw (e);
        }
    }

    // -----------
    // Alerts
    // -----------

    /**
     * Verifies if a potential alert is present
     *
     * @return true if present, false if not
     */
    public boolean isAlertDisplayed() {
        log.info("Step: Verify alert");
        try {
            sleep(500);
            driver.switchTo().alert();
            log.debug("Alert found and switched to it");
            return true;
        } catch (Exception e) {
            log.debug("No alert found");
            return false;
        }
    }

    /**
     * Performs a wait for a potential alert to pop-up and if it does, it accepts the alert (clicks OK)
     */
    public void acceptAlert() {
        log.info("Step: Accept Alert");
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
            log.debug("Alert found and accepted");
        } catch (Exception e) {
            log.error("Issue: No alert found");
            log.debug("Error message: " + e);
            throw (e);
        }
    }

    /**
     * Accept alert if exists
     */
    public void acceptAlertIfExists() {
        log.info("Step: Accept Alert if any is displayed");
        for (int i = 0; i < 2; i++) {
            try {
                Alert alert = driver.switchTo().alert();
                if (alert != null) {
                    log.debug("Alert found and accepted");
                    alert.accept();
                    sleep(2000);
                    break;
                }
            } catch (NoAlertPresentException e) {
                log.debug("No alert found");
                log.debug("Error message: " + e);
            }
        }
    }

    /**
     * Performs a wait for a potential alert to pop-up and if it does, it cancels the alert
     */
    public void cancelAlert() {
        log.info("Step: Cancel Alert");
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
            log.debug("Alert found and dismissed");
        } catch (Exception e) {
            log.error("Issue: No alert found");
            log.debug("Error message: " + e);
            throw (e);
        }
    }

    /**
     * Selects an opened alert and returns the text from it.
     *
     * @return String
     */
    public String getAlertText() {
        log.info("Step: Get Alert text");
        sleep(1000);
        String alertText = driver.switchTo().alert().getText();
        log.debug("Alert text = " + alertText);
        return alertText;
    }

    // -----------
    // Waits
    // -----------

    /**
     * Wait for element to be clickable
     *
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
     * <p>
     * verifies that the specified element is somewhere on the page.
     *
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
     * <p>
     * determines if the specified element is visible.
     * an element can be rendered invisible by setting the CSS "visibility" property to "hidden",
     * or the "display" property to "none", either for the element itself or one if its ancestors.
     * this method will fail if the element is not present.
     *
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
