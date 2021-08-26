import core.fe.gerchikPO.recoveryPass.RecoveryPasswordPageTest;
import org.junit.Assert;
import org.junit.Test;

public class RecoveryPasswordPage extends BaseTest{

    @Test
    public void isPresentValidationErrorBeforeClick(){
        RecoveryPasswordPageTest recoveryPasswordPageTest = new RecoveryPasswordPageTest(getWebDriver());
        getBaseLktUrl("/recovery");
        Assert.assertEquals("isPresentValidationErrorBeforeClick",recoveryPasswordPageTest.isPresent(),0);
    }

    @Test
    public void isPresentValidationErrorAfterClick(){
        RecoveryPasswordPageTest recoveryPasswordPageTest = new RecoveryPasswordPageTest(getWebDriver());
        getBaseLktUrl("/recovery");
        recoveryPasswordPageTest.clickOnSubmitButton();
        Assert.assertEquals("isPresentValidationErrorAfterClick",recoveryPasswordPageTest.isPresent(),1);
    }

}

