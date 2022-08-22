package com.codewithazam.PracticeAPI.Day2;

import com.codewithazam.utils.APIConstants;
import com.codewithazam.utils.APIGlobalVariables;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

public class Post_AddListOfBooks {

    @Test
    public void addListOfBooks() {
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
        // System.out.println(payload);

        RestAssured.baseURI = APIConstants.BASE_URI;

        RestAssured.
                given().
                    auth().oauth2(APIGlobalVariables.token).
                    contentType(ContentType.JSON).
                    body(payload).
                when().
                    post(APIConstants.POST_LIST_OF_BOOKS_ENDPOINT).
                    prettyPeek().
                then().
                    assertThat().statusCode(201).
                and().
                    body("books[0].isbn", is(APIGlobalVariables.book1)).
                and().
                    body("books[1].isbn", is(APIGlobalVariables.book2));
    }
}
