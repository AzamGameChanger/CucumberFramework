package com.codewithazam.testbase;

import com.codewithazam.pages.*;

public class PageInitializer extends Base{

    public static LoginPageElements login;
    public static DashboardPageElements dashboard;
    public static AddEmployeePageElements addEmployee;
    public static PersonalDetailsPageElements personalDetails;
    public static SignalTelecomSignInPageElements signal;


    public static void initialize(){
        login = new LoginPageElements();
        dashboard = new DashboardPageElements();
        addEmployee = new AddEmployeePageElements();
        personalDetails = new PersonalDetailsPageElements();
        signal = new SignalTelecomSignInPageElements();
    }
}
