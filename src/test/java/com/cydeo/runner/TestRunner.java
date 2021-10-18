package com.cydeo.runner;

// This class has only one purpose
// Instructing how and what feature we want to run
// features = "src/test/resources/features"
// where are the step definitions
//  glue = "com/cydeo/step_definitions"
// do we want to just generate missing step definitions
//dryRun=true will run the test without failing for missing steps
// so you can copy all the missing steps if there is any

// do we want to get json , html report
// do we want to filter the test run according to certain tags

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( features = "classpath:features", //"src/test/resources/features",
                        glue = "com/cydeo/step_definitions",
                        publish = true,//will give you public link to your local html report
                        plugin = {"pretty",
                                "rerun:target/rerun.txt",//store the failed tests
                                "html:target/cucumber_report.html",
                                "me.jvt.cucumber.report.PrettyReports:target"
                        },
                        dryRun = false,
                        tags = "@calculator" //"not @ui" //"@smoke or @salad" run whatever is not ui
        )
public class TestRunner {


}
