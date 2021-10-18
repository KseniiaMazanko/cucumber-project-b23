package com.cydeo.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//This is only for running failed test scenarios inside rerun.txt!!! nothing else

    @RunWith(Cucumber.class)
    @CucumberOptions(
                        glue = "com/cydeo/step_definitions",
                        features = "@target/rerun.txt"
    )
    public class FailedTestRunner {

}
