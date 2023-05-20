package Base;

import Enums.Platform;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.net.MalformedURLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    private WebDriver driver = null;

    public WebDriver initDriver(String browserType, String browserVersion,
                                String platform, String environment) throws MalformedURLException {
        if (platform.equals(Platform.DESKTOP.getPlatformName())) {
            switch (browserType) {
                case BrowserType.CHROME:
                    WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
                    setCapabilitiesForChrome(environment);
                    break;

                case BrowserType.FIREFOX:
                    WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
                    setCapabilitiesForFirefox();
                    break;

                case BrowserType.IE:
                    WebDriverManager.getInstance(DriverManagerType.IEXPLORER).setup();
                    driver = new InternetExplorerDriver();
                    break;

                case BrowserType.SAFARI:
                    //TODO

                default:
                    throw new RuntimeException(
                            "Cannot create driver for unknown browser type");
            }

        }  else if (platform.equals(Platform.IOS.getPlatformName())) {

            //TODO

        } else if (platform.equals(Platform.MSITE.getPlatformName())) {

            //TODO

        }
        return driver;
    }

    private void setCapabilitiesForChrome(String environment) {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches",
                Collections.singletonList("enable-automation"));
        options.addArguments("chrome.switches", "-disable-extensions");
        options.addArguments("--disable-popup-blocking");
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        /*if (environment.equals("Jenkins")) {
            options.addArguments("headless");
        }*/
        driver = new ChromeDriver(options);
    }

    private void setCapabilitiesForFirefox() {
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
    }
}