package core.be.dto.gerchikCRM;

import core.be.dto.AbstractApi;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LoginAPI extends AbstractApi {

    private static final String PARTIAL_LOGIN_PATH = "/api/v1/po/login";


    public Response loginUser(final String requestBody) {
        final Response loginResponse =  RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(PARTIAL_LOGIN_PATH);
        return loginResponse;

    }


    @Override
    protected String setUpBaseUrl() {
        final String apiBaseUrl = "http://localhost:8040";
        return apiBaseUrl;
    }
}
