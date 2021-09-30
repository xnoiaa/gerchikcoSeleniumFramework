import core.fe.gerchikPO.Pages.MainPage.MainPageValidation;
import core.fe.gerchikPO.Pages.profilePage.MainPageProfile;
import core.fe.gerchikPO.login.GerchikLoginPage;
import org.junit.Test;

public class ProfilePageTest extends BaseTest{


    //Тест перевіріяє плейсхолдери попапа зміни пароля
    //Необхідно добавити перевірку на плейсхолдери
    @Test
    public void test(){
        GerchikLoginPage gerchikLoginPage = new GerchikLoginPage(getWebDriver());
        getBaseLktUrl();
        MainPageValidation mainPage = gerchikLoginPage.loginInSystem("qa3@starway-media.com","1111111q");
        MainPageProfile mainPageProfile =  mainPage.clickOnProfileButton() ;
        mainPageProfile.clickOnChangePasswordButton();
        mainPageProfile.test();
    }

    //Тест перевіряє некоректно введений невірний код підтвердження при підтвердженні телефона
    @Test
    public void test2(){
        GerchikLoginPage gerchikLoginPage = new GerchikLoginPage(getWebDriver());
        getBaseLktUrl();
        MainPageValidation mainPage = gerchikLoginPage.loginInSystem("qa3@starway-media.com","1111111q");
        MainPageProfile mainPageProfile =  mainPage.clickOnProfileButton() ;
        mainPageProfile.clickOnChangePhoneButton();
        mainPageProfile.sendIncorrectSmsCodeScenario();
    }

    //Тест на перевірку кількості відправлень смс коду(щоб не більше 3шт)
    //Дописати перевірку на кількість відправлень
    @Test
    public void test3 (){
        GerchikLoginPage gerchikLoginPage = new GerchikLoginPage(getWebDriver());
        getBaseLktUrl();
        MainPageValidation mainPage = gerchikLoginPage.loginInSystem("qa3@starway-media.com","1111111q");
        MainPageProfile mainPageProfile =  mainPage.clickOnProfileButton() ;
        mainPageProfile.clickOnChangePhoneButton();
        mainPageProfile.sendSmsThreeTimes();
    }
}
