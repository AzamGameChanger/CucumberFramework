package com.codewithazam.PracticeAPI.Day2;

import com.codewithazam.utils.APIConstants;
import com.codewithazam.utils.APIGlobalVariables;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

public class Put_UpdateOneBook {

    @Test
    public void updateOneBook() {
        String payload = "{\n" +
                "  \"userId\": \""+APIGlobalVariables.userID+"\",\n" +
                "  \"isbn\": \""+APIGlobalVariables.book4+"\"\n" +
                "}";

        //System.out.println(payload);

        RestAssured.baseURI = APIConstants.BASE_URI;
        RestAssured.
                given().
                    header("Authorization", "Bearer " + APIGlobalVariables.token).
                    pathParam("ISBN", APIGlobalVariables.book1).
                    body(payload).
                    contentType(ContentType.JSON).
                when().
                    put(APIConstants.UPDATE_ONE_BOOK_ENDPOINT).
                    prettyPeek().
                then().
                    assertThat().statusCode(200).
                and().
                    body("userId", is(APIGlobalVariables.userID));


    }
}
