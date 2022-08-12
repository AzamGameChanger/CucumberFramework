package com.codewithazam.steps;

import com.codewithazam.utils.CommonMethods;
import com.codewithazam.utils.ConfigsReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class LoginSteps extends CommonMethods {

    @Given("I navigated to Orange HRM website")
    public void i_navigated_to_orange_hrm_website() {
        setUp();
    }

    @When("I enter a valid username")
    public void i_enter_a_valid_username() {
        sendText(login.username, ConfigsReader.getProperty("username"));
    }

    @When("I enter a valid password")
    public void i_enter_a_valid_password() {
        sendText(login.password, ConfigsReader.getProperty("password"));
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        jsClick(login.loginBtn);
    }

    @Then("I validate that I am logged in")
    public void i_validate_that_i_am_logged_in() {
        boolean welcomeMsgDisplayed = dashboard.welcomeMsg.isDisplayed();
        Assert.assertTrue(welcomeMsgDisplayed);
    }

    @Then("I quit the browser")
    public void i_quit_the_browser() {
        tearDown();
    }

    @When("I enter an invalid password")
    public void i_enter_an_invalid_password() {
        sendText(login.password, "bla-bla");
    }

    @Then("I validate that Invalid credentials message is displayed")
    public void i_validate_that_invalid_credentials_message_is_displayed() {
        String expectedMsg = "Invalid credentials";
        String errorMsg = login.errorMsg.getText();
        Assert.assertEquals(expectedMsg, expectedMsg);
    }

    @When("user enters login info {string} and {string}")
    public void user_enters_login_info_and(String user, String pass) {
        sendText(login.username, user);
        sendText(login.password, pass);
        click(login.loginBtn);
    }

    @Then("Welcome {string} message is displayed")
    public void welcome_message_is_displayed(String firstName) {

    }

    @When("user enters username and password and clicks on login")
    public void user_enters_username_and_password_and_clicks_on_login(DataTable dataTable) {
        List<Map<String, String>> maps = dataTable.asMaps();
        for (Map<String, String> map : maps) {

            sendText(login.username, map.get("username"));
            sendText(login.password, map.get("password"));
            jsClick(login.loginBtn);
            wait(1);

            String expectedText = "Welcome " + map.get("firstname");
            String actualText = dashboard.welcomeMsg.getText();

            Assert.assertEquals("The text is different!!!", expectedText, actualText);

            jsClick(dashboard.welcomeMsg);
            click(dashboard.logOutBtn);

        }
    }


}
