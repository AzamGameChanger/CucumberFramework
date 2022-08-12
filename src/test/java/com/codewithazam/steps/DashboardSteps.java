package com.codewithazam.steps;

import com.codewithazam.utils.CommonMethods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DashboardSteps extends CommonMethods {

    @When("I want to see this items in the menu")
    public void i_want_to_see_this_items_in_the_menu(DataTable dataTable) {
        List<String> expectedList = dataTable.asList();

        List<String> actualList = new ArrayList<>();
        List<WebElement> menu = dashboard.menuList;

        for (WebElement element: menu){
            actualList.add(element.getText());
        }
        Assert.assertEquals(expectedList,actualList);

    }

}
