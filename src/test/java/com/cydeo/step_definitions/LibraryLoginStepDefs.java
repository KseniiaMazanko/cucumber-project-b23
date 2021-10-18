package com.cydeo.step_definitions;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryLoginStepDefs {

    LibraryLoginPage loginPageObj = new LibraryLoginPage();

    @Given("user is at library login page")
    public void userIsAtLibraryLoginPage() {
        loginPageObj.goTo();
    }

    @When("user use username {string} and passcode {string}")
    public void userUseUsernameAndPasscode(String email, String password) {

        loginPageObj.login(email,password);

    }


    @Then("user should be at dashboard page")
    public void userShouldBeAtDashboardPage() {

        BrowserUtil.waitFor(1);

        //check the title is now Library after logging in

        assertEquals("Library", Driver.getDriver().getTitle());

    }


}
