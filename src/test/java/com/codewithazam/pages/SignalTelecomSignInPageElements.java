package com.codewithazam.pages;

import com.codewithazam.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignalTelecomSignInPageElements extends CommonMethods {

    public SignalTelecomSignInPageElements(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="ctl00_MainContent_username")
    public WebElement username;

    @FindBy(id = "ctl00_MainContent_password")
    public WebElement password;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_login_button']")
    public WebElement loginBtn;

    @FindBy(id = "ctl00_MainContent_status")
    public WebElement errorMsg;
}
