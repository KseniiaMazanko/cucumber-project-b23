package com.cydeo.pages;

import com.cydeo.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WCommonArea {


    @FindBy(id="ctl00_logout")
    public WebElement logoutLink;

    @FindBy(linkText = "View all orders")
    public WebElement viewAllOrdersLink;

    @FindBy(linkText = "View all products" )
    public WebElement viewAllProductsLink;

    @FindBy(linkText = "Order")
    public WebElement orderLink;

    @FindBy(xpath = "//*[@id=\"aspnetForm\"]/table/tbody/tr/td[2]/div[2]/h2")
    public WebElement headerOrder;

    public WCommonArea(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


}
