package com.codewithazam.steps;

import com.codewithazam.utils.CommonMethods;
import com.codewithazam.utils.ConfigsReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeSearchSteps extends CommonMethods {

    @Given("User is logged in with valid credentials")
    public void user_is_logged_in_with_valid_credentials() {
        sendText(login.username, ConfigsReader.getProperty("username"));
        sendText(login.password, ConfigsReader.getProperty("password"));
        jsClick(login.loginBtn);
    }

    @Given("User navigates to the employee user pages")
    public void user_navigates_to_the_employee_user_pages() {
        jsClick(dashboard.PIM);
    }

    @When("User enters valid employee ID")
    public void user_enters_valid_employee_id() {

    }

    @When("Clicks on search button")
    public void clicks_on_search_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Employee information is displayed")
    public void employee_information_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @When("User enters valid employee first and last name")
    public void user_enters_valid_employee_first_and_last_name() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
