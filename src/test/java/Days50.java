import Base.ConfigFileReader;
import Base.ConfigReader;
import Base.PageGenerator;
import Base.TestBase;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.openqa.selenium.*;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.ActionUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.text.CollationKey;
import java.time.Duration;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Days50 extends TestBase {
    private ActionUtil actionsUtil;
    static Logger Log = Logger.getLogger(Days50.class);
    private ConfigFileReader configFileReader;
    private PageGenerator pageGenerator;

    @BeforeMethod
    public void setDriver() throws InterruptedException {
//        driver = setupDriver();

        driver = new ChromeDriver();
        configFileReader = new ConfigFileReader();
        pageGenerator = new PageGenerator(driver);
        driver.manage().window().maximize();
//        driver.navigate().back();

    }

    @Test
    public void day2() {
        driver.get("https://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html");
//        Entering text on disabled element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector(\"#pass\").disabled = false");
        driver.findElement(By.id("pass")).sendKeys("passwordData");
    }

    @Test
    public void day3() {
        driver.get("https://play1.automationcamp.ir/advanced.html");

        String script = "return window.getComputedStyle(document.querySelector('.star-rating'),'::after').getPropertyValue('content')";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String content = (String) js.executeScript(script);
        System.out.println(content);

//      Read the Rating and type it in.
        pageGenerator.day50Challenge().day3(content);
    }

    @Test
    public void day5() {
        driver.get("https://qaplayground.dev/apps/verify-account/");
//      𝐔𝐬𝐢𝐧𝐠 𝐒𝐞𝐥𝐞𝐧𝐢𝐮𝐦 𝐚𝐮𝐭𝐨𝐦𝐚𝐭𝐢𝐨𝐧 𝐞𝐧𝐭𝐞𝐫 𝐭𝐡𝐞 𝐯𝐚𝐥𝐢𝐝 𝐜𝐨𝐝𝐞 𝐛𝐲 𝐤𝐞𝐲𝐛𝐨𝐚𝐫𝐝 𝐤𝐞𝐲𝐬 𝐛𝐲 𝐩𝐫𝐞𝐬𝐬𝐢𝐧𝐠 𝐭𝐡𝐞 𝐨𝐧𝐥𝐲 𝐤𝐞𝐲 𝐛𝐮𝐭𝐭𝐨𝐧 𝐚𝐧𝐝 𝐚𝐬𝐬𝐞𝐫𝐭𝐢𝐧𝐠 "𝐬𝐮𝐜𝐜𝐞𝐬𝐬" 𝐦𝐞𝐬𝐬𝐚𝐠𝐞. The confirmation code is - "999999".
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='code-container']/input"));
        for (WebElement e : elements) {
            e.sendKeys(Keys.NUMPAD9);
        }
        boolean success = driver.findElement(By.tagName("small")).isDisplayed();
        if (success) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }

    }

    @Test
    public void day6() {
        driver.get("http://uitestingplayground.com/progressbar");
//      𝐂𝐫𝐞𝐚𝐭𝐞 𝐚𝐧 𝐚𝐮𝐭𝐨𝐦𝐚𝐭𝐢𝐨𝐧 𝐒𝐞𝐥𝐞𝐧𝐢𝐮𝐦 𝐭𝐞𝐬𝐭 𝐬𝐜𝐫𝐢𝐩𝐭 𝐭𝐡𝐚𝐭 𝐜𝐥𝐢𝐜𝐤𝐬 𝐭𝐡𝐞 𝐒𝐭𝐚𝐫𝐭 𝐛𝐮𝐭𝐭𝐨𝐧 𝐚𝐧𝐝 𝐭𝐡𝐞𝐧 𝐰𝐚𝐢𝐭𝐬 𝐟𝐨𝐫 𝐭𝐡𝐞 𝐩𝐫𝐨𝐠𝐫𝐞𝐬𝐬 𝐛𝐚𝐫 𝐭𝐨 𝐫𝐞𝐚𝐜𝐡 65%.
//      𝐓𝐡𝐞𝐧 𝐭𝐡𝐞 𝐭𝐞𝐬𝐭 𝐬𝐡𝐨𝐮𝐥𝐝 𝐜𝐥𝐢𝐜𝐤 𝐒𝐭𝐨𝐩.
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id("startButton")).click();
        WebElement progressBar = driver.findElement(By.id("progressBar"));
        System.out.println(progressBar.getText());
        int testText = 75;
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // You can adjust the timeout as needed
//        wait.until(ExpectedConditions.textToBePresentInElement(progressBar, testText));

        while (true) {
            int percentage = Integer.parseInt(progressBar.getText().replace("%", ""));

            if (percentage >= testText) {
                driver.findElement(By.id("stopButton")).click();
                break;
            }
        }

    }

    @Test
    public void day7() {
        driver.get("https://qaplayground.dev/apps/context-menu/");
//        𝐂𝐫𝐞𝐚𝐭𝐞 𝐚𝐧 𝐚𝐮𝐭𝐨𝐦𝐚𝐭𝐢𝐨𝐧 𝐒𝐞𝐥𝐞𝐧𝐢𝐮𝐦 𝐭𝐞𝐬𝐭 𝐬𝐜𝐫𝐢𝐩𝐭 𝐭𝐡𝐚𝐭 𝐩𝐞𝐫𝐟𝐨𝐫𝐦𝐬 𝐭𝐡𝐞 "𝐑𝐢𝐠𝐡𝐭 𝐂𝐥𝐢𝐜𝐤" 𝐨𝐟 𝐦𝐨𝐮𝐬𝐞 𝐚𝐧𝐝 𝐲𝐨𝐮 𝐰𝐢𝐥𝐥 𝐬𝐞𝐞 𝐭𝐡𝐞 𝐦𝐞𝐧𝐮
//        𝐭𝐡𝐞𝐧 𝐧𝐚𝐯𝐢𝐠𝐚𝐭𝐞 𝐭𝐨 "𝐒𝐡𝐚𝐫𝐞 𝐦𝐞𝐧𝐮" 𝐨𝐩𝐭𝐢𝐨𝐧 𝐚𝐧𝐝 𝐜𝐥𝐢𝐜𝐤 𝐨𝐧 𝐚𝐥𝐥 "𝐬𝐨𝐜𝐢𝐚𝐥 𝐦𝐞𝐝𝐢𝐚 𝐥𝐢𝐧𝐤𝐬" 𝐢𝐧 𝐬𝐮𝐛-𝐦𝐞𝐧𝐮. 𝐚𝐧𝐝 𝐚𝐬𝐬𝐞𝐫𝐭𝐬 𝐭𝐡𝐞 𝐯𝐞𝐫𝐢𝐟𝐢𝐜𝐚𝐭𝐢𝐨𝐧 𝐦𝐞𝐬𝐬𝐚𝐠𝐞
//        𝐟𝐨𝐫 𝐚𝐥𝐥 𝐬𝐨𝐜𝐢𝐚𝐥 𝐥𝐢𝐧𝐤𝐬.
        WebElement msg = driver.findElement(By.id("msg"));
        WebElement share = driver.findElement(By.xpath("//li[@class='menu-item share']"));
        WebElement X = driver.findElement(By.xpath("//li[@onclick=\"itemClicked('Twitter')\"]"));
        WebElement dribble = driver.findElement(By.xpath("//li[@onclick=\"itemClicked('Dribble')\"]"));
        WebElement ig = driver.findElement(By.xpath("//li[@onclick=\"itemClicked('Instagram')\"]"));


        Actions a = new Actions(driver);
        a.contextClick(msg).perform();
        a.moveToElement(share).perform();
        X.click();
        Log.warn(msg.getText());
        Assert.assertEquals(msg.getText(), "Menu item Twitter clicked");

        a.contextClick(msg).perform();
        a.moveToElement(share).perform();
        dribble.click();
        Log.info(msg.getText());
        Assert.assertEquals(msg.getText(), "Menu item Dribble clicked");

        a.contextClick(msg).perform();
        a.moveToElement(share).perform();
        ig.click();
        Log.info(msg.getText());
        Assert.assertEquals(msg.getText(), "Menu item Instagram clicked");


    }

    @Test
    public void day7Author() {
        driver.get("https://qaplayground.dev/apps/context-menu/");
        Actions actions = new Actions(driver);
        List<WebElement> elements = driver.findElements(By.cssSelector("ul.share-menu li span"));
        for (WebElement element : elements) {
            actions.contextClick(driver.findElement(By.tagName("body"))).perform();
            actions.moveToElement(driver.findElement(By.cssSelector("li.share"))).perform();
            element.click();

            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p#msg")));
            if (element.getText().equalsIgnoreCase("Twitter")) {
                Assert.assertTrue(driver.findElement(By.cssSelector("p#msg")).getText().equalsIgnoreCase("Menu item Twitter clicked"));
                System.out.println("Twitter link - verified ");
            } else if (element.getText().equalsIgnoreCase("Instagram")) {
                Assert.assertTrue(driver.findElement(By.cssSelector("p#msg")).getText().equalsIgnoreCase("Menu item Instagram clicked"));
                System.out.println("Instagram link -verified ");
            } else if (element.getText().equalsIgnoreCase("Dribble")) {
                Assert.assertTrue(driver.findElement(By.cssSelector("p#msg")).getText().equalsIgnoreCase("Menu item Dribble clicked"));
                System.out.println("Dribble link -verified ");
            } else if (element.getText().equalsIgnoreCase("Telegram")) {
                Assert.assertTrue(driver.findElement(By.cssSelector("p#msg")).getText().equalsIgnoreCase("Menu item Telegram clicked"));
                System.out.println("Telegram link -verified ");
            }
        }
    }

    @Test
    public void day8() {
//        𝐂𝐫𝐞𝐚𝐭𝐞 𝐚𝐧 𝐚𝐮𝐭𝐨𝐦𝐚𝐭𝐢𝐨𝐧 𝐒𝐞𝐥𝐞𝐧𝐢𝐮𝐦 𝐭𝐞𝐬𝐭 𝐬𝐜𝐫𝐢𝐩𝐭 𝐭𝐡𝐚𝐭 𝐩𝐞𝐫𝐟𝐨𝐫𝐦𝐬 𝐭𝐡𝐞 𝐃𝐫𝐚𝐠 𝐚𝐧𝐝 𝐝𝐫𝐨𝐩 𝐭𝐡𝐞 𝐢𝐭𝐞𝐦𝐬 𝐢𝐧𝐭𝐨 𝐭𝐡𝐞𝐢𝐫 𝐜𝐨𝐫𝐫𝐞𝐬𝐩𝐨𝐧𝐝𝐢𝐧𝐠 𝐬𝐩𝐨𝐭𝐬
//        𝐇𝐞𝐫𝐞 𝐢𝐬 𝐚 𝐥𝐢𝐬𝐭 𝐨𝐟 𝐭𝐡𝐞 10 𝐑𝐢𝐜𝐡𝐞𝐬𝐭 𝐏𝐞𝐨𝐩𝐥𝐞 - 𝐲𝐨𝐮 𝐧𝐞𝐞𝐝 𝐭𝐨 𝐚𝐫𝐫𝐚𝐧𝐠𝐞 𝐭𝐡𝐞𝐧 𝐢𝐧 𝐭𝐡𝐞 𝐜𝐨𝐫𝐫𝐞𝐜𝐭 𝐨𝐫𝐝𝐞𝐫 𝐚𝐬 𝐠𝐢𝐯𝐞𝐧 𝐛𝐞𝐥𝐨𝐰 :
//        𝐄𝐱𝐩𝐞𝐜𝐭𝐞𝐝 𝐨𝐫𝐝𝐞𝐫 𝐨𝐟 𝐧𝐚𝐦𝐞𝐬 𝐢𝐧 𝐋𝐢𝐬𝐭 𝐨𝐫𝐝𝐞𝐫:
//        position: 1, name: "Jeff Bezos"
//        position: 2, name: "Bill Gates"
//        position: 3, name: "Warren Buffett"
//        position: 4, name: "Bernard Arnault"
//        position: 5, name: "Carlos Slim Helu"
//        position: 6, name: "Amancio Ortega"
//        position: 7, name: "Larry Ellison"
//        position: 8, name: "Mark Zuckerberg"
//        position: 9, name: "Michael Bloomberg"
        driver.get("https://qaplayground.dev/apps/sortable-list/");
        Actions a = new Actions(driver);
        pageGenerator.day50Challenge().day8(a);

    }

    @Test
    public void day9() throws IOException, UnsupportedFlavorException {
        driver.get("http://uitestingplayground.com/shadowdom");
        Actions a = new Actions(driver);
        WebElement shadowHost = driver.findElement(By.xpath("//div[@class='container']//guid-generator"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        shadowRoot.findElement(By.cssSelector("#buttonGenerate")).click();
        shadowRoot.findElement(By.cssSelector("#buttonCopy")).click();
        WebElement element = shadowRoot.findElement(By.cssSelector("#editField"));
        String text = element.getText();
        String localClipboardData = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        Assert.assertEquals(text, localClipboardData);
    }

    @Test
    public void day9Link() throws IOException, UnsupportedFlavorException {
        driver.get("http://uitestingplayground.com/shadowdom");
        SearchContext shadowDOMContext = driver.findElement(By.tagName("guid-generator")).getShadowRoot();
        shadowDOMContext.findElement(By.cssSelector(".button-generate")).click();
        WebElement element = shadowDOMContext.findElement(By.cssSelector("#editField"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String inputTextString = (String) js.executeScript("return arguments[0].value", element);

// shadowDOMContext.findElement(By.cssSelector(".button-copy")).click();

        Actions action = new Actions(driver);
        action.keyDown(element, Keys.CONTROL).sendKeys("A").sendKeys("C").keyUp(Keys.CONTROL).build().perform();

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Object clipData = clipboard.getData(DataFlavor.stringFlavor);
        Assert.assertTrue(((String) clipData).equalsIgnoreCase(inputTextString));
    }

    @Test
    public void day10() throws IOException {
        String downloadFilepath = "D:\\";

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilepath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        driver = new ChromeDriver(options);
        driver.get("https://demo.automationtesting.in/FileDownload.html");

        WebElement download = driver.findElement(By.xpath("//a[@type='button']"));
        download.click();

        String filePath = "D:\\samplefile.pdf";
        File file = new File(filePath);
        long fileSize = FileUtils.sizeOf(file);
        System.out.println(fileSize + "bytes");

        System.out.println("File Name: " + file.getName());
        System.out.println("File Path" + file.getAbsolutePath());

        PDDocument document = Loader.loadPDF(file);
        PDFTextStripper stripper = new PDFTextStripper();
        String pdfText = stripper.getText(document);
        String searchText = "Get Tickets";
        if (pdfText.contains(searchText)) {
            System.out.println("Text found in the PDF.");
        } else {
            System.out.println("Text not found in the PDF.");
        }


    }

    @Test
    public void testSome() {
        int x = 5;
        System.out.println(x++ + ++x);
        int[] arr = {1, 2, 3, 4, 5};
        for (int j = 0; j < arr.length; j++) {
            if (j == 2) {
                continue;
            }
            System.out.print(arr[j] + " ");
        }
        int i;
        for (i = 1; i < 6; i++) {
            if (i > 3) continue;
            System.out.println(i);
        }
        System.out.println(i);
    }

    @Test
    void day11() {
        driver.get("https://qaplayground.dev/apps/tags-input-box/");
        System.out.println("Size of List: " + count());
        driver.findElement(By.xpath("//button[text()='Remove All']")).click();
        WebElement input = driver.findElement(By.xpath("//input[@type='text']"));
        input.sendKeys("some,random,tags,selenium,java,jira,confluence,testNG,automation,python" + Keys.ENTER);
        System.out.println("Size of List: " + count());
        driver.findElement(By.xpath("//button[text()='Remove All']")).click();
        input.sendKeys("<script>alert</script>" + Keys.ENTER);
        WebElement alertElement = driver.findElement(By.xpath("//div[@class='content']//ul//li"));
        System.out.println(alertElement.getText());
        if (alertElement.getText() == null || alertElement.getText().equals(""))
            System.out.println("No Value");
        else
            System.out.println("Value is: " + alertElement.getText());
    }

    int count() {
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='content']//ul/li"));
        return elements.size();
    }

    @Test
    void day12() {
//        1) 𝐍𝐚𝐯𝐢𝐠𝐚𝐭𝐞 𝐭𝐨 4 𝐰𝐞𝐛𝐬𝐢𝐭𝐞 𝐨𝐧𝐞 𝐛𝐲 𝐨𝐧𝐞 𝐰𝐡𝐢𝐜𝐡 𝐢𝐬 𝐦𝐞𝐧𝐭𝐢𝐨𝐧𝐞𝐝 𝐛𝐞𝐥𝐨𝐰 :
        String url1 = "https://www.lambdatest.com/blog/selenium-best-practices-for-web-testing/";
        String url2 = "https://www.ministryoftesting.com/articles/websites-to-practice-testing";
        String url3 = "https://naveenautomationlabs.com/opencart/";
        String url4 = "https://demo.guru99.com/";
        HashMap<String, Integer> map = new HashMap<String, Integer>();
//        𝐘𝐨𝐮 𝐧𝐞𝐞𝐝 𝐭𝐨 𝐬𝐭𝐨𝐫𝐞 𝐚𝐥𝐥 4 𝐔𝐑𝐋𝐬 𝐢𝐧 𝐒𝐭𝐫𝐢𝐧𝐠 𝐀𝐫𝐫𝐚𝐲 𝐬𝐞𝐭.
        String url[] = {url1, url2, url3, url4};
        for (int i = 0; i < url.length; i++) {
            driver.get(url[i]);
            int linkCount = driver.findElements(By.tagName("a")).size();
//            2) 𝐏𝐫𝐢𝐧𝐭 𝐭𝐡𝐞 𝐔𝐫𝐥 𝐨𝐟 𝐏𝐚𝐠𝐞,𝐏𝐚𝐠𝐞 𝐓𝐢𝐭𝐥𝐞 & 𝐍𝐮𝐦𝐛𝐞𝐫 𝐨𝐟 𝐥𝐢𝐧𝐤𝐬 𝐨𝐧 𝐭𝐡𝐚𝐭 𝐬𝐩𝐞𝐜𝐢𝐟𝐢𝐞𝐝 𝐔𝐑𝐋 𝐏𝐚𝐠𝐞(𝐇𝐨𝐦𝐞 𝐏𝐚𝐠𝐞).
            System.out.println("Url of the page: " + driver.getCurrentUrl());
            System.out.println("Title of the page: " + driver.getTitle());
            System.out.println("Number of links: " + linkCount);
            map.put(driver.getTitle(), linkCount);
            System.out.println("");

        }
//        3)𝐀𝐟𝐭𝐞𝐫 𝐩𝐫𝐨𝐜𝐞𝐬𝐬𝐢𝐧𝐠 𝐚𝐥𝐥 𝐔𝐑𝐋𝐬, 𝐯𝐞𝐫𝐢𝐟𝐲 𝐭𝐡𝐚𝐭 𝐭𝐡𝐞 𝐜𝐨𝐧𝐬𝐨𝐥𝐞 𝐥𝐨𝐠 𝐝𝐢𝐬𝐩𝐥𝐚𝐲𝐬 𝐭𝐡𝐞 𝐩𝐚𝐠𝐞 𝐭𝐢𝐭𝐥𝐞 𝐰𝐢𝐭𝐡 𝐭𝐡𝐞 𝐦𝐚𝐱𝐢𝐦𝐮𝐦 𝐧𝐮𝐦𝐛𝐞𝐫 𝐨𝐟 𝐥𝐢𝐧𝐤𝐬.
//        𝐓𝐡𝐞 𝐜𝐨𝐧𝐬𝐨𝐥𝐞 𝐬𝐡𝐨𝐮𝐥𝐝 𝐝𝐢𝐬𝐩𝐥𝐚𝐲 𝐢𝐧 𝐭𝐡𝐢𝐬 𝐟𝐨𝐫𝐦: "𝐏𝐚𝐠𝐞 𝐰𝐢𝐭𝐡 𝐌𝐚𝐱𝐢𝐦𝐮𝐦 𝐋𝐢𝐧𝐤𝐬: [𝐏𝐚𝐠𝐞 𝐓𝐢𝐭𝐥𝐞] - [𝐍𝐮𝐦𝐛𝐞𝐫 𝐨𝐟 𝐋𝐢𝐧𝐤𝐬] 𝐥𝐢𝐧𝐤𝐬".
//        ✅𝐂𝐡𝐚𝐥𝐥𝐞𝐧𝐠𝐞: 𝘠𝘰𝘶 𝘯𝘦𝘦𝘥 𝘵𝘰 𝘶𝘴𝘦 𝘏𝘢𝘴𝘩𝘔𝘢𝘱 𝘊𝘰𝘯𝘤𝘦𝘱𝘵 𝘧𝘰𝘳 𝘤𝘰𝘮𝘱𝘢𝘳𝘪𝘯𝘨 𝘵𝘩𝘦 𝘔𝘢𝘹𝘪𝘮𝘶𝘮 𝘯𝘶𝘮𝘣𝘦𝘳 𝘰𝘧 𝘭𝘪𝘯𝘬𝘴 of 𝘢𝘭𝘭 𝘵𝘩𝘦 4 𝘱𝘢𝘨𝘦 𝘜𝘙𝘓𝘴 by storing in entry set.
        System.out.println("Maximum Links: " + Collections.max(map.values()));

    }

    ConfigReader configReader = new ConfigReader();

    @Test
    void day13() {

        String urlDay13 = configReader.getURL("day13_url");
        driver.get(urlDay13);
        String mainWindow = driver.getWindowHandle();
        System.out.println("Default Window Handle:" + mainWindow);
        WebElement pdfLink = driver.findElement(By.linkText("Download a Printable PDF of this Cheat Sheet"));
        pdfLink.click();
        Set<String> allWindows = driver.getWindowHandles();

        System.out.println(allWindows.size());
        for (String handle : allWindows) {
            // Switch to the window
            driver.switchTo().window(handle);
            if (!handle.equals(mainWindow)) {
                // Perform actions on the window
                // PDF URL
                String pdfUrl = driver.getCurrentUrl();

                // Path to save the PDF file
                String filePath = "../sample.pdf";

                try {
                    // Open a connection to the PDF URL
                    URL url = new URL(pdfUrl);
                    URLConnection connection = url.openConnection();
                    connection.connect();
                    System.out.println(driver.getWindowHandle());
                    // Download the PDF file
                    BufferedInputStream inputStream = new BufferedInputStream(connection.getInputStream());
                    FileOutputStream outputStream = new FileOutputStream(new File(filePath));
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    outputStream.close();
                    inputStream.close();
                    System.out.println("PDF file downloaded successfully.");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            // Close the window if needed
//            driver.close();
        }
    }

    @Test
    void day14(){

    }
    @Test
    void day15(){
        Response response = RestAssured.given().get("https://randomuser.me/api/").then().extract().response();
        String fN = response.getBody().jsonPath().get("results[0].name.first").toString();
        System.out.println(fN);
//        driver.get("https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407");

    }

    @Test
    void day16(){
        driver.get("https://qaplayground.dev/apps/mouse-hover/");
        Actions a = new Actions(driver);
        WebElement card = driver.findElement(By.xpath("//div[@class='poster-container']/a"));
        a.moveToElement(card).perform();
        String price = driver.findElement(By.xpath("//p[@class='current-price']")).getText();
        Assert.assertEquals("$24.96",price, "Verifying price");
    }

    @Test
    void day17(){

    }
    @Test
    void day18(){
//        𝐂𝐫𝐞𝐚𝐭𝐞 𝐚𝐧 𝐚𝐮𝐭𝐨𝐦𝐚𝐭𝐢𝐨𝐧 𝐒𝐞𝐥𝐞𝐧𝐢𝐮𝐦 𝐭𝐞𝐬𝐭 𝐬𝐜𝐫𝐢𝐩𝐭 𝐭𝐡𝐚𝐭 𝐯𝐞𝐫𝐢𝐟𝐲 𝐛𝐮𝐭𝐭𝐨𝐧 𝐢𝐬 𝐯𝐢𝐬𝐢𝐛𝐥𝐞 𝐨𝐧 𝐬𝐜𝐫𝐨𝐥𝐥 𝐚𝐧𝐝 𝐮𝐬𝐞𝐫 𝐧𝐞𝐞𝐝 𝐭𝐨 𝐜𝐥𝐢𝐜𝐤 𝐨𝐧 𝐭𝐡𝐚𝐭 𝐛𝐮𝐭𝐭𝐨𝐧.
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://qaplayground.dev/apps/covered/#");
        String initialText = driver.findElement(By.id("info")).getText();
        softAssert.assertEquals(initialText,"Click the button below", "Verify Initial Text");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement youFoundMe = driver.findElement(By.id("fugitive"));

        js.executeScript("arguments[0].scrollIntoView();", youFoundMe);
        youFoundMe.click();
        WebElement mission = driver.findElement(By.id("info"));
        String verifyText = mission.getText();
        js.executeScript("arguments[0].scrollIntoView();", mission);

        softAssert.assertEquals(verifyText,"Mission accomplished","Verify Message");
        softAssert.assertAll();

    }

    @Test
    void day19(){

        /*WebElement oneStar = driver.findElement(By.xpath("//div/label[1]"));
        WebElement twoStar = driver.findElement(By.xpath("//div/label[2]"));
        WebElement threeStar = driver.findElement(By.xpath("//div/label[3]"));
        WebElement fourStar = driver.findElement(By.xpath("//div/label[4]"));
        WebElement fiveStar = driver.findElement(By.xpath("//div/label[5]"));
        oneStar.click();*/
        /*twoStar.click();
        System.out.println((String) js.executeScript(script, rating));*/
        driver.get("https://qaplayground.dev/apps/rating/");
        WebElement rating = driver.findElement(By.xpath("//span[@class='numb']"));
        WebElement text = driver.findElement(By.xpath("//span[@class='text']"));
        String script = "return window.getComputedStyle(arguments[0],':before').getPropertyValue('content')";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String ratingText = (String) js.executeScript(script, rating);
        System.out.println(ratingText);
        System.out.println((String) js.executeScript(script, text));
        List<WebElement> ratingList = driver.findElements(By.xpath("//label"));

        for(WebElement element: ratingList){
            element.click();
            System.out.println((String) js.executeScript(script, rating));
            System.out.println((String) js.executeScript(script, text));

        }


    }

    @Test
    void day20() throws com.google.zxing.NotFoundException, IOException {
        driver.get("https://qaplayground.dev/apps/qr-code-generator/");
        String text = "I am an Automation QA";
        driver.findElement(By.xpath("//input")).sendKeys(text);
        driver.findElement(By.xpath("//button")).click();
        String qrCodeFile = driver.findElement(By.xpath("//div[@class='qr-code']/img")).getAttribute("src");
        String qrContent = decodeQRCode(qrCodeFile);
        Assert.assertEquals(qrContent,text,"Verify Text");

    }
    private static String decodeQRCode(String qrCodeImage) throws IOException, NotFoundException, com.google.zxing.NotFoundException {
        BufferedImage bufferedImage = ImageIO.read(new URL(qrCodeImage));
        LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

        Result result = new MultiFormatReader().decode(bitmap);
        return result.getText();
    }
    /*@AfterMethod
    public void close(){
        driver.close();
    }*/
}
