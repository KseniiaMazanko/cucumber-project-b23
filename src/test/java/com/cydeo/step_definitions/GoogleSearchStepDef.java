package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleHomePage;
import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class GoogleSearchStepDef {

    GoogleHomePage homePage;

    @Given("user is at home page")
    public void user_is_at_home_page() {
        homePage = new GoogleHomePage();
        homePage.goTo();
    }
    @When("user search for keyword {string}")
    public void user_search_for_keyword(String keyword) {
        homePage.searchKeyWord(keyword);
    }
    @Then("we should see result page")
    public void we_should_see_result_page() {
        System.out.println("I can check the title in the next step");
    }
    @Then("the title should start with {string}")
    public void the_title_should_start_with(String keyword) {


        BrowserUtil.waitFor(1);
        assertTrue(Driver.getDriver().getTitle().startsWith(keyword));

    }

}
