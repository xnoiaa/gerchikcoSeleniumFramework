package core.fe.gerchikPO.Pages.MainPage;

import core.fe.AbstractPage;
import core.fe.gerchikPO.Pages.supportPage.MainPageSupport;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class MainPage extends AbstractPage {

    @FindBys({
            @FindBy(xpath = "//div[@class=\"text-page-title\"]")
    })
    private List<WebElement> mainPageTitle;


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

    @FindBys({
            @FindBy(xpath = "//div[@class=\"verification-steps__step flex--row_center-left margin--bottom_20 \"]")
    })
    private List<WebElement> verificationSteps;




    @FindBys({
            @FindBy(xpath = "//div[@class='popup__inner popup__inner--600 paddings--all_20']")
    })
    private List<WebElement> popup;



    public MainPage(WebDriver driver) {
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

    public void checkVerificationSteps(){
        for (int i = 1; verificationSteps.size()>i; i++ )    {
            test(verificationSteps.get(i));
        }
    }

}
