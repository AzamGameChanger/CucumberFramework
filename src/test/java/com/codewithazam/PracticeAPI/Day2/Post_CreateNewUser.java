package com.codewithazam.PracticeAPI.Day2;

import com.codewithazam.utils.APIConstants;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

public class Post_CreateNewUser {

    @Test
    public void createUser() {
        String payload = "{\n" +
                "  \"userName\": \"DummyTester\",\n" +
                "  \"password\": \"Tester@333\"\n" +
                "}";

        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        RestAssured.
                given()
                    .header("Content-Type", "application/json")
                    .body(payload).
                when()
                    .post(APIConstants.CREATE_USER_ENDPOINT)
                    .prettyPeek().
                then()
                    .assertThat().statusCode(201);
    }
}
