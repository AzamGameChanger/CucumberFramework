package com.codewithazam.PracticeAPI.Day1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
//import static org.hamcrest.Matchers.*;

public class GetOneBook {

    @Test
    public void getOneBookTest(){
        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        RequestSpecification getOneBookRequest = RestAssured.given();
        getOneBookRequest.queryParam("ISBN","9781593277574");

        Response getOneBookResponse = getOneBookRequest.when().get("/BookStore/v1/Book");


        System.out.println("----------------------------------------");
        System.out.println("Status code is -> " + getOneBookResponse.statusCode());
        getOneBookResponse.then().assertThat().statusCode(200);

        System.out.println("========================");
        getOneBookResponse.prettyPrint();

        //Assertions using hamcrest.Matchers.equalTo method

        getOneBookResponse.then().assertThat().body("title", equalTo("Understanding ECMAScript 6"));

        getOneBookResponse.then().assertThat().body("subTitle",containsString("Guide"));

        getOneBookResponse.then().assertThat().body("author", endsWith("Zakas"));
    }
}
