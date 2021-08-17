import core.fe.gerchikPO.GerchikRegistrationPage;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LKRegistrationPage extends BaseTest {

    @Test
    public void testRegistrationValidationExeptionText() {
        GerchikRegistrationPage gerchikRegistrationPage = new GerchikRegistrationPage(getWebDriver());
        getWebDriver().get("http://localhost:3000/registration");
        gerchikRegistrationPage.clickOnSubmitButton();
        List<String> errorText = gerchikRegistrationPage.getAllErrorsText();
        List<String> allInputsNames = gerchikRegistrationPage.getInputs();

        for (int i = 0; i < errorText.size(); i++) {
            if (allInputsNames.get(i).equals("phone")) {
                Assert.assertEquals("Incorect registration validation exeption ", "Неверный формат телефона", errorText.get(i));
                continue;
            }
            if (allInputsNames.get(i).equals("checkbox__icon")) {
                Assert.assertEquals("Incorect registration validation exeption ", "Это поле обязательно для подтверждения", errorText.get(i));
                continue;
            }

            Assert.assertEquals("Incorect registration validation exeption", "Это поле обязательно для заполнения", errorText.get(i));
        }
    }


    @Test
    public void clickOnFirstInputAndCheckNonAvailableValidationErrorTest() {
        getWebDriver().get("http://localhost:3000/registration");
        GerchikRegistrationPage gerchikRegistrationPages = new GerchikRegistrationPage(getWebDriver());
        ArrayList<String> validationsTextErrorArray = gerchikRegistrationPages.clickOnFirstInputAndCheckNonAvailableValidationError();
        Assert.assertNotEquals("Не зникає валідаційна помилка при кліці на поле", true, validationsTextErrorArray.get(0).equals(validationsTextErrorArray.get(1)));
    }

    @Test
    public void checkValidationErrorOnMaximumChars() {
        getWebDriver().get("http://localhost:3000/registration");
        GerchikRegistrationPage gerchikRegistrationPage = new GerchikRegistrationPage(getWebDriver());
        List<String> allErrorsText = gerchikRegistrationPage.sendKEysAndGetValidationErrorMOreChars();
        List<String> allInputsNames = gerchikRegistrationPage.getInputs();
        for (int i = 0; i < allErrorsText.size(); i++) {
            if (allInputsNames.get(i).equals("name")) {
                Assert.assertEquals("Incorect registration validation exeption on input ", "Максимальная длина 40 символов", allErrorsText.get(i));
                continue;
            }
            if (allInputsNames.get(i).equals("surname")) {
                Assert.assertEquals("Incorect registration validation exeption on input ", "Максимальная длина 80 символов", allErrorsText.get(i));
                continue;
            }
            if (allInputsNames.get(i).equals("email")) {
                Assert.assertEquals("Incorect registration validation exeption on input ", "Пожалуйста, введите настоящий адрес электронной почты", allErrorsText.get(i));
                continue;
            }
            if (allInputsNames.get(i).equals("password")) {
                Assert.assertEquals("Incorect registration validation exeption on input ", "Пароль должен состоять из 8-30 символов, принадлежащих 2-м из 3-х групп: большая, маленькая латинская буква и цифра. Допустимые символы: (! @ # $ % ^ & * () ; \"' _ - . ,).", allErrorsText.get(i));
                continue;
            }
            if (allInputsNames.get(i).equals("password_confirmation")) {
                Assert.assertEquals("Incorect registration validation exeption on input ", "Пароль должен состоять из 8-30 символов, принадлежащих 2-м из 3-х групп: большая, маленькая латинская буква и цифра. Допустимые символы: (! @ # $ % ^ & * () ; \"' _ - . ,).", allErrorsText.get(i));
            }
        }
    }

    @Test
    public void checkOnCorrectWorkPhoneInput() {
        getWebDriver().get("http://localhost:3000/registration");
        GerchikRegistrationPage gerchikRegistrationPage = new GerchikRegistrationPage(getWebDriver());
        gerchikRegistrationPage.checkPhoneInputOnCorrectWork();
        List<String> allInputsNames = gerchikRegistrationPage.getInputs();
        List<String> allErrorsText = gerchikRegistrationPage.getAllErrorsText();
        for (int i = 0; i < allErrorsText.size(); i++) {
            System.out.println(allErrorsText.get(i));
            if (allErrorsText.get(i).equals("Телефон не существует")) {
                Assert.assertEquals("Incorect registration validation exeption on input ", "Телефон не существует", allErrorsText.get(i));
            }
            else {

            }
        }
    }

}