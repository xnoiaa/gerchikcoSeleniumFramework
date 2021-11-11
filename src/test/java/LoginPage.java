import core.fe.gerchikPO.Pages.MainPage.MainPageValidation;
import core.fe.gerchikPO.login.GerchikLoginPage;
import core.seeds.AccountTest;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.unitils.thirdparty.org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class LoginPage extends BaseTest {

    @Test
    public void checkValidationsExeptionCssValue()  {
        GerchikLoginPage gerchikLoginPage = new GerchikLoginPage(getWebDriver());
        getBaseLktUrl();
        gerchikLoginPage.clickOnLoginButton();
        gerchikLoginPage.checkOnValidationCssValueOfInputs();

    }

    @Test
    public void checkValidationsExeptionText() throws IOException {
        GerchikLoginPage gerchikLoginPage = new GerchikLoginPage(getWebDriver());
        getBaseLktUrl();
        gerchikLoginPage.clickOnLoginButton();
        gerchikLoginPage.checkOnValidationTextError();

        doScreenshot();

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
