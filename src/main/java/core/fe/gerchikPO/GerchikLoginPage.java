package core.fe.gerchikPO;

import core.fe.AbstractPage;
import core.fe.BaseUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@BaseUrl(value = "http://localhost:3000/")
public class GerchikLoginPage extends AbstractPage {


    @FindBy(xpath = "//input[@name='identifier']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passInput;

    @FindBy(xpath = "//button[@class='button button--colored button--green width--px_240 margin--auto']")
    private WebElement inputSubmit;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div[2]/div[2]/div[7]")
    private WebElement text;


    public GerchikLoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickAndSendTestValueToLoginInput(){
        loginInput.click();
        loginInput.sendKeys("lol");
    }

    public void clickOnSubmitButton(){
        inputSubmit.click();
    }

    public String testColorBorder(){
      return  loginInput.getCssValue("border-top-color");
    }

    public String checkTextColor(){
      return text.getText();
    }
}
