package com.cydeo.step_definitions;

import com.cydeo.pages.WLoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class DataTableStepDef {

    @Given("I have a {string}")//take more than 1 word (whatever was in quotes
    //@Given("I have a {word}")//does not need quotes in the feature file
    public void i_have_a(String animal) {

        System.out.println("Given I have a " + animal);

    }
    @When("I call their names")
    public void i_call_their_names() {
        System.out.println(" When I call their names ");
    }
    @Then("They come to me.")
    public void they_come_to_me() {
        System.out.println(" Then they come to me ");
    }


    @Given("I have following animals")
    public void i_have_following_animals(List<String> animalList) {

        System.out.println(animalList);

    }


    @When("I call their names with below names")
    public void iCallTheirNamesWithBelowNames(List<String> namesList) {

        System.out.println(namesList);

    }

    @Then("They come to me wit below noises")
    public void they_come_to_me_wit_below_noises(Map<String, String> animalNoiseMap) {

        System.out.println(animalNoiseMap);
    }
    //it could also be represented by List<List<String>>
    /*@Then("They come to me wit below noises")
    public void they_come_to_me_wit_below_noises(List<List<String>> animalRowList){
        System.out.println(animalRowList);
    }
     */

    @When("we provide below credentials")
    public void weProvideBelowCredentials(Map<String, String> credentials) {

        String usernameFromTbl = credentials.get("username");
        String passwordFromTbl = credentials.get("password");
        WLoginPage loginPageObj = new WLoginPage();
        loginPageObj.login(usernameFromTbl,passwordFromTbl);


    }


    @Given("this is the product reference")
    public void thisIsTheProductReference(List<Map<String, Object>> productMapList) {

        System.out.println("productMapList = " + productMapList);

        /*for (Map<String, Object> eachRowMap : productMapList) {
            System.out.println("eachMap = " + eachRowMap);
        }
         */

        /*
      | Product     | Price | Discount |
      | MyMoney     | 100   | 0.08     |
      | FamilyAlbum | 80    | 0.15     |
      | ScreenSaver | 20    | 0.1      |
         */
        Map<String, Object> thirdRowMap = productMapList.get(2);
        // the key is column name , the value is cell value
        System.out.println("thirdRowMap = " + thirdRowMap);
        // print Discount column of 3rd row
        System.out.println("thirdRowMap.get(\"Discount\") = "
                + thirdRowMap.get("Discount"));

        //get the Price value of 2nd row

        productMapList.get(1).get("Price");


    }

    /*
      | MyMoney     | 100   | 0.08     |
      | FamilyAlbum | 80    | 0.15     |
      | ScreenSaver | 20    | 0.1      |
     */

//we don't have to change the method name
    @And("I have another product reference without header")
    public void iHaveAnotherProduct(List<List<String>> productInfoList) {

        System.out.println("productInfoList = " + productInfoList);

        //get the third row
        List<String> thirdRow = productInfoList.get(2);


        //get the price value of the third row
        System.out.println("thirdRow.get(1) = " + thirdRow.get(1));


        //get the discount column of the first row
        System.out.println("productInfoList.get(0).get(2) = " + productInfoList.get(0).get(2));


    }
}
