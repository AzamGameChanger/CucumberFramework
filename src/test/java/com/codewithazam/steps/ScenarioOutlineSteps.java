package com.codewithazam.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ScenarioOutlineSteps {
    @When("Login with {string} and {string}")
    public void login_with_and(String username, String password) {
        System.out.println("Login with -> " + username + " and -> " + password);
    }
    @When("I click on login button")
    public void i_click_on_login_button() {
        System.out.println("Click");
    }
    @Then("I validate the Welcome {string} is displayed")
    public void i_validate_the_welcome_is_displayed(String username) {
        System.out.println("Validating welcome -> " + username);
    }
    @Then("We say bye {string}")
    public void we_say_bye(String fullName) {
        System.out.println("Bye bye -> " + fullName);
    }
}
