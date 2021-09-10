package core.fe.gerchikPO.Pages.supportPage;

import core.fe.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;
import java.util.stream.Collectors;

public class MainPageSupport extends AbstractPage {

    @FindBy(xpath = "//a[@class='button button--colored button--blue width--px_170 text--center button--pages']")
    private WebElement createSupportRequestButton;

    @FindBy(xpath = "//div[@class=\"select-default__in__value-container select-default__in__value-container--has-value css-g1d714-ValueContainer\"]")
    private WebElement modalWindowSubjectInputTema;

    @FindBy(xpath = "//input[@class=\"input--normal \"]")
    private WebElement modalWindowNameInput;

    @FindBy(xpath = "//textarea[@class='textarea--normal ']")
    private WebElement modalWindowTextInput;

    @FindBy(xpath = "//button[@class='button button--colored width--px_142 text--center button--pages button--green button-main--colored text--center']")
    private WebElement modalWindowCreateButton;

    @FindBy(xpath = "//label[@for='file']")
    private WebElement modalWindowInsertFileInput;

    @FindBy(xpath = "//div[@class='font--14 color--grey']")
    private WebElement helpText;

    @FindBys({
            @FindBy(xpath = "//div[@class=\"select-default__in__menu css-26l3qy-menu\"]")
    })
    private List<WebElement> allDrobdownValue;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div[3]/div[1]/div[2]/span[1]\n")
    private WebElement closeTicketButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div[3]/div[1]/div[2]/div[2]/div/div[2]/div[2]/span[2]\n")
    private WebElement closeTicketButtonYes;

    @FindBy(xpath = "    //*[@id=\"app\"]/div[2]/div[2]/div[3]/div[1]/div/div[2]/div[7]/span[2]\n")
    private WebElement closeTicketButtonYesWithStar;

    @FindBy(xpath = "    //*[@id=\"app\"]/div[2]/div[2]/div[3]/div[1]/div/div[2]/div[7]/span[2]\n")
    private WebElement closeTicketButtonYesWithStarOutStars;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div[3]/div[1]/div[2]/span[2]")
    private WebElement backButtonFromTicket;

    @FindBys({
            @FindBy(xpath = "//*/td[1]/div/a\n")
    })
    private List<WebElement> allId;


    @FindBys({
            @FindBy(xpath = "//*/td[2]/div/a\n")
    })
    private List<WebElement> allTema;


    @FindBys({
            @FindBy(xpath = "//td[3]/div")
    })
    private List<WebElement> allDateCreate;


    @FindBys({
            @FindBy(xpath = "//td[4]/div")
    })
    private List<WebElement> allDateUpdate;


    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div[3]/div[3]/div/table/thead/tr/th[1]/div/span\n")
    private WebElement sortById;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div[3]/div[2]/div/table/thead/tr/th[3]/div/i")
    private WebElement sortByDateCreate;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div[3]/div[2]/div/table/thead/tr/th[4]/div/i")
    private WebElement sortByDateCreateUpdate;

    public MainPageSupport(WebDriver driver) {
        super(driver);
    }

    private List<String> getListValue(List<WebElement> list) {
        return list.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    private void checkSortLogic(List<WebElement> list){
        List<String> beforeSort;
        List<String> afterSort;
        beforeSort = getListValue(list);
        sortById.click();
        afterSort = getListValue(list);
        Assert.assertNotEquals(beforeSort.get(0), afterSort.get(0));
    }

    public void getAndCheckHelpText(){
        Assert.assertEquals("Допустимы файлы (jpg, jpeg, png, xls, xlsx, doc, docx, pdf) до 3 Mb каждый. Максимум 5 файлов.",helpText.getText());
    }

    public void createSupportTicket(){

        createSupportRequestButton.click();
        modalWindowSubjectInputTema.click();
        allDrobdownValue.get(0).click();
        modalWindowNameInput.sendKeys("text");
        modalWindowTextInput.sendKeys("text");
        modalWindowCreateButton.click();
    }

    public void closeTicketWithStarsOrWithOutStars(boolean bool){
        closeTicketButton.click();
        closeTicketButtonYes.click();
        if (bool==true){
        closeTicketButtonYesWithStar.click();}
        else {
            closeTicketButtonYesWithStarOutStars.click();
        }
    }

    public void clickOnbackButtonFromTicket(){
        backButtonFromTicket.click();
    }

    public void clickOnSortById(){
        sortById.click();
    }

    public void clickOnSortByDateCreate(){
        sortByDateCreate.click();
    }

    public void clickOnSortByDateUpdate(){
        sortByDateCreateUpdate.click();
    }

    public void checkSortId(){
        checkSortLogic(allId);
    }

    public void checkSortDateCreate(){
        checkSortLogic(allDateCreate);
    }

    public void checkSortDateUpdate(){
        checkSortLogic(allDateCreate);
    }



}
