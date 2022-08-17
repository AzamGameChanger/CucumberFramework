package com.codewithazam.steps;

import com.codewithazam.utils.DBUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class DBSteps {
    List<Map<String, String>> customerList;

    @Given("I am connected to the database")
    public void i_am_connected_to_the_database() {
        DBUtils.getConnection();
        System.out.println("Connection successful");
    }

    @When("I get the top three customers by credit limit")
    public void i_get_the_top_three_customers_by_credit_limit() {
        customerList =
                DBUtils.storeDataFromDB("select * from customers order by creditLimit DESC limit 3");
        //System.out.println(customerList);
    }

    @Then("I print their names and credit limits")
    public void i_print_their_names_and_credit_limits() {
        System.out.println("--------------------------");
        for (Map<String,String> customer:customerList){
            String name = customer.get("customerName");
            String creditLimit = customer.get("creditLimit");
            System.out.println(name + " -> " + creditLimit);
        }
        System.out.println("--------------------------");
    }

    @Then("I close the database connection")
    public void i_close_the_database_connection() {
        DBUtils.closeConnection();
        System.out.println("Connection closed");
    }

}
