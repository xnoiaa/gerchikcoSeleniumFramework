package core.fe.gerchikPO.login;

import core.fe.AbstractPage;
import core.fe.BaseUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.junit.Assert;


import java.util.List;
import java.util.stream.Collectors;

@BaseUrl(value = "http://localhost:3000")


public class GerchikLoginPage extends AbstractPage {

    @FindBy(xpath = "//input[@name=\"identifier\"]")
    private WebElement emailOrPhoneInput;

    @FindBy(xpath = "//input[@name=\"password\"]")
    private WebElement passInput;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div[2]/div[2]/div[6]/button")
    private WebElement loginButton;


    @FindBys({
            @FindBy(xpath = "//div[@class=\"error-text text--center margin--bottom_10\"]")
    })
    private List<WebElement> errorTexts;



    public GerchikLoginPage(WebDriver driver) {
        super(driver);
    }

    private List<String> getAllErrorsText() {
        return errorTexts.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void checkOnValidationTextError(){
        Assert.assertEquals("Validation Exeption on login page",getAllErrorsText().get(0),"Некорректный логин и/или пароль. В качестве логина используйте только подтвержденный канал связи (E-mail или Номер телефона).");
        Assert.assertEquals("Validation Exeption on login page",getAllErrorsText().get(1),"Это необходимо для предотвращения несанкционированного доступа к вашему аккаунту.");

    }

    public void checkOnValidationCssValueOfInputs(){
        Assert.assertEquals(  "InncorectBorderCssValue",   emailOrPhoneInput.getCssValue("border"),"2px solid rgb(251, 54, 64)");
        Assert.assertEquals(  "InncorectBorderCssValue",   passInput.getCssValue("border"),"2px solid rgb(251, 54, 64)");

    }

    public void clickOnLoginButton(){
        loginButton.click();
    }




}
