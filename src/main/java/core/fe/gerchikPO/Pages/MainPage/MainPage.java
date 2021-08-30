package core.fe.gerchikPO.Pages.MainPage;

import core.fe.AbstractPage;
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


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clicckOnSupportMenuVerticalPage(){
        supportMenuVerticalPage.click();
    }


    public void isPresentMainPageTitle(){
        Assert.assertEquals(mainPageTitle.size(),1);
    }

}
