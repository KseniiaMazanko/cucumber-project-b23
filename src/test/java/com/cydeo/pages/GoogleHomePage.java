package com.cydeo.pages;

import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.ConfigReader;
import com.cydeo.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage {

    /*
    - Google homepage
 Fields :
 - searchbox element
 - search button
 Methods
  - searchKeyWord
    - accept 1 string param as keyword
    - return nothing
    - should enter keyword and click search button
  - isAt
    - accept no param
    - return true if title match , false if not
  - goTo
     - void method with no param and navigate to google (use config reader for url)

- Google SearchResultPage
  - Fields
     searchResultCount
     resultLinks (list of webelement )
  - Methods
     getResultCountText
     getAllResultLinkText
     */

    @FindBy(name = "q")
    public WebElement searchBox;

    @FindBy(name = "btnK")
    public WebElement searchBtn;

    public GoogleHomePage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    public void goTo(){
        Driver.getDriver().navigate().to(ConfigReader.read("google.url"));
    }


    public void searchKeyWord(String param){
        this.searchBox.sendKeys(param);
        this.searchBtn.submit();
    }

    public boolean isAT(){

        if(Driver.getDriver().getTitle().equals("Google")){
            return true;
        }
        return false;

    }







}
