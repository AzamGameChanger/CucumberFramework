package com.codewithazam.practiceDB;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static String dbUsername = "signalt_user1";
    public static String dbPassword = "trpass@2020";
    public static String dbUrl = "jdbc:mysql://66.113.163.71:3306/signalt_classicmodels";

//    Connect to signalt_classicmodels database
//    Execute a query to get all information of customer with id 124
//    Get the resultset metadata
//    Print the number of columns
//    Get all the column names and store them in an arraylist
//    Print the Arraylist

    @Test
    public void rsMetaData() throws SQLException {
        Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from customers where customerNumber = 124");

        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        System.out.println("Column Count => " + columnCount);

        List<String> columnNames = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = metaData.getColumnName(i);
            columnNames.add(columnName);
        }

        for (String name: columnNames){
            System.out.println(name);
        }
    }
}
