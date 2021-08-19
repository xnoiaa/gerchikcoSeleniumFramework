package core.fe.gerchikPO;

import core.fe.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

public class GerchikRegistrationPageStepTwo  extends AbstractPage {


    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div[2]/div[2]/div[3]/input")
    private WebElement registrationInput;


    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div[2]/div[2]/div[4]/button")
    private WebElement sendActivationCodeButton;

    @FindBy(xpath = "    //*[@id=\"app\"]/div[2]/div[2]/div[2]/div[2]/div[6]/input\n")
    private WebElement inputForCode;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div[2]/div[2]/div[6]/button\n")
    private WebElement submitButton;

    Action action;


    public GerchikRegistrationPageStepTwo(WebDriver driver) {
        super(driver);
    }

    public String getEmailValueFromRegistrationInput(){
       return registrationInput.getAttribute("value");
    }

    public void sendactivationCodeInInput(){
        inputForCode.sendKeys("10000000");
    }

    public void clickOnsubmitButton(){
        submitButton.click();
    }
}
