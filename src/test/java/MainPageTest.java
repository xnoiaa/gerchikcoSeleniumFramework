import core.fe.gerchikPO.Pages.MainPage.MainPageValidation;
import core.fe.gerchikPO.login.GerchikLoginPage;
import org.junit.Test;

public class MainPageTest extends BaseTest{

    public void login(){
        GerchikLoginPage gerchikLoginPage = new GerchikLoginPage(getWebDriver());
        getBaseLktUrl();
        MainPageValidation mainPage = gerchikLoginPage.loginInSystem("qa3@starway-media.com","1111111q");
    }

    @Test//Перевірка на відображення попапу, який відображається при неповній реєстрації. Перевіряємо кнопку Пополнить баланс
    //PreConditions: В користувача апрувнуте лише мило
    public void checkPopup (){
        GerchikLoginPage gerchikLoginPage = new GerchikLoginPage(getWebDriver());
        getBaseLktUrl();
        MainPageValidation mainPage = gerchikLoginPage.loginInSystem("qa3@starway-media.com","1111111q");

    mainPage.depositButtonInVertikalMenuCheck();
    mainPage.depositGreenButtonCheck();
    mainPage.checkVerificationSteps();
    mainPage.openDemoAccountButtonCheck();
    mainPage.checkModalWindowSelectTariffPlanAndPlatformInTradingAccountBlock();
    mainPage.checkDemoPopup();
    mainPage.logoutButtonClick();
    gerchikLoginPage.testLoginButton();


    }

}
