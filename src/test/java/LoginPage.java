import core.fe.gerchikPO.Pages.MainPage.MainPageValidation;
import core.fe.gerchikPO.login.GerchikLoginPage;
import core.seeds.AccountTest;
import org.junit.Test;

public class LoginPage extends BaseTest {

    @Test
    public void checkValidationsExeptionCssValue(){
        GerchikLoginPage gerchikLoginPage = new GerchikLoginPage(getWebDriver());
        getBaseLktUrl();
        gerchikLoginPage.clickOnLoginButton();
        gerchikLoginPage.checkOnValidationCssValueOfInputs();
    }

    @Test
    public void checkValidationsExeptionText(){
        GerchikLoginPage gerchikLoginPage = new GerchikLoginPage(getWebDriver());
        getBaseLktUrl();
        gerchikLoginPage.clickOnLoginButton();
        gerchikLoginPage.checkOnValidationTextError();
    }

    @Test
    public void loginUser(){
        AccountTest accountTest = new AccountTest();
        GerchikLoginPage gerchikLoginPage = new GerchikLoginPage(getWebDriver());
        getBaseLktUrl();
        accountTest.createTable();
        MainPageValidation mainPage =  gerchikLoginPage.loginInSystem(accountTest.getEmailModel(),accountTest.getPassModel());
        mainPage.isPresentMainPageTitle();
    }

}
