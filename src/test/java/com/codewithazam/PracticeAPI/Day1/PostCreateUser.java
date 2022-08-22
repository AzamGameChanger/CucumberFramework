package com.codewithazam.PracticeAPI.Day1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

public class PostCreateUser {

    @Test
    public void createUserTest(){
        RestAssured.baseURI = "https://bookstore.toolsqa.com";

        // I am creating a request
        RequestSpecification createUserRequest = RestAssured.given();

        createUserRequest.header("Content-Type","application/json");

        String payload = "{\n" + "  \"userName\": \"MustafaaCoder\",\n" + "  \"password\": \"Coder@123\"\n" + "}";
        System.out.println(payload);

        //I am adding payload in the body of the Request
        createUserRequest.body(payload);

        // I will make a call
        Response postResponse = createUserRequest.post("/Account/v1/User");

        System.out.println("--------------------------------------");
        System.out.println("Status code is " + postResponse.statusCode());

        System.out.println("--------------------------------------");
        System.out.println(postResponse.getStatusLine());

        System.out.println("--------------------------------------");
        postResponse.body().prettyPrint();
    }

    @Test
    public void createUserTestShorter(){
        String payload = "{\n" + "  \"userName\": \"KemalCoder\",\n" + "  \"password\": \"Coder@123\"\n" + "}";

        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        RestAssured.given()
                .header("Content-Type","application/json")
                .body(payload)
                .when().post("/Account/v1/User")
                .prettyPrint();
    }
}
