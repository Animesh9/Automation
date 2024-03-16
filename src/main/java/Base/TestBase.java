package Base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.util.Properties;


public class TestBase {
    public static final Logger log = Logger.getLogger(TestBase.class);
    protected static String landing_page_url;
    public WebDriver driver;
    public static String browser;
    public static String reportName;
    public static String testPlatform;
    public static String version;
    public static String env;
    private final ConfigFileReader configFileReader = new ConfigFileReader();

    @BeforeSuite
    protected void beforeSuite() {

        setEnvironment();
    }

    @BeforeSuite(alwaysRun = true)
    @Parameters({"browser", "version",
            "platform", "environment",
            "report"})
    protected void setBrowserConfiguration(
            @Optional("chrome") String browserType,
            @Optional("") String browserVersion,
            @Optional("Desktop") String platform,
            @Optional("local") String environment,
            @Optional("Regression_Suite") String report) {

        browser = browserType;
        version = browserVersion;
        testPlatform = platform;
        reportName = report;

    }

    protected WebDriver setupDriver() {
        try {
            DriverFactory driverFactory = new DriverFactory();
            driver = driverFactory
                    .initDriver(browser, version, testPlatform, env);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;

    }

    private void setEnvironment() {
        Properties properties = configFileReader.loadPropertyFiles();
        landing_page_url = properties
                .getProperty("landing_page_url");
        log.info("panel landing page staging url: "
                + landing_page_url);
        env = properties.getProperty("environment");
        log.info("environment: " + env);
    }
}