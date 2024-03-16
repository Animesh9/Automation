import Base.ConfigFileReader;
import Base.ConfigReader;
import Base.PageGenerator;
import Base.TestBase;
import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class day13Challenge extends TestBase {
    @BeforeMethod
    public void setDriver() {


        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\aniaj\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        String downloadFilepath = "D:\\";

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilepath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

    }
    /*@AfterMethod
    public void close(){
        driver.close();
    }*/

    @Test
    public void day10() throws IOException {

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
    void day13() {
        ConfigReader configReader = new ConfigReader();
        String urlDay13 = configReader.getURL("day13_url");
        driver.get(urlDay13);
        String mainWindow = driver.getWindowHandle();
        System.out.println(mainWindow);
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

}
