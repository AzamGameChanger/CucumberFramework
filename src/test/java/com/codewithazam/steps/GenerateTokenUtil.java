package com.codewithazam.steps;

import com.codewithazam.utils.APIConstants;
import com.codewithazam.utils.ConfigsReader;
import com.codewithazam.utils.Constants;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GenerateTokenUtil {

    public static String token;

    @Given("A token is generated")
    public void a_token_is_generated() {
        ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

        String userName = ConfigsReader.getProperty("APIUserName");
        String password = ConfigsReader.getProperty("APIPassword");

        String payload = "{\n" +
                "  \"userName\": \""+userName+"\",\n" +
                "  \"password\": \""+password+"\"\n" +
                "}";

        RestAssured.baseURI = APIConstants.BASE_URI;

        token = RestAssured.
                            given().
                                contentType(ContentType.JSON).
                                body(payload).
                            when().
                                post(APIConstants.GENERATE_TOKEN_ENDPOINT).
                                body().jsonPath().getString("token");
    }
}
