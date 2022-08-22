package com.codewithazam.steps;

import com.codewithazam.utils.APIConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class GenerateTokenSteps {
    RequestSpecification request;
    Response response;

    @Given("I create a generate token request")
    public void i_create_a_generate_token_request() {
        RestAssured.baseURI = APIConstants.BASE_URI;
        request = RestAssured.given();
    }

    @Given("I provide the header for generate token request")
    public void i_provide_the_header_for_generate_token_request() {
        //request.header("Content-type","application/json");
        request.contentType(ContentType.JSON);

    }


    @Given("I provide the body for generate token request")
    public void i_provide_the_body_for_generate_token_request() {
        String payload = "{\n" +
                "  \"userName\": \"Samira\",\n" +
                "  \"password\": \"Atasoy@123\"\n" +
                "}";
       // System.out.println(payload);
        request.body(payload);
    }

    @When("I make a Post call to generate token endpoint")
    public void i_make_a_post_call_to_generate_token_endpoint() {
        response = request.when().post(APIConstants.GENERATE_TOKEN_ENDPOINT);
        response.prettyPeek();
    }

    @Then("I validate that the status code for generate token request is {int}")
    public void i_validate_that_the_status_code_for_generate_token_request_is(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }

    @Then("I validate that body contains {string}")
    public void i_validate_that_body_contains(String expectedText) {
        response.then().assertThat().body(containsString(expectedText));
    }

    @Then("I validate that the value of {string} is {string}")
    public void i_validate_that_the_value_of_is(String key, String value) {
        response.then().assertThat().body(key,equalTo(value));
    }

}
