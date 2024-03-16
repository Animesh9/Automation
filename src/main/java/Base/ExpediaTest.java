package Base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ActionUtil;

import javax.swing.*;

public class ExpediaTest {
    public ActionUtil actionsUtil;
    @FindBy(xpath = "//button[normalize-space()='English']")
    WebElement clickOnEnglish;
    @FindBy(xpath = "//select[@id = \"site-selector\"]")
    WebElement country;
    @FindBy(xpath = "//button[@class = \"uitk-button uitk-button-large uitk-button-fullWidth uitk-button-has-text uitk-button-primary uitk-button-floating-full-width\"]")
    WebElement save;
    @FindBy(xpath = "//a[@aria-controls='search_form_product_selector_flights']")
    WebElement clickFlight;

    @FindBy(xpath = "//*[@id=\"FlightSearchForm_ROUND_TRIP\"]/div/div[1]/div/div[1]/div/div/div[2]/div[1]/button")
    WebElement leavingFrom;


    @FindBy(xpath = "//div[@class=\"uitk-field has-no-visible-label has-placeholder\"]/input")
    WebElement enterCity;

    @FindBy(xpath = "//*[@id=\"origin_select-menu\"]/section/div/div[2]/div/ul/li[1]/div/div/button")
    WebElement clickCity;

    @FindBy(xpath = "//*[@id=\"FlightSearchForm_ROUND_TRIP\"]/div/div[1]/div/div[2]/div/div/div[2]/div[1]/button")
    WebElement goingTo;

    @FindBy(xpath = "//*[@id=\"destination_select\"]")
    WebElement arrEnterCity;

    @FindBy(xpath = "//*[@id=\"destination_select-menu\"]/section/div/div[2]/div/ul/li[1]/div/div/button")
    WebElement arrClickCity;

    @FindBy(xpath = "//*[@id=\"FlightSearchForm_ROUND_TRIP\"]/div/div[2]/div/div/div/div/button")
    WebElement dates;

    @FindBy(xpath = "//*[@id=\"FlightSearchForm_ROUND_TRIP\"]/div/div[2]/div/section/div[2]/div/div/div[3]/div/div[1]/table/tbody/tr[4]/td[1]/div")
    WebElement selectDate;

    @FindBy(xpath = "//*[@id=\"FlightSearchForm_ROUND_TRIP\"]/div/div[2]/div/section/footer/div/button")
    WebElement done;

    @FindBy(xpath = "//*[@id=\"FlightSearchForm_ROUND_TRIP\"]/div/div[3]/div/div[1]/button")
    WebElement travelers;

    @FindBy(xpath = "//*[@id=\"FlightSearchForm_ROUND_TRIP\"]/div/div[3]/div/div[2]/div/div/section/div[1]/div/div/button[2]")
    WebElement add;

    @FindBy(xpath = "//*[@id=\"travelers_selector_done_button\"]")
    WebElement done2;

    @FindBy(id = "search_button")
    WebElement search;

    @FindBy(xpath = "//ul[@data-test-id='listings']//li[2]//button")
    WebElement clickOnFirstFlight;

    public void testClass() {
//        actionsUtil.click(clickOnEnglish);
//        actionsUtil.selectDropDownByValue(country,"27");
//        actionsUtil.click(save);

        actionsUtil.click(clickFlight);
        actionsUtil.click(leavingFrom);
        actionsUtil.sendKeys(enterCity, "kolkata");
        actionsUtil.click(clickCity);
        actionsUtil.click(goingTo);
        actionsUtil.sendKeys(arrEnterCity, "hyderabad");
        actionsUtil.click(arrClickCity);
        actionsUtil.click(dates);
        actionsUtil.click(selectDate);
        actionsUtil.click(done);
        actionsUtil.click(travelers);
        actionsUtil.click(add);
        actionsUtil.click(done2);
        actionsUtil.click(search);
        actionsUtil.click(clickOnFirstFlight);
    }
}
