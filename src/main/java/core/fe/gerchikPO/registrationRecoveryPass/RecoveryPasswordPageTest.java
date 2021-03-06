package core.fe.gerchikPO.registrationRecoveryPass;


import core.fe.AbstractPage;
import core.fe.BaseUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

@BaseUrl(value = "http://localhost:3000/recovery")


public class RecoveryPasswordPageTest extends AbstractPage {

    @FindBy(xpath = "//input[@name=\"channel\"]")
    private WebElement input;

    @FindBy(xpath = "//button[@class=\"button button--colored button--green width--percent_100 margin--auto\"]")
    private WebElement submitButton;

    @FindBy(xpath = "//button[@class=\"button button--colored button--grey_border width--percent_100 margin--auto\"]")
    private WebElement cancelButton;

    @FindBys({
            @FindBy(xpath = "//div[@class='error-text margin--bottom_10']")
    })
    private List<WebElement> allErrorTexts;


    @FindBy(xpath = "//div[@class=\"error-text margin--bottom_10\"]")
    private WebElement divErrorText;

    public RecoveryPasswordPageTest(WebDriver driver) {
        super(driver);
    }

    public void clickOnSubmitButton(){
        submitButton.click();
    }

        public int isPresent() {
        return allErrorTexts.size();
        }
    }





