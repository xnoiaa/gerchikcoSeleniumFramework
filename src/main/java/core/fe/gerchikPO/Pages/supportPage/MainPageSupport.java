package core.fe.gerchikPO.Pages.supportPage;

import core.fe.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPageSupport extends AbstractPage {

    @FindBy(xpath = "//a[@class=\"button button--colored button--blue width--px_170 text--center button--pages\"]")
    private WebElement createSupportRequest;

    @FindBy(xpath = "//div[@class=\"select-default__in__value-container select-default__in__value-container--has-value css-g1d714-ValueContainer\"]")
    private WebElement modalWindowSubjectInputTema;

    @FindBy(xpath = "//input[@class=\"input--normal \"]")
    private WebElement modalWindowNameInput;

    @FindBy(xpath = "//textarea[@class='textarea--normal ']")
    private WebElement modalWindowTextInput;

    @FindBy(xpath = "//button[@class='button button--colored width--px_142 text--center button--pages button--green button-main--colored text--center']")
    private WebElement modalWindowCreateInput;

    @FindBy(xpath = "//label[@for='file']")
    private WebElement modalWindowInsertFileInput;


    public MainPageSupport(WebDriver driver) {
        super(driver);
    }

    public void testname(){

    }

}
