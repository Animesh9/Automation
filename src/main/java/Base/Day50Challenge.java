package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utils.ActionUtil;


public class Day50Challenge {
    public ActionUtil actionsUtil;
    @FindBy(id = "txt_rating")
    WebElement enterRating;
    @FindBy(id = "check_rating")
    WebElement checkRating;
    @FindBy(id = "validate_rating")
    WebElement validateRating;
    @FindBy(id = "check")
    WebElement check;
    @FindBy(xpath = "//p[normalize-space()='Warren Buffett']")
    WebElement WarrenBuffet;
    @FindBy(xpath = "//p[normalize-space()='Larry Ellison']")
    WebElement LarryEllison;
    @FindBy(xpath = "//p[normalize-space()='Bill Gates']")
    WebElement BillGates;
    @FindBy(xpath = "//p[normalize-space()='Jeff Bezos']")
    WebElement JeffBezos;
    @FindBy(xpath = "//p[normalize-space()='Amancio Ortega']")
    WebElement AmancioOrtega;
    @FindBy(xpath = "//p[normalize-space()='Larry Page']")
    WebElement LarryPage;
    @FindBy(xpath = "//p[normalize-space()='Carlos Slim Helu']")
    WebElement CarlosSlimHelu;
    @FindBy(xpath = "//p[normalize-space()='Bernard Arnault']")
    WebElement BernardArnault;
    @FindBy(xpath = "//p[normalize-space()='Mark Zuckerberg']")
    WebElement MarkZuckerberg;
    @FindBy(xpath = "//p[normalize-space()='Michael Bloomberg']")
    WebElement MichaelBloomberg;

    @FindBy(xpath = "//li[1]")
    WebElement rank1;
    @FindBy(xpath = "//li[2]")
    WebElement rank2;
    @FindBy(xpath = "//li[3]")
    WebElement rank3;
    @FindBy(xpath = "//li[4]")
    WebElement rank4;
    @FindBy(xpath = "//li[5]")
    WebElement rank5;
    @FindBy(xpath = "//li[6]")
    WebElement rank6;
    @FindBy(xpath = "//li[7]")
    WebElement rank7;
    @FindBy(xpath = "//li[8]")
    WebElement rank8;
    @FindBy(xpath = "//li[9]")
    WebElement rank9;
    @FindBy(xpath = "//li[10]")
    WebElement rank10;
    @FindBy(xpath = "//a[@type='button']")
    WebElement download;

    public void day3(String content) {

        String trimmedContent = content.substring(1, content.length() - 1);
        actionsUtil.sendKeys(enterRating, trimmedContent);
        actionsUtil.click(checkRating);
        System.out.println(actionsUtil.getText(validateRating));

    }

    public void day8(Actions a) {
        a.dragAndDrop(JeffBezos, rank1).perform();
        a.dragAndDrop(BillGates, rank2).perform();
        a.dragAndDrop(WarrenBuffet, rank3).perform();
        a.dragAndDrop(BernardArnault, rank4).perform();
        a.dragAndDrop(CarlosSlimHelu, rank5).perform();
        a.dragAndDrop(AmancioOrtega, rank6).perform();
        a.dragAndDrop(LarryEllison, rank7).perform();
        a.dragAndDrop(MarkZuckerberg, rank8).perform();
        a.dragAndDrop(MichaelBloomberg, rank9).perform();
        a.dragAndDrop(LarryPage, rank10).perform();
        check.click();

    }

    public void day10() {

        download.click();

    }
}
