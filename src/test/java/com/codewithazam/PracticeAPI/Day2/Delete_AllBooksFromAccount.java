package com.codewithazam.PracticeAPI.Day2;

import com.codewithazam.utils.APIConstants;
import com.codewithazam.utils.APIGlobalVariables;
import io.restassured.RestAssured;
import org.junit.Test;

public class Delete_AllBooksFromAccount {

    @Test
    public void deleteAllBooks(){
        RestAssured.baseURI = APIConstants.BASE_URI;
        RestAssured.
                given().
                    auth().oauth2(APIGlobalVariables.token).
                    queryParam("UserId", APIGlobalVariables.userID).
                when().
                    delete(APIConstants.DELETE_ALL_BOOKS_ENDPOINT).
                    prettyPeek().
                then().
                    assertThat().statusCode(204);
    }
}
