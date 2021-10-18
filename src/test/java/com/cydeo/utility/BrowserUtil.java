package com.cydeo.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtil {

    public static void waitFor(int seconds)  {

        int milliseconds = seconds*1000;

        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    //This method will check for visibility of the element within

    public static boolean checkVisibilityOfElement(By locator, int timeToWait){

        boolean result = false;

        WebDriverWait wait = new WebDriverWait(com.cydeo.utility.Driver.getDriver(), timeToWait);

        try{
            wait.until((ExpectedConditions.visibilityOfElementLocated(locator)));
            result = true ;
        }
        catch(TimeoutException e){
            System.out.println("We did not see the error message element");
        }

        return result;
    }

    /**
     * A utility method to get the texts out of list of web elements
     * @param lstOfWebElements the target list of weblement
     * @return the text inside those web element as List<String>
     */
    public static List<String> getAllText(List<WebElement> lstOfWebElements ){

        List<String> allTextLst = new ArrayList<>();
        for (WebElement eachElement : lstOfWebElements) {
            allTextLst.add(  eachElement.getText()  );
        }

        return  allTextLst ;

    }


}
