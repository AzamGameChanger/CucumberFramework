package com.codewithazam.utils;

public class APIConstants {

    public static final String BASE_URI = "https://bookstore.toolsqa.com";

    public static final String GENERATE_TOKEN_ENDPOINT = "/Account/v1/GenerateToken";
    public static final String GET_ACCOUNT_ENDPOINT = "/Account/v1/User/{UUID}";
    public static final String POST_LIST_OF_BOOKS_ENDPOINT = "/BookStore/v1/Books";
    public static final String DELETE_ALL_BOOKS_ENDPOINT = "/BookStore/v1/Books";
    public static final String UPDATE_ONE_BOOK_ENDPOINT = "/BookStore/v1/Books/{ISBN}";
    public static final String CREATE_USER_ENDPOINT = "/Account/v1/User";
    public static final String DELETE_ACCOUNT_ENDPOINT = "/Account/v1/User/{UUID}";
    public static final String GET_ONE_BOOK_ENDPOINT = "/BookStore/v1/Book";
}
