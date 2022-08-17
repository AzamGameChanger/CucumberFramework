package com.codewithazam.steps;

import com.codewithazam.testbase.Base;
import com.codewithazam.utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    //@Before
    public void openBrowser() {
        Base.setUp();
    }

    //@After
    public void closeBrowser(Scenario scenario) {
        byte[] picture;

        if (scenario.isFailed()) {
            picture = CommonMethods.takeScreenshot("failed/" + scenario.getName());
        } else {
            picture = CommonMethods.takeScreenshot("passed/" + scenario.getName());
        }

        scenario.attach(picture,"image/png", scenario.getName());

        Base.tearDown();
    }
}
