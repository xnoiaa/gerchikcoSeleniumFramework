package core.fe.gerchikPO.registration;

import core.fe.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class GerchikRegistrationPageStepTwo  extends AbstractPage {


    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div[2]/div[2]/div[3]/input")
    private WebElement registrationInput;


    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div[2]/div[2]/div[4]/button")
    private WebElement sendActivationCodeButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div[2]/div[2]/div[6]/input")
    private WebElement inputForCode;

    @FindBy(xpath = "//button[@class='button button--colored button--green width--px_240 margin--auto']")
    private WebElement submitButton;


    public GerchikRegistrationPageStepTwo(WebDriver driver) {
        super(driver);
    }

    public String getEmailValueFromRegistrationInput(){
       return registrationInput.getAttribute("value");
    }
    public void clickOnSendEmailButton(){
        sendActivationCodeButton.click();
    }

    public void sendValidActivationCodeInInput(){
        inputForCode.sendKeys("10000000");
    }

    public void sendInvalidActivationCodeInInput(){
        inputForCode.sendKeys("10000001");
    }

    public void clickOnsubmitButton(){
        submitButton.click();
    }

    public String getClassOfActivationCodeInput (){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.attributeToBe(inputForCode,"class","input--auth text--center error--field"));
        return inputForCode.getAttribute("class");
    }
}
