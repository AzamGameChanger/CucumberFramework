package com.codewithazam.PracticeAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

public class ResponseVerification {

    @Test
    public void verifyGetAllBooksRequest(){
        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        RequestSpecification getAllBooksRequest = RestAssured.given();
        Response response = getAllBooksRequest.when().get("/BookStore/v1/Books");

        System.out.println("----------------------------------------");
        System.out.println("Verify that response status code is 200");
        response.then().assertThat().statusCode(200);

        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(200, actualStatusCode);

        System.out.println("----------------------------------------");
        System.out.println("Verifying header information");
        response.then().assertThat().header("Content-Type","application/json; charset=utf-8");

        System.out.println("----------------------------------------");
        System.out.println("Verifying that response body contains 'Git Pocket Guide'");
        String responseBody = response.body().asString();
        boolean contains = responseBody.contains("Git Pocket Guide");
        Assert.assertTrue(contains);
    }
}
