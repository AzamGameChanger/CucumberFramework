package com.codewithazam.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {

    @Given("I navigated to google")
    public void i_navigated_to_google() {
        System.out.println("Opening Google Website");
    }
    @When("I type a search item in the search box")
    public void i_type_a_search_item_in_the_search_box() {
        System.out.println("Typing in the search box!");
    }
    @When("I click on the search button")
    public void i_click_on_the_search_button() {
        System.out.println("Clicking search");
    }
    @Then("I see the result of my search")
    public void i_see_the_result_of_my_search() {
        System.out.println("I validate the results");
    }
    @Then("I see the number of results")
    public void i_see_the_number_of_results() {
        System.out.println("Validating the number of results");
    }

    @When("I say what I want to search")
    public void i_say_what_i_want_to_search() {
        System.out.println("Saying what I want to search");
    }


}
