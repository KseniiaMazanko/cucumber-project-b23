package com.cydeo.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorStepDefinition {

    int actualResult;

    @Given("calculator app is open")
    public void calculator_app_is_open() {
        System.out.println("@Given _ calculator_ is_open");
    }
    @When("I add {int} with {int}")
    public void i_add_with(Integer num1, Integer num2) {
        System.out.println("@When I add " +num1 + " with "  + num2);
        actualResult = num1+num2;
    }
    @Then("I should get result {int} displayed")
    public void i_should_get_result_displayed(int expectedResult) {
        System.out.println("@Then _I should get result: " + expectedResult);

        assertEquals(expectedResult,actualResult);

    }

}
