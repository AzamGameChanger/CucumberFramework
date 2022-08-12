package com.codewithazam.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/resources/features/LoginToOrangeHRM.feature",
        glue = "com.codewithazam.steps",
        dryRun = false, // if true gets us java methods; if false runs our code
        monochrome = true,
        tags = "@smoke", //OR runs tests with existing tags, AND runs tests with both tags
        plugin = {
                "pretty",
                "html:target/cucumber-default-report.html",
                "json:target/cucumber.json"
        }
)
public class TestRunner {
}
