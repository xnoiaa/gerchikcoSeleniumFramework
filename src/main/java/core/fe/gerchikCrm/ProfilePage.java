package core.fe.gerchikCrm;

import core.fe.AbstractPage;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
public class ProfilePage extends AbstractPage {
    public ProfilePage(final WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='button-grey flex--row_center-center margin--left_16']")
    private WebElement loginInput;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div[2]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div[1]/div/div/div[1]")
    private WebElement VacationInput;

    public void click(){
        loginInput.click();
        VacationInput.click();

    }


}
