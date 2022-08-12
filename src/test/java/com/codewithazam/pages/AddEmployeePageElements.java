package com.codewithazam.pages;

import com.codewithazam.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePageElements extends CommonMethods {

    public AddEmployeePageElements() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "input[name='firstName']")
    public WebElement firstName;

    @FindBy(id = "middleName")
    public WebElement middleName;

    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement lastName;

    @FindBy(id = "btnSave")
    public WebElement saveBtn;

    @FindBy(id = "employeeId")
    public WebElement employeeId;

    @FindBy(css = "#chkLogin")
    public WebElement checkLoginDetails;

    @FindBy(id="user_name")
    public WebElement username;

    @FindBy(id = "user_password")
    public WebElement password;

    @FindBy(xpath = "//input[@id='re_password']")
    public WebElement confirmPassword;
}
