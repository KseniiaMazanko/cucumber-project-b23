package com.cydeo.pages;

import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.Driver;
import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WAllOrderPage {

    @FindBy(xpath = "//h2[normalize-space(.)='List of All Orders']")
    public WebElement header;

    @FindBy(id = "ctl00_MainContent_btnCheckAll")
    public WebElement checkAllButton;

    @FindBy(id= "ctl00_MainContent_btnUncheckAll")
    public WebElement uncheckAllButton;

    @FindBy(xpath = "//table[@class='SampleTable']/tbody/tr[1]/th")
    public List<WebElement> headerCells;

    public WAllOrderPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public boolean isAtOrderPage(){

        return this.header.isDisplayed();

    }

    public void checkAll(){
        this.checkAllButton.click();
        BrowserUtil.waitFor(2);

    }
    public void uncheckAll(){
        this.uncheckAllButton.click();
        BrowserUtil.waitFor(2);
    }

    //create a method to loop through all headerCells and return true if the header are as below
    //[ 	Name	Product	#	Date	Street	City	State	Zip	Card	Card Number	Exp	 ]

    public boolean checkNamesOfTheCells(){

        boolean result = false;
        List<String> expected = new ArrayList<String>(Arrays.asList("Name","Product","#","Date","Street","City","State","Zip","Card",
                "Card Number","Exp"));


        for (int i = 0; i < headerCells.size(); i++) {
            for (int i1 = 0; i1 < expected.size(); i1++) {
                if(headerCells.get(0).getText().equals(" ") && headerCells.get(headerCells.size()-1).getText().equals(" ")){
                    if(headerCells.get(i).getText().equals(expected.get(i1))){
                        System.out.println("headerCells.get(i).getText() = " + headerCells.get(i).getText());
                        result=true;
                    }
                }
            }
        }


        return result;
    }
}


