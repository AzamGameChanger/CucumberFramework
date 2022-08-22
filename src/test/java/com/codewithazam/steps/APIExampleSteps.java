package com.codewithazam.steps;

import com.codewithazam.utils.APIConstants;
import com.codewithazam.utils.APIGlobalVariables;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.is;

public class APIExampleSteps {
    Response response;

    @When("I add a book to the account")
    public void i_add_a_book_to_the_account() {
        String payload = "{\n" +
                "  \"userId\": \"" + APIGlobalVariables.userID + "\",\n" +
                "  \"collectionOfIsbns\": [\n" +
                "    {\n" +
                "      \"isbn\": \""+APIGlobalVariables.book1 +"\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"isbn\": \""+APIGlobalVariables.book2 +"\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        RestAssured.
                given().
                    auth().oauth2(GenerateTokenUtil.token).
                    contentType(ContentType.JSON).
                    body(payload).
                when().
                    post(APIConstants.POST_LIST_OF_BOOKS_ENDPOINT).
                    prettyPeek();
    }
    @When("I get the account information")
    public void i_get_the_account_information() {
        response = RestAssured.
                        given().
                            header("Authorization","Bearer " + GenerateTokenUtil.token).
                            pathParam("UUID", APIGlobalVariables.userID).
                        when().
                            get(APIConstants.GET_ACCOUNT_ENDPOINT);
        response.prettyPeek();
    }
    @Then("I validate that the book is in the account")
    public void i_validate_that_the_book_is_in_the_account() {
        response.then().assertThat().body("books.size()",is(2)).
                and().assertThat().body("books[0].isbn",is(APIGlobalVariables.book1));

    }

}
