package com.codewithazam.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "com.codewithazam.steps",
        dryRun = false, // if true gets us java methods; if false runs our code
        monochrome = true,
        tags = "@signal", //OR runs tests with existing tags, AND runs tests with both tags
        plugin = {
                "pretty",
                "json:target/cucumber.json",
                "rerun:target/failed.txt"
        }
)

public class SignalRunner {
}
