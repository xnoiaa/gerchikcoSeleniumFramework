import core.fe.gerchikPO.login.GerchikLoginPage;
import org.junit.Test;

public class LoginPage extends BaseTest {

    @Test
    public void checkValidationsExeptionCssValue(){
        GerchikLoginPage gerchikLoginPage = new GerchikLoginPage(getWebDriver());
        getWebDriver().get("http://localhost:3000");
        gerchikLoginPage.clickOnLoginButton();
        gerchikLoginPage.checkOnValidationCssValueOfInputs();
    }

    @Test
    public void checkValidationsExeptionText(){
        GerchikLoginPage gerchikLoginPage = new GerchikLoginPage(getWebDriver());
        getWebDriver().get("http://localhost:3000");
        gerchikLoginPage.clickOnLoginButton();
        gerchikLoginPage.checkOnValidationTextError();
    }
}
