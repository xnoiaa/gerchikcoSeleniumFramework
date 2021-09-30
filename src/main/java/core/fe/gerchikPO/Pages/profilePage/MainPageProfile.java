package core.fe.gerchikPO.Pages.profilePage;

import core.fe.AbstractPage;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
import java.util.List;

public class MainPageProfile extends AbstractPage {


    // Вроде как динамический xpath
    @FindBy(xpath = "/html/body/div/div[2]/div[2]/div[3]/div[2]/div[2]/div/div[3]/div/div[2]/div[3]/div[2]/span[2]")
    private WebElement changePasswordButton;

    @FindBy(xpath = "/html/body/div/div[2]/div[2]/div[3]/div[2]/div[2]/div/div[3]/div/div[2]/div[2]/div[2]/span[5]")
    private WebElement changePhoneButton;

    @FindBy(xpath = "//*[@id=\"react-tabs-1\"]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/button")
    private WebElement sendSmsCodeOnPhoneNumber;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement inputForSmsCode;

    @FindBy(xpath = "//button[@class='button button--colored button--green width--px_240 margin--auto']")
    private WebElement buttonContinue;

    @FindBy(xpath = "//div[@class='text-small-grey margin--bottom_15']")
    private WebElement textLimitSendSmsPerDay;


    @FindBys({
            @FindBy(xpath = "//input[@type='password']")
    })
    private List<WebElement> changePassPopupPlaceholdersInputs;

    public MainPageProfile(WebDriver driver) {
        super(driver);
    }


    public void clickOnChangePasswordButton() {
        changePasswordButton.click();
    }

    public void clickOnChangePhoneButton() {
        changePhoneButton.click();
    }

    public void clickOnsendSmsCodeOnPhoneNumber() {
        sendSmsCodeOnPhoneNumber.click();
    }

    public void sendValueInCodeInput() {
        inputForSmsCode.sendKeys("77777777");
    }

    public void clickOnButtonContinue() {
        buttonContinue.click();
    }

    public List<String> getChangePassPopupPlaceholdersInputs() {
        List<String> listInputType = new ArrayList<>();
        for (int i = 0; i < changePassPopupPlaceholdersInputs.size(); i++) {
            listInputType.add(changePassPopupPlaceholdersInputs.get(i).getAttribute("placeholder"));
        }
        return listInputType;
    }

    public void test() {
        List<String> allInputsNames = getChangePassPopupPlaceholdersInputs();
        System.out.println(allInputsNames.get(0));
        System.out.println(allInputsNames.get(1));
        System.out.println(allInputsNames.get(2));
    }

    @SneakyThrows
    public void sendIncorrectSmsCodeScenario() {
        clickOnsendSmsCodeOnPhoneNumber();
        buttonContinue.isDisplayed();
        sendValueInCodeInput();
        clickOnButtonContinue();
        Thread.sleep(500);
        Assert.assertEquals("input--auth text--center error--field", inputForSmsCode.getAttribute("class"));
    }

    @SneakyThrows
    public void sendSmsThreeTimes() {
        String activeButton = "button button--colored button--blue-dark width--percent_100 margin--auto";
        String messageLimit = "Лимит отправки SMS исчерпан, повторно SMS-код можно будет отправить через";//73 символа
        int count = 0;

        while (sendSmsCodeOnPhoneNumber.getAttribute("class").equals(activeButton)) {
            clickOnsendSmsCodeOnPhoneNumber();
            Thread.sleep(71000);
            count++;
            if (count > 5)
                Assert.assertFalse(false);
        }
        Assert.assertEquals(messageLimit, textLimitSendSmsPerDay.getText().substring(0, 73));
    }
}
