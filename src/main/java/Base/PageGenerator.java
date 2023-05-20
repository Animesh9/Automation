package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageGenerator {
    private final WebDriver driver;
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
}