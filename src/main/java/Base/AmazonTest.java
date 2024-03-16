package Base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ActionUtil;

public class AmazonTest {
    ActionUtil actionsUtil;

    @FindBy(id = "twotabsearchtextbox")
    WebElement search;

    @FindBy(id = "nav-search-submit-button")
    WebElement submitSearch;

    @FindBy(id = "p_72/1318476031")
    WebElement fourStars;

    @FindBy(id = "p_36/1318506031")
    WebElement range;


    @FindBy(xpath = "//div[@class=\"s-main-slot s-result-list s-search-results sg-row\"]/div[3]//div[@class = \"a-section a-spacing-small a-spacing-top-small\"]//h2/a")
    WebElement phone;
    @FindBy(xpath = "//input[@id=\"add-to-cart-button\"]")
    WebElement addToCart;

    public void amazon() {
        actionsUtil.sendKeys(search, "mobile");
        actionsUtil.click(submitSearch);
        actionsUtil.click(fourStars);
        actionsUtil.click(range);
        actionsUtil.click(phone);
        actionsUtil.click(addToCart);
    }
}
