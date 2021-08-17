import core.fe.gerchikPO.GerchikRegistrationPage;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LKRegistrationPage extends BaseTest{
    @Test
  public void testRegistrationValidationExeptionText(){
        GerchikRegistrationPage gerchikRegistrationPage = new GerchikRegistrationPage(getWebDriver());
        getWebDriver().get("http://localhost:3000/registration");
        gerchikRegistrationPage.clickOnSubmitButton();
        List<String> errorText = gerchikRegistrationPage.getAllErrorsText();
        List<String> allInputsNames =  gerchikRegistrationPage.getInputs();

        for (int i =0; i < errorText.size(); i++){
            if (allInputsNames.get(i).equals("phone")){
                Assert.assertEquals("Incorect registration validation exeption ","Неверный формат телефона",errorText.get(i));
                continue;
            }
            if (allInputsNames.get(i).equals("checkbox__icon")){
                Assert.assertEquals("Incorect registration validation exeption ","Это поле обязательно для подтверждения",errorText.get(i));
                continue;
            }

            Assert.assertEquals("Incorect registration validation exeption","Это поле обязательно для заполнения",errorText.get(i));
        }
    }

    @Test
    public void clickOnFirstInputAndCheckNonAvailableValidationErrorTest(){
        getWebDriver().get("http://localhost:3000/registration");
        GerchikRegistrationPage gerchikRegistrationPages = new GerchikRegistrationPage(getWebDriver());
        ArrayList<String> validationsTextErrorArray = gerchikRegistrationPages.clickOnFirstInputAndCheckNonAvailableValidationError();
        Assert.assertNotEquals("Не зникає валідаційна помилка при кліці на поле",true, validationsTextErrorArray.get(0).equals(validationsTextErrorArray.get(1)));
    }
}
