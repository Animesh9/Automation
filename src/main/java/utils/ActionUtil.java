package utils;

import Base.TestBase;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ActionUtil extends TestBase {
    private WebDriverWait wait = null;
    private WebDriver webDriver;
    private String parentWindowHandler = null;
    private String subWindowHandler = null;

    public ActionUtil() {

    }

    public ActionUtil(WebDriver driver) {

        if ((driver != null)) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            webDriver = driver;
        }
    }

    /*public Boolean pollForElementVisibilityForText(WebElement element) {

        Boolean elementText = null;
        FluentWait<WebDriver> fwait = new FluentWait(webDriver)
                .withTimeout(30, SECONDS)
                .pollingEvery(20, SECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class);

        try {

            elementText = fwait.until(new Function<WebDriver, Boolean>() {

                public Boolean apply(WebDriver webDriver) {
                    return getText(element).equals("GOLD");
                }
            });

        } catch (Exception e) {

            e.printStackTrace();
        }

        return elementText;
    }*/

    public boolean isElementPresent(WebElement element) {

        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isElementClickable(WebElement element) {

        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void click(WebElement webElement) {

        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public void isSelected(WebElement webElement, String str) {
        if (webElement.isSelected())
            System.out.println(str);
        else
            webElement.click();
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", element);
    }

    public String getText(WebElement webElement) {

        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }

    public boolean validateUrl(String url) {

        return wait.until(ExpectedConditions.urlContains(url));
    }

    public String getAttribute(WebElement element, String attributeName) {

        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getAttribute(attributeName);
    }

    public void sendKeys(WebElement element, String value) {

        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(value);
    }

    public void sendKeysFile(WebElement element, String value) {

        element.sendKeys(value);
    }

    public void sendKeysNumeric(WebElement element, String value) {

        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();

        int i = 0;
        while (i < value.length()) {
            element.sendKeys(Character.toString(value.charAt(i)));
            i++;
        }
    }


    public void clearInput(WebElement element) {

        element.clear();
    }

    public void selectDropDownByVisibleText(WebElement element, String text) {

        wait.until(ExpectedConditions.elementToBeClickable(element));
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(text);
    }

    public void selectDropDownByValue(WebElement element, String value) {

        wait.until(ExpectedConditions.elementToBeClickable(element));
        Select dropdown = new Select(element);
        webDriver.manage().timeouts().implicitlyWait(2, SECONDS);
        dropdown.selectByValue(value.trim());
    }

    public void selectDropDownByIndex(WebElement element, int index) {

        wait.until(ExpectedConditions.elementToBeClickable(element));
        Select dropdown = new Select(element);
        dropdown.selectByIndex(index);
    }

    public List<WebElement> findChildElements(By by) {

        WebElement webElement = webDriver.findElement(by);
        List<WebElement> elements = webElement.findElements(By.xpath("*"));
        return elements;

    }

    public List<WebElement> getRows(By by) {

        List<WebElement> elements = webDriver.findElements(by);
        return elements;
    }

    public List<WebElement> getColumnsInRow(WebElement row) {

        List<WebElement> elements = row.findElements(By.xpath("*"));
        return elements;
    }

    public void switchToPopUp(WebDriver driver) {

        Set<String> handles = driver.getWindowHandles(); // get all window
        // handles
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()) {
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler); // switch to popup window

        // Now you are in the popup window, perform necessary actions here

//        driver.switchTo().window(parentWindowHandler); // switch back

    }


    public void navigateBack(WebDriver driver, String url) {

        driver.navigate().back();
        validateUrl(url);
    }

    public BufferedImage generateElementImage(WebElement element) throws IOException, InterruptedException {
        log.info("Take window screenshot");
        TakesScreenshot ts = (TakesScreenshot) webDriver;
        Thread.sleep(10000);
        File screenshot = ts.getScreenshotAs(OutputType.FILE);
        Thread.sleep(10000);
        BufferedImage fullImage = ImageIO.read(screenshot);
        return fullImage;
    }

    public List<WebElement> getRowsInTable(String xpath) {

        return webDriver.findElements(By.xpath(xpath + "/following::tr"));
    }

    public void reloadPage(WebDriver driver, String url) {
        driver.navigate().refresh();
    }

    public void robot(String path) throws AWTException {
        Robot rb = new Robot();
        rb.delay(2000);

        String current = System.getProperty("user.dir");
        StringSelection ss = new StringSelection(current + path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.delay(2000);

        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        rb.delay(2000);

        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }

}