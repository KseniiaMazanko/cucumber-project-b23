package com.cydeo.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;


public class WebOrderUtility {

    public static void login(String username, String password){

        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(username);

        Driver.getDriver().findElement(By.id("ctl00_MainContent_password")).sendKeys(password);

        Driver.getDriver().findElement(By.id("ctl00_MainContent_login_button")).click();

        BrowserUtil.waitFor(4);


    }

    public static void logout(){


        Driver.getDriver().findElement(By.id("ctl00_logout")).click();


    }

   public static boolean isAtOrderPage(){
        boolean result = false ;

        // locator for the header element of all order page
        //h2[normalize-space(.)='List of All Orders']
        try{
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(),2);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space(.)='List of All Orders']"))) ;
            System.out.println("ELEMENT WAS IDENTIFIED ");
            result = true ;
        }catch (TimeoutException e){
            System.out.println("NO Such element! you are not at the right page");
        }
        return result ;
    }


    public static boolean isAtListOfProductsPage() {
        boolean result = false;

        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 2);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space(text()='List of All Products')]")));
            System.out.println("The page was verified");
            result=true;
        }
        catch(RuntimeException e){
            System.out.println("The page was not verified");

        }
        return result;

    }

    public static boolean isAtOrdersPage(){
        boolean result = false;

        try{
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 2);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space(text()='Order')]")));
            System.out.println("You are on Order page");
            result= true;
        }
        catch (RuntimeException e){
            System.out.println("Not verified");
        }
        return result;
    }

    /*
    Create a method called `openWebOrderApp()`
	- no param , no return type
	- simply navigate to WebOrder login page
	- use `Driver` class we created , no param!
     */

    public static void openWebOrderApp(){


        //Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");
        //System.out.println("WebOrder app was opened successfully");
        Driver.getDriver().get(com.cydeo.utility.ConfigReader.read("weborder_url"));

    }

    /*
    Create a method `verifyUserName`
   1. accept `String username` as parameter
   2. The method check the welcome message right beside `logout` link contains username or not. for example `Welcome , Tester` contains `Tester`
   3. return `true` if it match username passed, false if not.

     */
    public static boolean verifyUserName(String username){


            WebElement usernameDisplayed = Driver.getDriver().findElement(By.xpath("//div[@class='login_info']"));

            return usernameDisplayed.getText().contains(username);

    }

/*
Create a method `selectSideBarTab`
   1. accept `String tabName` no return type.
   2. click on the tab according to the tabName provided, for example :
   if "View all products" passed to the method , it should click on second tab.
 */
    public static void selectSideBarTab(String tabName){

        //View all orders : Default.aspx
        //View all products : Products.aspx
        //Order: Process.aspx

            List<String> allTabs = Arrays.asList("View all orders","View all products","Order");
            if(allTabs.contains(tabName)){
                Driver.getDriver().findElement(By.linkText(tabName)).click();
            }
            else{
                Driver.getDriver().findElement(By.linkText("View all orders")).click();
            }

            //2nd option
/*
            if(tabName.equals("View all orders")){
                Driver.getDriver().findElement(By.linkText("View all orders")).click();
            }
            else if(tabName.equals("View all products")){
                Driver.getDriver().findElement(By.linkText("View all products")).click();
            }
            else if(tabName.equals("Order")) {
                Driver.getDriver().findElement(By.linkText("Order")).click();
            }
            else{
                System.out.println("No such element found");
            }
 */
    }

    /**
     * Check for login error message is visible or not , by calling the BrowserUtil method we created
     * @return true if error message displayed , false if not
     */
    public static boolean loginErrorMsgVisible(){

        boolean elementFound = BrowserUtil.checkVisibilityOfElement(By.xpath("//span[. ='Invalid Login or Password.']"), 2);
        assertTrue(elementFound);
        return elementFound;
    }
/*
Create a method `checkAll`
   1. accept no param , return `boolean`
   2. click on `Check All` button
   3. return `true` if all checkboxes are checked , false if any left unchecked
   */

    public static boolean checkAll(){
        boolean result = false;

        Driver.getDriver().findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        BrowserUtil.waitFor(2);
        List<WebElement>checkBoxes = Driver.getDriver().findElements(By.id("ctl00_MainContent_orderGrid_ctl03_OrderSelector"));
        for (WebElement each : checkBoxes) {
            if(each.isSelected()){
                result=true;
            }
        }

        return result;
    }

      /*
9. Create a method `uncheckAll`
   1. accept no param , return `boolean`
   2. click on `Uncheck All` button
   3. return `true` if all checkboxes are unchecked , false if any left checked
   */

    public static boolean uncheckAll(){
        boolean result = false;

        Driver.getDriver().findElement(By.id("ctl00_MainContent_btnUncheckAll")).click();
        BrowserUtil.waitFor(2);
        List<WebElement>checkBoxes = Driver.getDriver().findElements(By.id("ctl00_MainContent_orderGrid_ctl03_OrderSelector"));
        for (WebElement each : checkBoxes) {
            if(!each.isSelected()){
                result=true;
            }
        }

        return result;
    }
        /*

10. Create a method `getAllProducts`
    1.  accept no param ,
    2.  return `List`
    3.  click on `View All Products` tab
    4.  save each cell value in first column `Product name` in the table into `List`
    */

    public static List<String> getAllProducts(){

        WebOrderUtility.selectSideBarTab("View all products");
        List <String> allProductsNames = new ArrayList<>();
        List<WebElement> allFirstRowCell = Driver.getDriver().findElements(By.xpath("//table[@class='ProductsTable']/tbody//tr/td[1]"));
        System.out.println(allFirstRowCell.size());
        for (WebElement each : allFirstRowCell) {
           allProductsNames.add(each.getText());
        }

        return allProductsNames;



    }









    /*

11. Create a method `getUnitPriceFromForm`
    1.  accept `String productName`
    2.  return `int` for unit price
    3.  It should
        1.  select product from product dropdown list
        2.  click `calculate` button
        3.  get the value attribute of `Price per unit:` input box
        4.  return it from the method.

12. Create a method `getDiscountFromForm`
    1.  accept `String productName` , `int quantity`
    2.  return `int` for discount
    3.  It should
        1.  select `productName` from product dropdown list
        2.  Enter `quantity` into `Quantity:*` inputbox (Fact : discount apply only if quantity is 10+)
        3. click `calculate` button
        4. get text attribute of `discount` inputbox and return from the method.

 13. Create a method `calculateTotal`
    1.  accept `String productName` , `int quantity`
    2. return `int` for total
    3. It should
       1.  select `productName` from product dropdown list
       2.  Enter `quantity` into `Quantity:*` inputbox
       3.  Click `calculate` button
       4.  get text attribute of `Total` inputbox and return from the method.

13. Create a method `getExpectedDiscount`
    1.  accept `String productName` , `int quantity`
    2.  return `discount` amount according to `productName`,`quantity`
    3.  It should
        - if `quantity` is less than 10
          - return `0`
        - else according to all products table
          - return `correct discount number` : 8 , 15, 10
        - This is all java no selenium code.

14. Create a void method `enterAddressInfo`
    1.  accept no param (optionally you can parameterize it but we will use `javafaker` library to randomize it later)
    2.  It should fill up the `Address Information` section of order form

15.  Create a void method `enterPaymentInfo`
    1.  accept no param (optionally you can parameterize it but we will use `javafaker` library to randomize it later)
    2.  It should fill up the `Payment Information` section of order form

16. Create a void method `submitAndVerify`
    1. accept no param return boolean
    2. click on `process` button
    3. check if `New order has been successfully added.` message present
    4. return `true` if it is , false if it is not.
    5. Use explicit wait to avoid long wait time if not present.

 */






    }

