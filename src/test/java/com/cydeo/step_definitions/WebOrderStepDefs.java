package com.cydeo.step_definitions;

import com.cydeo.pages.WAllOrderPage;
import com.cydeo.pages.WAllProductPage;
import com.cydeo.pages.WCommonArea;
import com.cydeo.pages.WOrderPage;
import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.imageio.stream.ImageInputStream;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebOrderStepDefs {



    @When("we select {string} tab from sidebar")
    public void weSelectTabFromSidebar(String tabName) {

        System.out.println("tabName = " + tabName);
        WCommonArea commonArea = new WCommonArea();
       switch (tabName){
           case "View all products":
               commonArea.viewAllProductsLink.click();
               break;
           case "View all orders":
               commonArea.viewAllOrdersLink.click();
               break;
           case "Order":
               commonArea.orderLink.click();
               break;
       }
    }

        /*
      | Product     | Price | Discount |
      | MyMoney     | $100  | 8%       |
      | FamilyAlbum | $80   | 15%      |
      | ScreenSaver | $20   | 10%      |
         */
    /*
    @Then("we should see table with below content")
    public void weShouldSeeTableWithBelowContent(List<Map<String, String>> expectedMapList) {

        System.out.println("expectedMapList = " + expectedMapList);
        Map<String, String> expectedFirstROwMap = expectedMapList.get(0);
        WAllProductPage allProductPage = new WAllProductPage();
        System.out.println("allProductPage.getRowMapFromWebTable() = "
                + allProductPage.getRowMapFromWebTable());
        Map<String, String> actualFirstROwMap = allProductPage.getRowMapFromWebTable();
        assertEquals(expectedFirstROwMap,actualFirstROwMap);

        /*
        //get expected headers

        Set<String> expectedHeaderSet = expectedMapList.get(0).keySet();
        System.out.println("headerSet = " + expectedHeaderSet);

        //get actual header

        List<String> actualHeaders = allProductPage.getAllHeaderText();
        System.out.println("actualHeaders = " + actualHeaders);

        assertEquals(expectedHeaderSet.size(), actualHeaders.size());

        //we need to turn the set into list
        List<String> expectedHeaders = new ArrayList<>(expectedHeaderSet);
        assertEquals(expectedHeaders,actualHeaders);

}
     */



    @Then("we should see below options Product dropdown list")
    public void weShouldSeeBelowOptionsProductDropdownList(List<String> expectedOptions)  {


            System.out.println("Expected options = " + expectedOptions);
            WOrderPage orderPage = new WOrderPage();

            List<String> actualOptions = orderPage.getAllProductOptionFromList();

            //assert these 2 list are equal

            assertEquals(expectedOptions,actualOptions);}


    @Then("we should see table with below content")
    public void weShouldSeeTableWithBelowContent(List<List<String>> expectedTableContent) {

        WAllProductPage allProductPage = new WAllProductPage();

        List<String> actualHeader = new ArrayList<>();//List of actual headers

       for (WebElement eachHeader : allProductPage.allHeaderRowCells) {
            actualHeader.add(eachHeader.getText());
        }

        System.out.println("actualTableContent = " + actualHeader);

       List<String> actualFirstRowCell = new ArrayList<>();
       for (WebElement each : allProductPage.firstRowCells) {
            actualFirstRowCell.add(each.getText());
        }

        List <String> actualSecondRowCell = new ArrayList<>();
        for (WebElement each : allProductPage.secondRowCells) {
            actualSecondRowCell.add(each.getText());
        }

        List<String> actualThirdRowCell = new ArrayList<>();
        for (WebElement each : allProductPage.thirdRowCells) {
            actualThirdRowCell.add(each.getText());
        }

        List<List<String>> actualTableContent = new ArrayList<>();
        actualTableContent.addAll(Arrays.asList(actualHeader, actualFirstRowCell, actualSecondRowCell, actualThirdRowCell));

        System.out.println("expectedTableContent = " + expectedTableContent);
        System.out.println("actualTableContent = " + actualTableContent);

        assertEquals(expectedTableContent,actualTableContent);


    }

    @Then("we should see three section as below")
    public void weShouldSeeThreeSectionAsBelow(List<String> expectedContent) {

        List<String> actualContent = new ArrayList<>();
        for (WebElement each : Driver.getDriver().findElements(By.xpath("//tbody/tr/td/h3"))) {
            actualContent.add(each.getText());
        }

        Assert.assertEquals(expectedContent,actualContent);


    }

    /*
     | ScreenSaver | 20   |
     | MyMoney     | 100  |
     | FamilyAlbum | 80   |
     */
    @And("select each product from dropdown should change the unit price accordingly")
    public void selectEachProductFromDropdownShouldChangeTheUnitPriceAccordingly(Map<String, String> expectedContent) {

        /*SortedMap<String,String > treeMap = new TreeMap<>();
        treeMap.putAll(expectedContent);
        */

        //locating dropdown
        WebElement productDropdown = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));

        //locating the price
        WebElement price = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice"));

        //creating new Map
        SortedMap<String,String > actualContent = new TreeMap<>();

        Select dropObj = new Select(productDropdown);

        for(int i=2; i>=0; i--){
            //selecting object by index
            dropObj.selectByIndex(i);
            //making it a String
            String eachKey = dropObj.getFirstSelectedOption().getText();
            BrowserUtil.waitFor(2);
            //getting the price from price textbox
            String eachValue = price.getAttribute("value");
            //adding it to Map
            actualContent.put(eachKey,eachValue);
        }

        boolean result = false;

        if(expectedContent.get("MyMoney").equals(actualContent.get("MyMoney"))
        && expectedContent.get("ScreenSaver").equals(actualContent.get("ScreenSaver"))
        && expectedContent.get("FamilyAlbum").equals(actualContent.get("FamilyAlbum"))
        )
        {
            result= true;
        }

        assertTrue(result);





    }


}




