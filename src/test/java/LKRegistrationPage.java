import core.fe.gerchikPO.GerchikRegistrationPageStepOne;
import core.fe.gerchikPO.GerchikRegistrationPageStepTwo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class LKRegistrationPage extends BaseTest {
    Action action;

    @Test
    public void testRegistrationValidationExeptionText() {
        GerchikRegistrationPageStepOne gerchikRegistrationPageStepOne = new GerchikRegistrationPageStepOne(getWebDriver());
        getWebDriver().get("http://localhost:3000/registration");
        gerchikRegistrationPageStepOne.clickOnSubmitButton();
        List<String> errorText = gerchikRegistrationPageStepOne.getAllErrorsText();
        List<String> allInputsNames = gerchikRegistrationPageStepOne.getInputs();

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
        GerchikRegistrationPageStepOne gerchikRegistrationPagesStepOne = new GerchikRegistrationPageStepOne(getWebDriver());
        ArrayList<String> validationsTextErrorArray = gerchikRegistrationPagesStepOne.clickOnFirstInputAndCheckNonAvailableValidationError();
        Assert.assertNotEquals("Не зникає валідаційна помилка при кліці на поле", true, validationsTextErrorArray.get(0).equals(validationsTextErrorArray.get(1)));
    }

    @Test
    public void checkValidationErrorOnMaximumChars() {
        getWebDriver().get("http://localhost:3000/registration");
        GerchikRegistrationPageStepOne gerchikRegistrationPageStepOne = new GerchikRegistrationPageStepOne(getWebDriver());
        List<String> allErrorsText = gerchikRegistrationPageStepOne.sendKEysAndGetValidationErrorMOreChars();
        List<String> allInputsNames = gerchikRegistrationPageStepOne.getInputs();
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
        GerchikRegistrationPageStepOne gerchikRegistrationPageStepOne = new GerchikRegistrationPageStepOne(getWebDriver());
        gerchikRegistrationPageStepOne.checkPhoneInputOnCorrectWork();
        List<String> allInputsNames = gerchikRegistrationPageStepOne.getInputs();
        List<String> allErrorsText = gerchikRegistrationPageStepOne.getAllErrorsText();
        for (int i = 0; i < allErrorsText.size(); i++) {
            if (allErrorsText.get(i).equals("Телефон не существует")) {
                Assert.assertEquals("Incorect registration validation exeption on input ", "Телефон не существует", allErrorsText.get(i));
            }
        }
    }

    int num = 34;
    String email = "test" + num + "@gmail.com";
    String phone = "6315547" + num;

    @Test
    public void checkRegistration()   {
        getWebDriver().get("http://localhost:3000/registration");
        GerchikRegistrationPageStepOne gerchikRegistrationPageStepOne = new GerchikRegistrationPageStepOne(getWebDriver());
        GerchikRegistrationPageStepTwo gerchikRegistrationPageStepTwo = gerchikRegistrationPageStepOne.checkPhoneInputOnCorrectWork(email,phone );
        Assert.assertEquals("Incorrect email value",email,gerchikRegistrationPageStepTwo.getEmailValueFromRegistrationInput());
        gerchikRegistrationPageStepTwo.clickOnSendEmailButton();
        gerchikRegistrationPageStepTwo.sendValidActivationCodeInInput();
        gerchikRegistrationPageStepTwo.clickOnsubmitButton();
        Assert.assertTrue(true);
        int num =+1;

    }

    @Test
    public void confirmInvalidEmailConfirCode(){
        getWebDriver().get("http://localhost:3000/registration");
        GerchikRegistrationPageStepOne gerchikRegistrationPageStepOne = new GerchikRegistrationPageStepOne(getWebDriver());
        GerchikRegistrationPageStepTwo gerchikRegistrationPageStepTwo = gerchikRegistrationPageStepOne.checkPhoneInputOnCorrectWork(email,phone );
        Assert.assertEquals("Incorrect email value",email,gerchikRegistrationPageStepTwo.getEmailValueFromRegistrationInput());
        gerchikRegistrationPageStepTwo.clickOnSendEmailButton();
        gerchikRegistrationPageStepTwo.sendInvalidActivationCodeInInput();
        gerchikRegistrationPageStepTwo.clickOnsubmitButton();
        Assert.assertEquals("input--auth text--center error--field",gerchikRegistrationPageStepTwo.getClassOfActivationCodeInput());
        int num =+1;

    }
}