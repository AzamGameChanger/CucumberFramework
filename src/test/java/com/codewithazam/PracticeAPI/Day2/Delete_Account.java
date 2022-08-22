package com.codewithazam.PracticeAPI.Day2;

import com.codewithazam.utils.APIConstants;
import com.codewithazam.utils.APIGlobalVariables;
import io.restassured.RestAssured;
import org.junit.Test;

public class Delete_Account {

    @Test
    public void deleteUserAccount(){
        RestAssured.baseURI = APIConstants.BASE_URI;

        RestAssured.
                given().
                    auth().oauth2(APIGlobalVariables.token).
                    pathParam("UUID",APIGlobalVariables.userID).
                when().
                    delete(APIConstants.DELETE_ACCOUNT_ENDPOINT).
                    prettyPeek().
                then().
                    assertThat().statusCode(204);

    }
}
