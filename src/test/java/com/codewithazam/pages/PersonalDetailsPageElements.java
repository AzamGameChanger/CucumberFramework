package com.codewithazam.pages;

import com.codewithazam.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDetailsPageElements extends CommonMethods {

    public PersonalDetailsPageElements (){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='profile-pic']/h1")
    public WebElement fullName;

    @FindBy(id = "btnSave")
    public WebElement personalDetailsEditBtn;

    @FindBy(xpath = "//input[@id='personal_txtLicenNo']")
    public WebElement driverLicenseNm;

    @FindBy(css = "#personal_txtLicExpDate")
    public WebElement expiryDate;

    @FindBy(id = "personal_txtNICNo")
    public WebElement ssnNumber;

    @FindBy(id = "personal_optGender_1")
    public WebElement male;

    @FindBy(id = "personal_optGender_2")
    public WebElement female;

    @FindBy(id = "personal_cmbNation")
    public WebElement nationality;
}
