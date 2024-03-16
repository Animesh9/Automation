package Base;

import com.beust.ah.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.ActionUtil;

public class PageGenerator {
    private final WebDriver driver;
    public ExpediaTest expediaTest;
    public AmazonTest amazonTest;
    public Day50Challenge day50Challenge;
//    LandingPage landingPage;

    public PageGenerator(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public <TPage> TPage getInstance(Class<TPage> pageClass) {

        try {
            //Initialize the Page with its elements and return it.
            return PageFactory.initElements(this.driver, pageClass);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /*public LandingPage getLandingPage() {
        if (this.landingPage == null) {
            this.landingPage = getInstance(LandingPage.class);
            this.landingPage.actionsUtil = new ActionUtil(this.driver);
        }
        return this.landingPage;
    }
    */
    public ExpediaTest expediaTest() {
        if (this.expediaTest == null) {
            this.expediaTest = getInstance(ExpediaTest.class);
            this.expediaTest.actionsUtil = new ActionUtil(this.driver);
        }
        return this.expediaTest;
    }

    public AmazonTest amazonTest() {
        if (this.amazonTest == null) {
            this.amazonTest = getInstance(AmazonTest.class);
            this.amazonTest.actionsUtil = new ActionUtil(this.driver);
        }
        return this.amazonTest;
    }

    public Day50Challenge day50Challenge() {
        if (this.day50Challenge == null) {
            this.day50Challenge = getInstance(Day50Challenge.class);
            this.day50Challenge.actionsUtil = new ActionUtil(this.driver);
        }
        return this.day50Challenge;
    }
}