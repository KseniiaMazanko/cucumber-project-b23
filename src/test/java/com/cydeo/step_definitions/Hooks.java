package com.cydeo.step_definitions;

import com.cydeo.utility.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    // We can set up a hook class that contains methods that run before each
    //scenarios of after each scenarios
    //or even when we learn tags
    //we can run certain code before and after each scenario that tagged with certain tag
    @Before("@ui")
    public void setupDriver(){
        System.out.println("This is from @Before inside Hooks class");
        //setup implicit wait
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();

    }

    @After("@ui")
    public void tearDown(Scenario scenario){

        //check if scenario failed or not

        if(scenario.isFailed()){
            //this is how we take screenshot in selenium
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", scenario.getName());

        }

        System.out.println("This is from @AFter inside Hooks class");
        Driver.closeBrowser();

    }




}
