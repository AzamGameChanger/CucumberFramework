package com.codewithazam.practiceDB;

import com.codewithazam.utils.ConfigsReader;
import com.codewithazam.utils.Constants;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StoringData {
    //@Test
    public void getAndStoreData() throws SQLException {
        ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        Connection conn = DriverManager.getConnection(
                ConfigsReader.getProperty("dbUrl"), ConfigsReader.getProperty("dbUsername"), ConfigsReader.getProperty("dbPassword"));
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select employeeNumber, lastName, firstName, email from signalt_classicmodels.employees");

        List<Map<String, String>> listOfMaps = new ArrayList<>();
        Map<String, String> map;
        while (rs.next()) {
            map = new LinkedHashMap<>();
            map.put("Employee Number", rs.getString("employeeNumber"));
            map.put("Last Name", rs.getString("lastName"));
            map.put("First Name", rs.getString("firstName"));
            map.put("Email", rs.getString("email"));
            listOfMaps.add(map);
        }
        System.out.println(listOfMaps);

        rs.close();
        st.close();
        conn.close();
    }

    @Test
    public void retrieveAndStoreData() throws SQLException {
        ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        Connection conn = DriverManager.getConnection(
                ConfigsReader.getProperty("dbUrl"), ConfigsReader.getProperty("dbUsername"), ConfigsReader.getProperty("dbPassword"));
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select customerNumber, customerName, contactLastName from customers where customerNumber < 130");
        ResultSetMetaData rsMetaData = rs.getMetaData();
        int colCount = rsMetaData.getColumnCount();
        List<Map<String ,String>> mapList = new ArrayList<>();
        Map<String, String> map;
        while (rs.next()){
            map = new LinkedHashMap<>();
            for (int i = 1; i <= colCount; i++){
                String columnName =  rsMetaData.getColumnName(i);
                String  columnValue = rs.getString(i);
                map.put(columnName, columnValue);
            }
            mapList.add(map);
        }
        System.out.println(mapList);

    }
}
