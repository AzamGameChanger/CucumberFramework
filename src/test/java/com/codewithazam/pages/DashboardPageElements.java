package com.codewithazam.pages;

import com.codewithazam.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPageElements extends CommonMethods {

    public DashboardPageElements() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "welcome")
    public WebElement welcomeMsg;

    @FindBy(xpath = "//a[@id='menu_pim_viewPimModule']")
    public WebElement PIM;

    @FindBy(id="menu_pim_viewEmployeeList")
    public WebElement employeeList;

    @FindBy(id = "menu_pim_addEmployee")
    public WebElement addEmpBtn;

    @FindBy(linkText = "Logout")
    public WebElement logOutBtn;

    @FindBy(xpath = "//*[@id='mainMenuFirstLevelUnorderedList']/li/a")
    public List<WebElement> menuList;

}
