package core.fe.gerchikPO.Pages.profilePage;

import core.fe.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainPageProfile  extends AbstractPage {


// Вроде как динамический xpath
    @FindBy(xpath = "/html/body/div/div[2]/div[2]/div[3]/div[2]/div[2]/div/div[3]/div/div[2]/div[3]/div[2]/span[2]")
    private WebElement changePasswordButton;

    @FindBys({
            @FindBy(xpath = "//input[@type='password']")
    })
    private List<WebElement> changePassPopupPlaceholdersInputs;

    public MainPageProfile(WebDriver driver) {
        super(driver);
    }


    public void clickOnChangePasswordButton(){
        changePasswordButton.click();
    }

    public List<String> getChangePassPopupPlaceholdersInputs() {
        List<String> listInputType = new ArrayList<>();
        for (int i = 0; i < changePassPopupPlaceholdersInputs.size(); i++) {
            listInputType.add(changePassPopupPlaceholdersInputs.get(i).getAttribute("placeholder"));
        }
        return listInputType;
    }

    public void test(){
        List<String> allInputsNames =getChangePassPopupPlaceholdersInputs();
        System.out.println(allInputsNames.get(0));
        System.out.println(allInputsNames.get(1));
        System.out.println(allInputsNames.get(2));
    }

}
