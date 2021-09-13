import core.fe.gerchikPO.Pages.MainPage.MainPage;
import core.fe.gerchikPO.Pages.supportPage.MainPageSupport;
import core.fe.gerchikPO.login.GerchikLoginPage;
import org.junit.Test;

public class MainPageTest extends BaseTest{

    public void login(){
        GerchikLoginPage gerchikLoginPage = new GerchikLoginPage(getWebDriver());
        getBaseLktUrl();
        MainPage mainPage = gerchikLoginPage.loginInSystem("qa3@starway-media.com","1111111q");
    }

    @Test//Перевірка на відображення попапу, який відображається при неповній реєстрації. Перевіряємо кнопку Пополнить баланс
    public void checkPopup (){
        GerchikLoginPage gerchikLoginPage = new GerchikLoginPage(getWebDriver());
        getBaseLktUrl();
        MainPage mainPage = gerchikLoginPage.loginInSystem("qa3@starway-media.com","1111111q");

        mainPage.depositButtonInVertikalMenuCheck();
        mainPage.depositGreenButtonCheck();
        mainPage.checkVerificationSteps();
    }

}
