import core.fe.gerchikPO.Pages.MainPage.MainPageValidation;
import core.fe.gerchikPO.Pages.supportPage.MainPageSupport;
import core.fe.gerchikPO.login.GerchikLoginPage;
import org.junit.Test;

public class SuppurtMainPageTest extends BaseTest{


    @Test
    public void loginTest(){
        GerchikLoginPage gerchikLoginPage = new GerchikLoginPage(getWebDriver());
        getBaseLktUrl();
        MainPageValidation mainPage = gerchikLoginPage.loginInSystem("qa3@starway-media.com","1111111q");
        MainPageSupport mainPageSupport = mainPage.clicckOnSupportMenuVerticalPage();
        mainPageSupport.createSupportTicket();
        mainPageSupport.closeTicketWithStarsOrWithOutStars(true);
    }

    @Test
    public void checkSort(){ //Тест провіряє сортування
        //Інсертити через базу юзера
        GerchikLoginPage gerchikLoginPage = new GerchikLoginPage(getWebDriver());
        getBaseLktUrl();
        MainPageValidation mainPage = gerchikLoginPage.loginInSystem("qa3@starway-media.com","1111111q");
        MainPageSupport mainPageSupport = mainPage.clicckOnSupportMenuVerticalPage();
        mainPageSupport.createSupportTicket();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPageSupport.clickOnbackButtonFromTicket();
        mainPageSupport.createSupportTicket();
        mainPageSupport.clickOnbackButtonFromTicket();
        mainPageSupport.checkSortId();
        mainPageSupport.checkSortDateCreate();
        mainPageSupport.checkSortDateUpdate();

        // Видалити юзера і два тікета
    }
}
