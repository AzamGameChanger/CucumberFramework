package com.codewithazam.steps;

import com.codewithazam.utils.APIConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class APIGetOneBookSteps {
    RequestSpecification getOneBookRequest;
    Response getOneBookResponse;

    @Given("I create a get one book request")
    public void i_create_a_get_one_book_request() {
        RestAssured.baseURI = APIConstants.BASE_URI;
        getOneBookRequest = RestAssured.given();
    }

    @Given("I provide ISBN {string} as a query parameter")
    public void i_provide_isbn_as_a_query_parameter(String isbn) {
        getOneBookRequest.queryParam("ISBN", isbn);
    }

    @When("I make a Get call to the Get One Book endpoint")
    public void i_make_a_get_call_to_the_get_one_book_endpoint() {
        getOneBookResponse = getOneBookRequest.when().get(APIConstants.GET_ONE_BOOK_ENDPOINT);

        // This will print the response to the console
        getOneBookResponse.prettyPeek();
    }

    @Then("I validate that status code for getting a book is {int}")
    public void i_validate_that_status_code_for_getting_a_book_is(Integer statusCode) {
        getOneBookResponse.then().assertThat().statusCode(statusCode);
    }

    @Then("I validate that the ISBN in the response body is {string}")
    public void i_validate_that_the_isbn_in_the_response_body_is(String expectedIsbn) {
        getOneBookResponse.then().assertThat().body("isbn", equalTo(expectedIsbn));
    }

    @Then("I validate that book title is {string}")
    public void i_validate_that_book_title_is(String bookTitle) {
        getOneBookResponse.then().assertThat().body("title", is(bookTitle));
    }

}
