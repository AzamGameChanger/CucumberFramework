package com.codewithazam.steps;

import com.codewithazam.utils.CommonMethods;
import com.codewithazam.utils.ConfigsReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SignalTelecomSteps extends CommonMethods {

    @When("User enters invalid email")
    public void user_enters_invalid_email() {
        sendText(signal.username, "Bla-bls");
    }

    @When("USer enters an invalid password")
    public void u_ser_enters_an_invalid_password() {
        sendText(signal.password, "la-la-la");
    }

    @When("User clicks on Sign In button")
    public void user_clicks_on_sign_in_button() {
        jsClick(signal.loginBtn);
    }

    @Then("User sees an error message")
    public void user_sees_an_error_message() {
        String expectedText = "Invalid Login or Password.";
        String actualText = signal.errorMsg.getText();

        Assert.assertEquals("The text is different!", expectedText, actualText);
    }

    @When("User leaves username email")
    public void user_leaves_username_email() {
        sendText(signal.username, "");
    }

    @When("User enters an invalid username as  {string}")
    public void user_enters_an_invalid_username_as(String userName) {
        sendText(signal.username, userName);
    }
    @When("User enters an invalid password as {string}")
    public void user_enters_an_invalid_password_as(String password) {
        sendText(signal.password, password);
    }

    @Then("User validates the error message")
    public void user_validates_the_error_message() {
       Assert.assertEquals(true, false);
    }

}
