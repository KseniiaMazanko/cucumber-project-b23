package com.cydeo.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EatStepDefinition {

    @Given("John is hungry")
    public void alice_is_hungry() {
        System.out.println("This is given @Given code - John_is_hungry ");
    }

    @When("He eats {int} cucumbers")
    public void she_eats_cucumbers(Integer quantity) {
        System.out.println("This is @When code - He_eats_cucumbers " + quantity);
    }

    @Then("He will be full")
    public void she_will_be_full() {
        System.out.println("This is @Then code - He_will_be_full ");
    }


    @Given("Ivan is hungry")
    public void ivan_is_hungry() {
        System.out.println("@Given Ivan is hungry");
    }


    @Then("he faints")
    public void he_faints() {
        System.out.println("@Then he faint code");
    }


    @Given("there are {int} cucumbers")
    public void there_are_cucumbers(Integer startingCount) {

        System.out.println("startingCount = " + startingCount);

    }
    @When("I eat {int} cucumbers")
    public void i_eat_cucumbers(Integer ateCount) {
        System.out.println("ateCount = " + ateCount);
    }
    @Then("I should have {int} cucumbers")
    public void i_should_have_cucumbers(Integer leftCount) {
        System.out.println("leftCount = " + leftCount);
    }

}
