package core.fe.gerchikPO.Pages.MainPage;

import core.fe.AbstractPage;
import core.fe.gerchikPO.Pages.profilePage.MainPageProfile;
import core.fe.gerchikPO.Pages.supportPage.MainPageSupport;
import core.fe.gerchikPO.login.GerchikLoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class MainPageValidation extends AbstractPage {


    @FindBy(xpath = "//a[@href=\"/support\"]\n")
    private WebElement supportMenuVerticalPage;

    @FindBy(xpath = "/html/body/div/div[2]/div[1]/div/a[1]/div")
    private WebElement depositButtonInVertikalMenu;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div/a[2]/div/span")
    private WebElement createSupportMasegeButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div[3]/div[1]/div[2]/a[1]")
    private WebElement depositGreenButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div[3]/div[1]/div[2]/a[2]")
    private WebElement withdrowalBlueButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div[3]/div[1]/div[2]/a[3]")
    private WebElement transactionHistoriButton;

    @FindBy(xpath = "//div[@class='close float--right close--margins']")
    private WebElement closePopupButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div[3]/div[2]/div[1]/div[3]/div/div[2]/div[1]")
    private WebElement openDemoBlock;

    @FindBy(xpath = "//span[@class=\"button button--colored button--red width--px_220 text--center button--pages\"]")
    private WebElement openDemoAccountButton;

    @FindBy(xpath = "//div[@class='margin--top_40 button button--colored button--blue width--px_240 text--center button--pages']")
    private WebElement closeDemoPopup;

    @FindBy(xpath = "    /html/body/div/div[2]/div[1]/div/ul/li[8]/a/span[2]")
    private WebElement logoutButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div/ul/li[7]/a/span[2]")
    private WebElement profileButton;

    @FindBys({
            @FindBy(xpath = "//div[@class=\"verification-steps__step flex--row_center-left margin--bottom_20 \"]")
    })
    private List<WebElement> verificationSteps;


    @FindBys({
            @FindBy(xpath = "//div[@class='popup__inner popup__inner--600 paddings--all_20']")
    })
    private List<WebElement> popup;


    @FindBys({
            @FindBy(xpath = "//div[@class='popup__inner paddings--all_40 popup__inner--620 margin--left_10 margin--right_10 demo-verification-steps_popup']")
    })
    private List<WebElement> demoPopup;


    @FindBys({
            @FindBy(xpath = "//div[@class=\"text-page-title\"]")
    })
    private List<WebElement> mainPageTitle;


    @FindBys({
            @FindBy(xpath = "//span[@class='blue-link-underline cursor--pointer']")
    })
    private List<WebElement> tariffPlanAndPlatformInTradingAccountBlock;

    public MainPageValidation(WebDriver driver) {
        super(driver);
    }

    public MainPageSupport clicckOnSupportMenuVerticalPage(){
        supportMenuVerticalPage.click();
        return new  MainPageSupport(driver);
    }

    public void isPresentMainPageTitle(){
        Assert.assertEquals(mainPageTitle.size(),1);
    }

    private void test (WebElement webElement) {
        webElement.click();
        Assert.assertEquals(1, popup.size());
        closePopupButton.click();
    }

    private void testOnDisplayedPopup (){
        Assert.assertEquals(0, popup.size());
    }

    public void depositButtonInVertikalMenuCheck (){
        test(depositButtonInVertikalMenu);
    }

    public void depositGreenButtonCheck (){
        test(depositGreenButton);
    }

    public void openDemoAccountButtonCheck(){
        openDemoBlock.click();
    }

    public void checkVerificationSteps(){
        for (int i = 1; verificationSteps.size()>i; i++ )    {
            test(verificationSteps.get(i));
        }
    }

    public void checkDemoPopup(){
        openDemoAccountButton.click();
        Assert.assertEquals(1, demoPopup.size());
        closeDemoPopup.click();
    }

    public GerchikLoginPage  logoutButtonClick (){
        logoutButton.click();
        return new GerchikLoginPage(driver);
    }

    public void checkModalWindowSelectTariffPlanAndPlatformInTradingAccountBlock(){
        for (int i =0;i<tariffPlanAndPlatformInTradingAccountBlock.size();i++){
            test(tariffPlanAndPlatformInTradingAccountBlock.get(i));
        }
    }

    public MainPageProfile clickOnProfileButton(){
        profileButton.click();
        return new MainPageProfile(driver);
    }

}
