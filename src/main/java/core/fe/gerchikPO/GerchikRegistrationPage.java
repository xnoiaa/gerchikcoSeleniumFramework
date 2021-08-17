package core.fe.gerchikPO;

import core.fe.AbstractPage;
import core.fe.BaseUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.*;
import java.util.stream.Collectors;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.collect;

@BaseUrl(value = "http://localhost:3000/registration")

public class GerchikRegistrationPage extends AbstractPage {


    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div[2]/div[2]/form/div[1]/input")
    private WebElement firstName;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div[2]/div[2]/form/div[2]/input")
    private WebElement lastName;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div[2]/div[2]/form/div[3]/input")
    private WebElement email;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div[2]/div[2]/form/div[4]/input")
    private WebElement phone;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div[2]/div[2]/form/div[5]/input")
    private WebElement pass;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div[2]/div[2]/form/div[7]/input")
    private WebElement rePass;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div[2]/div[2]/form/div[8]/label/div[1]/span")
    private WebElement checkboxInput;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div[2]/div[2]/form/div[9]/span")
    private WebElement submitButton;


    @FindBys({
            @FindBy(xpath = "//div[@class='error-text margin--bottom_10']")
    })
    private List<WebElement> allErrorTexts;


    @FindBys({
            @FindBy(xpath = "//div[@class='label margin--bottom_20']/input")
    })
    private List<WebElement> allInputs;


    public GerchikRegistrationPage(final WebDriver driver) {
        super(driver);
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

    public List<String> getAllErrorsText() {
        return allErrorTexts.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getInputs() {
        List<String> listInputType = new ArrayList<>();
        for (int i = 0; i < allInputs.size(); i++) {
            listInputType.add(allInputs.get(i).getAttribute("name"));
        }
        listInputType.add(checkboxInput.getAttribute("class"));

        for (int i = 0; i < listInputType.size(); i++) {
        }
        return listInputType;

    }

    public ArrayList<String> clickOnFirstInputAndCheckNonAvailableValidationError (){
        ArrayList<String> array = new ArrayList<>();
        clickOnSubmitButton();
        String validationErrorBeforeClick =  allInputs.get(0).getAttribute("class");
        firstName.sendKeys("test");
        String validationErrorAfterClick =  allInputs.get(0).getAttribute("class");
       array.add(validationErrorBeforeClick);
        array.add(validationErrorAfterClick);
        return array;
    }



}
