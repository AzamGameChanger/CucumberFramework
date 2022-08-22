package com.codewithazam.PracticeAPI.Day1;

import io.restassured.RestAssured;
import org.junit.Test;

public class Task01 {

    @Test
    public void generateTokenTest(){
        // Try to generate token using a POST request.
        // Check swagger to see what GenerateToken request needs.

        String payload = "{\n" +
                "  \"userName\": \"KemalCoder\",\n" +
                "  \"password\": \"Coder@123\"\n" +
                "}";

        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        RestAssured.given()
                .header("Content-Type","application/json")
                .body(payload)
                .when().post("/Account/v1/GenerateToken")
                .prettyPrint();
    }
}
