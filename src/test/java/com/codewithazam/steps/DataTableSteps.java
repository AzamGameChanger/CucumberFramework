package com.codewithazam.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class DataTableSteps {

    @When("I login to HRMS")
    public void i_login_to_hrms() {
        System.out.println("Login");
    }

    @When("I want to add employees")
    public void i_want_to_add_employees(DataTable dataTable) {
        List<Map<String, String>> maps = dataTable.asMaps();
        for (Map<String, String> map : maps) {
            System.out.println("------------------------------------------");
            System.out.println("Start using data from the map!!!");
            System.out.println("FirstName = " + map.get("FirstName"));
            System.out.println("MiddleName = " + map.get("MiddleName"));
            System.out.println("LastName = " + map.get("LastName"));

        }

    }

    @Then("I validate the outcomes")
    public void i_validate_the_outcomes() {
        System.out.println("Validating");
    }
}
