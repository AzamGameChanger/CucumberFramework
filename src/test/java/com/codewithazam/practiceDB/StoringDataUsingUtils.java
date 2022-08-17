package com.codewithazam.practiceDB;

import com.codewithazam.utils.DBUtils;
import io.cucumber.java.it.Ma;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class StoringDataUsingUtils {

    @Test
    public void getDataFromDB(){
        DBUtils.getConnection();

        List<Map<String , String>> mapList =  DBUtils.storeDataFromDB
                ("select employeeNumber, email from employees limit 5");
        System.out.println(mapList);

        DBUtils.closeConnection();
    }
}
