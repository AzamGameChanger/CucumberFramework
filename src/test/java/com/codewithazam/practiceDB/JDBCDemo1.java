package com.codewithazam.practiceDB;

import java.sql.*;

public class JDBCDemo1 {
    public static String dbUsername = "signalt_user1";
    public static String dbPassword = "trpass@2020";
    public static String dbUrl = "jdbc:mysql://66.113.163.71:3306/signalt_LibraryMgmt";

    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        System.out.println("Database connection is successful!");

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM book");
        System.out.println("------------------------------------------");

        rs.next();
        String bookName1 = rs.getString("BookName");
        System.out.println(bookName1);

        rs.next();
        String bookName2 = rs.getString("BookName");
        System.out.println(bookName2);

        rs.next();
        String bookName3 = rs.getObject("BookName").toString();
        System.out.println(bookName3);

        System.out.println("-----------Printing values using while loop---------");
        while (rs.next()){
            String bookName = rs.getString("BookName");
            System.out.println(bookName);
        }

        rs.close();
        st.close();
        conn.close();
    }
}
