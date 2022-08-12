package com.codewithazam.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BackgroundExampleSteps {
    @Given("Precondition1")
    public void precondition1() {
        System.out.println("Running Precondition1");
    }

    @Given("Precondition2")
    public void precondition2() {
        System.out.println("Running Precondition2");
    }

    @When("Test step Nr1")
    public void test_step_nr1() {
        System.out.println("Running Test step Nr1");
    }

    @When("Test step nr2")
    public void test_step_nr2() {
        System.out.println("Running Test step Nr2");
    }

    @Then("Validation Nr1")
    public void validation_nr1() {
        System.out.println("Running Validation Nr1");
    }

    @Then("Validation Nr2")
    public void validation_nr2() {
        System.out.println("Running Validation Nr2");
    }

    @When("Test step Nr3")
    public void test_step_nr3() {
        System.out.println("Running Test Nr2");
    }

    @When("Test step nr4")
    public void test_step_nr4() {
        System.out.println("Running Test Nr4");
    }

    @Then("Validation Nr3")
    public void validation_nr3() {
        System.out.println("Running Validation Nr3");

    }

    @Then("Validation Nr4")
    public void validation_nr4() {
        System.out.println("Running Validation Nr4");
    }
    @When("Test step Nr1 firstName is {string} and lastName is {string}")
    public void test_step_nr1_first_name_is_and_last_name_is(String firstName, String lastName) {
        System.out.println("Test step Nr1 firstname = " + firstName + " and lastname = " + lastName);
    }

    @When("Test step nr2 age is {int}")
    public void test_step_nr2_age_is(Integer age) {
        System.out.println("Test step Nr2 age = " + age);
    }

}
