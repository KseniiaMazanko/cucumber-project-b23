package com.cydeo.pages;

import com.cydeo.utility.ConfigReader;
import com.cydeo.utility.Driver;
import com.cydeo.utility.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WLoginPage extends TestBase {
    /*
    1. create a package called pages under com.cybertek
2. create a class under that package WLoginPage
   1. to represnt weborder login page
3. create instance variable with type of WebElement
   1. usernameField
   2. passwordField
   3. loginButton
4. Use @FindBy annotation to instruct selenium to look for element following way : these are all available options
   1. @FindBy(id= "someId")
   2. @FindBy(name= "someName")
   3. @FindBy(tagName= "someTag")
   4. @FindBy(className= "someClassName")
   5. @FindBy(linkText= "someLinkText")
   6. @FindBy(partiallinkText= "someLinkText")
   7. @FindBy(css= "someCSS")
   8. @FindBy(xpath= "someXpath")

5. Add a no arg constructor to use PageFactory method to instruct selenium to look for all elements
located by those locator provided

        public WLoginPage(){
      // initElements accept 2 arguments ,
        // WebDriver instance and Page class instance (this) means current instance of this class.
        PageFactory.initElements(Driver.getDriver(), this);
   }
     */



    @FindBy(id = "ctl00_MainContent_username")
    public WebElement userNameField;

    @FindBy(name = "ctl00$MainContent$password")
    public WebElement passwordField;

    @FindBy(css="#ctl00_MainContent_login_button")
    public WebElement loginButton;

    @FindBy(xpath = "//span[.='Invalid Login or Password.']")
    public WebElement errorMsg;

    // Now we need instruct selenium to start looking for element
    // when this constructor is called
    // This is no arg constructor of this class
    public WLoginPage(){
        // PageFactory is a selenium class that support Page Object Model
        // and it has method called initElements
        // once it's called , it will locate all the element
        // specified using @FindBy annotation with locator
        // initElements accept 2 arguments ,
        // WebDriver instance and Page class instance (this) means current instance of this class.

        PageFactory.initElements(Driver.getDriver() , this );

    }

    //create a method called goTo no parameters just to navigate to login page

    public void goTo(){

        Driver.getDriver().get(ConfigReader.read("weborder_url"));
    }

    /**
     * Login with parameters
     * @param username username
     * @param password password
     */
    public void login(String username, String password ){

        // you can access directly using userNameField or this.userNameField
        this.userNameField.sendKeys(username);
        this.passwordField.sendKeys(password);
        this.loginButton.click();

    }

    /**
     * Check error message is present if wrong credentials provided
     * loginErrorMsgPresent  simple return the result of isDisplayed method call
     */

    public boolean loginErrorMsgPresent(){

        return this.errorMsg.isDisplayed();

    }









}
