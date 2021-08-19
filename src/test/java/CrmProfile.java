import core.fe.gerchikCrm.AuthPage;
import core.fe.gerchikCrm.ProfilePage;
import org.junit.Test;

public class CrmProfile extends BaseTest {

    @Test
    public void VacationTest(){
        AuthPage authPage = new AuthPage(getWebDriver());
        getWebDriver().get("http://localhost:4000/");

        ProfilePage profilePage = authPage.login();

      //  profilePage.click();

    }


}
