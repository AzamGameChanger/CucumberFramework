package com.codewithazam.PracticeAPI.Day2;

import com.codewithazam.utils.APIConstants;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

public class Post_GenerateToken {

    @Test
    public void generateToken() {
        String payload = "{\n" + "  \"userName\": \"DummyTester\",\n" + "  \"password\": \"Tester@333\"\n" + "}";

        RestAssured.baseURI = APIConstants.BASE_URI;

        Response generateTokenResponse = RestAssured.
                given().
                    contentType(ContentType.JSON).
                    body(payload).
                when().
                    post(APIConstants.GENERATE_TOKEN_ENDPOINT).
                    prettyPeek();

        generateTokenResponse.then().assertThat().statusCode(200);

        System.out.println("--------------------------------------");
        System.out.println(generateTokenResponse.statusLine());

        System.out.println(generateTokenResponse.header("Content-Type"));

        String tokenFromResponse = generateTokenResponse.body().jsonPath().getString("token");
        System.out.println(tokenFromResponse);



    }
}
