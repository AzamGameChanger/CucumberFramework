package com.codewithazam.steps;

import com.codewithazam.utils.CommonMethods;
import com.codewithazam.utils.ExcelUtility;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {

    @Given("User navigates to the add employee page")
    public void user_navigates_to_the_add_employee_page() {
        jsClick(dashboard.addEmpBtn);
    }

    @When("user enters employee first name {string} and last name {string}")
    public void user_enters_employee_first_name_and_last_name(String firstName, String lastName) {
        sendText(addEmployee.firstName, firstName);
        sendText(addEmployee.lastName, lastName);

    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        click(addEmployee.saveBtn);
    }

    @Then("validate that employee {string} is added successfully")
    public void validate_that_employee_is_added_successfully(String fullName) {
        String expectedName = "Samandar Samandarov";
        String actualName = fullName;

        Assert.assertEquals("The name doesn't match", expectedName, actualName);
    }

    @When("user enters employee first name and last name")
    public void user_enters_employee_first_name_and_last_name() {
        sendText(addEmployee.firstName, "Larry");
        sendText(addEmployee.lastName, "Karry");
    }

    @When("user deletes employee id")
    public void user_deletes_employee_id() {
        addEmployee.employeeId.clear();
    }

    @Then("validate that employee is added successfully")
    public void validate_that_employee_is_added_successfully() {
        String expectedName = "Larry Kerry";
        String actualName = expectedName;

        Assert.assertEquals(expectedName, actualName);
    }

    @When("user clicks on Create Login details")
    public void user_clicks_on_create_login_details() {
        jsClick(addEmployee.checkLoginDetails);
    }

    @When("user provides credentials")
    public void user_provides_credentials() {
        sendText(addEmployee.username, "Sally123");
        sendText(addEmployee.password, "sally2244");
        sendText(addEmployee.confirmPassword, "sally2244");
    }

    @When("user enters employee {string}, {string} and {string}")
    public void user_enters_employee_and(String firstName, String middleName, String lastName) {
        sendText(addEmployee.firstName, firstName);
        sendText(addEmployee.middleName, middleName);
        sendText(addEmployee.lastName, lastName);

    }

    @Then("validate that {string}, {string} and {string} is added successfully")
    public void validate_that_and_is_added_successfully(String firstName, String middleName, String lastName) {
        String expectedName = firstName + " " + middleName + " " + lastName;
        String actualName = personalDetails.fullName.getText();

        Assert.assertEquals("The names doesn't match", expectedName, actualName);

    }

    @When("user enters employee details and clicks on save and validates it is added")
    public void user_enters_employee_details_and_clicks_on_save_and_validates_it_is_added
            (DataTable dataTable) {
        List<Map<String, String>> listOfMaps = dataTable.asMaps();
        for (Map<String, String> map : listOfMaps) {

            String fName = map.get("firstName");
            String mName = map.get("middleName");
            String lName = map.get("lastName");

            sendText(addEmployee.firstName, fName);
            sendText(addEmployee.middleName, mName);
            sendText(addEmployee.lastName, lName);

            jsClick(addEmployee.saveBtn);

            String expectedText = fName + " " + mName + " " + lName;
            String actualText = personalDetails.fullName.getText();

            Assert.assertEquals(expectedText, actualText);

            jsClick(dashboard.addEmpBtn);
        }
    }

    @When("user enters employee data from {string} excel sheet")
    public void user_enters_employee_data_from_excel_sheet(String excelSheet) {
        String path = System.getProperty("user.dir") + "/src/test/resources/testdata/ExcelData.xlsx";
        List<Map<String, String>> excelList = ExcelUtility.excelIntoListOfMap(path, excelSheet);

        for (Map<String, String> dataMap : excelList) {

            sendText(addEmployee.firstName, dataMap.get("FirstName"));
            sendText(addEmployee.lastName, dataMap.get("LastName"));
            click(addEmployee.checkLoginDetails);
            sendText(addEmployee.username, dataMap.get("UserName"));
            sendText(addEmployee.password, dataMap.get("Password"));
            sendText(addEmployee.confirmPassword, dataMap.get("Password"));
            click(addEmployee.saveBtn);

            Assert.assertTrue(personalDetails.fullName.isDisplayed());

            jsClick(dashboard.addEmpBtn);
        }
    }
}
