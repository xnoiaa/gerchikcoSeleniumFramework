package core.fe.gerchikCrm;

import core.fe.AbstractPage;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
public class AuthPage extends AbstractPage {

    @FindBy(xpath = "//input[@type='email']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passInput;

    @FindBy(xpath = "//button[@class='button button--colored button--green width--px_280 margin--auto margin--bottom_20']")
    private WebElement submitButton;

    public AuthPage(final WebDriver driver) {
        super(driver);
    }


    public ProfilePage login(){
        loginInput.sendKeys("gerchikco@gerchikco.com");
        passInput.sendKeys("111111");
        submitButton.click();
        return new ProfilePage(driver);

    }

}
