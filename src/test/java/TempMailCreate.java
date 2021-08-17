import com.google.gson.Gson;
import core.be.dto.tempMail.*;
import core.be.tempMail.GetEmailCode;
import org.junit.Test;

public class TempMailCreate {

    @Test
    public void createMail(){
        final TempMailCreateModel tempMailModel = new TempMailCreateModel();
        tempMailModel.setAddress("gerckik2@maxresistance.com"); //    "id": "602e1da4c1cd86338f093086",
        tempMailModel.setPassword("11111111");
        final Gson gson = new Gson();
        final String requestBodyString = gson.toJson(tempMailModel);
        final TempMailMethods tempMailApi = new TempMailMethods();
         tempMailApi.CreateAccont(requestBodyString,tempMailApi.getPARTIAL_CREATE_ACCOUNT_PATH());

    }
@Test
public void test(){
        final GetEmailCode getEmailCode = new GetEmailCode();
        System.out.println(getEmailCode.checkLastMassageCode());
}

@Test
public void deleteMessage(){
    GetEmailCode getEmailCode = new GetEmailCode();
    TempMailMethods tempMailMethods = new TempMailMethods();
    //tempMailMethods.deleteAccount(getEmailCode.getId());
    }


}
