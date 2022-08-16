package com.codewithazam.practiceDB;

import org.junit.Test;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class MetaDataDemo {

    public static String dbUsername = "signalt_user1";
    public static String dbPassword = "trpass@2020";
    public static String dbUrl = "jdbc:mysql://66.113.163.71:3306/signalt_classicmodels";

    @Test
    public void dbMetaData() throws SQLException {
        Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        DatabaseMetaData dbMetaData = conn.getMetaData();
        String driverName = dbMetaData.getDriverName();
        System.out.println(driverName);
        String databaseProductVersion = dbMetaData.getDatabaseProductVersion();
        System.out.println(databaseProductVersion);
        String databaseProductName = dbMetaData.getDatabaseProductName();
        System.out.println(databaseProductName);
    }

    @Test
    public void dbResultMetaData() throws SQLException {
        Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM employees WHERE employeeNumber = 1076");

        ResultSetMetaData rsMetaData = rs.getMetaData();

        int columnCount = rsMetaData.getColumnCount();
        System.out.println(columnCount);

        String columnName1 = rsMetaData.getColumnName(1);
        System.out.println(columnName1);

        System.out.println("-----------------------------------------------------");
        for (int i = 1; i <= columnCount; i++){
            System.out.println(rsMetaData.getColumnName(i));
        }

        System.out.println("-----------------------------------------------------");
        for (int i = 1; i <= columnCount; i++) {
            System.out.println(rsMetaData.getColumnTypeName(i));
        }

        rs.close();
        st.close();
        conn.close();
    }
}

