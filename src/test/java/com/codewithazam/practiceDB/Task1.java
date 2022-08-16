package com.codewithazam.practiceDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static String dbUsername = "signalt_user1";
    public static String dbPassword = "trpass@2020";
    public static String dbUrl = "jdbc:mysql://66.113.163.71:3306/signalt_LibraryMgmt";

    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM bookcategory");

        List<String> categoryNames = new ArrayList<>();
        while (rs.next()) {
            String bookCategoryName = rs.getObject("BookCategoryName").toString();
            categoryNames.add(bookCategoryName);
        }

        System.out.println(categoryNames);
        for (String name: categoryNames){
            System.out.println(name);
        }

        rs.close();
        st.close();
        conn.close();


    }
}
