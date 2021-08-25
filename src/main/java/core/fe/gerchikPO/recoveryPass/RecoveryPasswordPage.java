package core.fe.gerchikPO.recoveryPass;


import core.fe.AbstractPage;
import core.fe.BaseUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.stream.Collectors;

@BaseUrl(value = "http://localhost:3000/recovery")


public class RecoveryPasswordPage extends AbstractPage {

    @FindBy(xpath = "//input[@name=\"channel\"]")
    private WebElement input;

    @FindBy(xpath = "//input[@name=\"channel\"]")
    private WebElement submitButton;

    @FindBy(xpath = "//input[@name=\"channel\"]")
    private WebElement cancelButton;


    public RecoveryPasswordPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSubmitButton(){
        submitButton.click();
    }



}
