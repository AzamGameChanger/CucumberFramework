package com.codewithazam.PracticeAPI.Day2;

import com.codewithazam.utils.APIConstants;
import com.codewithazam.utils.APIGlobalVariables;
import io.restassured.RestAssured;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Get_Account {

    @Test
    public void getAccount(){
        RestAssured.baseURI = APIConstants.BASE_URI;

        RestAssured.
                given().
                    header("Authorization","Bearer " + APIGlobalVariables.token).
                    // auth().oauth2(APIGlobalVariables.token) -> another way of providing a token
                    pathParam("UUID", APIGlobalVariables.userID).
                when().
                    get(APIConstants.GET_ACCOUNT_ENDPOINT).
                    prettyPeek().
                then().
                    assertThat().statusCode(200).
                and().
                    body("userId", is(APIGlobalVariables.userID)).
                and().
                    body("username", equalTo("DummyTester")).
                and().
                    assertThat().body("books.size()",equalTo(2));
    }
}
