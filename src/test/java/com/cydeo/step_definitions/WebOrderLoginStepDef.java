package com.cydeo.step_definitions;

import com.cydeo.pages.WCommonArea;
import com.cydeo.pages.WLoginPage;
import com.cydeo.utility.ConfigReader;
import com.cydeo.utility.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class WebOrderLoginStepDef {

    //putting this at class level so it can be accessible in all methods
    WLoginPage loginPage;


    @Given("we are at web order login page")
    public void we_are_at_web_order_login_page() {
            //navigate to login page
        loginPage = new WLoginPage();
        loginPage.goTo();
    }

    @When("we provide valid credentials")
    public void we_provide_valid_credentials() {
        loginPage.login("Tester", "test");
    }


    @Then("we should see all order page")
    public void we_should_see_all_order_page() {

        //assertEquals(4,4);
        //assertTrue(4>3);

     assertEquals("Web Orders", Driver.getDriver().getTitle());


    }


    @Then("side bar tabs should be as below")
    public void sideBarTabsShouldBeAsBelow(List<String> expectedOptions) {

        WCommonArea sideBar = new WCommonArea();

        List<String> sidebarEL = new ArrayList<>();
        sidebarEL.add(sideBar.viewAllOrdersLink.getText());
        sidebarEL.add(sideBar.viewAllProductsLink.getText());
        sidebarEL.add(sideBar.orderLink.getText());

        System.out.println("sidebarEL = " + sidebarEL);
        System.out.println("expectedOptions = " + expectedOptions);

        Assert.assertEquals(expectedOptions,sidebarEL);

    }



    @When("we provide invalid credentials")
    public void weProvideInvalidCredentials() {
        loginPage.login("Bla", "bla");
    }

    @Then("we should still be at login page")
    public void weShouldStillBeAtLoginPage() {

        assertEquals("Web Orders Login", Driver.getDriver().getTitle());

    }











    @And("login error message should be present")
    public void loginErrorMessageShouldBePresent() {


        assertTrue(loginPage.loginErrorMsgPresent());

    }

    @When("user provides {string} and {string}")
    public void userProvidesAnd(String username, String password) {

        loginPage.login(username, password);

    }



}
