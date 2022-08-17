package com.codewithazam.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {

    public static Connection conn;
    public static Statement statement;
    public static ResultSet resultSet;

    public static void getConnection() {
        ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

        try {
            conn = DriverManager.getConnection(
                    ConfigsReader.getProperty("dbUrl"), ConfigsReader.getProperty("dbUsername"), ConfigsReader.getProperty("dbPassword"));

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public static List<Map<String, String>> storeDataFromDB(String sqlQuery) {
        List<Map<String, String>> listData = new ArrayList<>();
        ;
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sqlQuery);

            ResultSetMetaData metaData = resultSet.getMetaData();


            while (resultSet.next()) {
                Map<String, String> mapData = new LinkedHashMap<>();

                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    mapData.put(metaData.getColumnName(i), resultSet.getString(i));
                }
                listData.add(mapData);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return listData;
    }

    public static void closeConnection() {

        try {
            if (resultSet != null)
                resultSet.close();
            if (statement != null)
                statement.close();
            if (conn != null)
                conn.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
