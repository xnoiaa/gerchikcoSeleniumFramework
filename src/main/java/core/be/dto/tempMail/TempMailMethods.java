package core.be.dto.tempMail;

import core.be.dto.AbstractApi;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.Data;

@Data
public class TempMailMethods extends AbstractApi {

    private  final String PARTIAL_CREATE_ACCOUNT_PATH = "/accounts";
    private  String PARTIAL_GET_AUTH_TOKEN_PATH = "/authentication_token";
    private  String PARTIAL_COLLECTION_MESSAGE_PATH = "/messages";
    private String PARTIAL_DELETE_ACCOUNTS_PATH_ID = "/accounts/";



    public Response CreateAccont(final String requestBody,String link) {
        return   RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(link);
    }

    public Response getMessages( String authToken) {
        return   RestAssured.given()
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + authToken)
                .get(PARTIAL_COLLECTION_MESSAGE_PATH);
    }

    public int deleteAccount( String id, String authToken) {
        return   RestAssured.given()
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + authToken)
                .delete(PARTIAL_DELETE_ACCOUNTS_PATH_ID + id)
                .getStatusCode();

    }

    @Override
    protected String setUpBaseUrl() {
        final String apiBaseUrl = "https://api.mail.tm";
        return apiBaseUrl;
    }



}
