package core.be.tempMail;

import com.google.gson.Gson;
import core.be.dto.tempMail.AuthenticationTokenModel;
import core.be.dto.tempMail.TempMailMethods;
import core.be.dto.tempMail.TempMailCreateModel;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetEmailCode {

    public String getAuthToken (){
        final TempMailCreateModel tempMailModel = new TempMailCreateModel();
        tempMailModel.setAddress("gerckik1@maxresistance.com"); //    "id": "602e1da4c1cd86338f093086",
        tempMailModel.setPassword("11111111");
        final Gson gson = new Gson();
        final String requestBodyString = gson.toJson(tempMailModel);
        final TempMailMethods tempMailApi = new TempMailMethods();
        final Response response = tempMailApi.CreateAccont(requestBodyString, tempMailApi.getPARTIAL_GET_AUTH_TOKEN_PATH());
        AuthenticationTokenModel tempMailCreateModel = response.as(AuthenticationTokenModel.class);
        return tempMailCreateModel.getToken();
    }

    public String getId(){
        final TempMailCreateModel tempMailModel = new TempMailCreateModel();
        tempMailModel.setAddress("gerckik1@maxresistance.com"); //    "id": "602e1da4c1cd86338f093086",
        tempMailModel.setPassword("11111111");
        final Gson gson = new Gson();
        final String requestBodyString = gson.toJson(tempMailModel);
        final TempMailMethods tempMailApi = new TempMailMethods();
        final Response response = tempMailApi.CreateAccont(requestBodyString, tempMailApi.getPARTIAL_GET_AUTH_TOKEN_PATH());
        AuthenticationTokenModel tempMailCreateModel = response.as(AuthenticationTokenModel.class);
        return tempMailCreateModel.getId();
    }

    public int checkLastMassageCode() {
        final TempMailMethods tempMailApi = new TempMailMethods();
        final Response responseHydra =  tempMailApi.getMessages(getAuthToken());
        ResponseBody responseBody = responseHydra.getBody();
        String str = responseBody.asString();
        System.out.println(str);
        String pattern = "(\\d{8})";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        if (m.find( )) {
            int i = Integer.parseInt(m.group(0));
            return    i;
        }
        else {
            return 1;
        }
    }
}
