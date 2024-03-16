

import Base.ConfigFileReader;
import Base.ExpediaTest;
import Base.PageGenerator;
import Base.TestBase;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ActionUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TransactionView extends TestBase {
    private ActionUtil actionsUtil;


    private ConfigFileReader configFileReader;
    private PageGenerator pageGenerator;

    @BeforeMethod
    public void setDriver() {
//        driver = setupDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\aniaj\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        configFileReader = new ConfigFileReader();
        pageGenerator = new PageGenerator(driver);
//        driver.get(landing_page_url);
        driver.manage().window().maximize();
//        driver.navigate().back();


    }

    @Test
    public void expediaTest() {
        driver.get("https://www.expedia.com/");
        String currentUrl = driver.getCurrentUrl();
        String title = driver.getTitle();
        System.out.println("Current Url=" + currentUrl + "\n" + "Title=" + title);
        Assert.assertEquals("https://www.expedia.com/", currentUrl, "Verify Url");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        pageGenerator.expediaTest().testClass();
    }

    @Test
    public void amazonTest() {
        driver.get("https://www.amazon.in/");
        String currentUrl = driver.getCurrentUrl();
        String title = driver.getTitle();
        System.out.println("Current Url=" + currentUrl + "\n" + "Title=" + title);
        Assert.assertEquals(currentUrl, "https://www.amazon.in/", "Verify Url");
//        pageGenerator.amazonTest().amazon();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com/");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com/");
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles);
        driver.close();
        driver.close();
        driver.close();
    }

}