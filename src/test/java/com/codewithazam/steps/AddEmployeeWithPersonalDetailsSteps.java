package com.codewithazam.steps;

import com.codewithazam.utils.CommonMethods;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddEmployeeWithPersonalDetailsSteps extends CommonMethods {

    @When("I click on Personal Details Edit")
    public void i_click_on_personal_details_edit() {
        jsClick(personalDetails.personalDetailsEditBtn);
    }
    @Then("I am able to modify Employee Details {string}, {string}, {string}, {string}, {string}")
    public void i_am_able_to_modify_employee_details
            (String driverLicence, String expirationDate, String ssn, String gender, String nationality) {
        sendText(personalDetails.driverLicenseNm, driverLicence);
        sendText(personalDetails.expiryDate, expirationDate);
        sendText(personalDetails.ssnNumber, ssn);

        if (gender.equalsIgnoreCase("male"))
            jsClick(personalDetails.male);
        else
            click(personalDetails.female);

        selectDropdown(personalDetails.nationality, nationality);

    }
    @Then("I click on Personal Details Save")
    public void i_click_on_personal_details_save() {
        click(personalDetails.personalDetailsEditBtn);
    }


}
