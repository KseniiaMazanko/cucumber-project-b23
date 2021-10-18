package com.cydeo.utility;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    /*
    Create a Singleton class called Driver

1. create private no arg constructor

2. create private static field with name obj
     Data type of variable should be WebDriver

3. create public static method
     name : getDriver()
     return type :WebDriver
     param : none

     check if obj is null or not
         if yes - create ChromeDriver with all set up
        if no  -- return same obj
     */

    //we wanted to have a class that only returns Single object
    //no matter how many times you asked for the object
    //so we are creating this class with a technic we learned form Singleton pattern

    private static WebDriver obj;

    private Driver(){ }

    public static WebDriver getDriver(){

        String browserName = com.cydeo.utility.ConfigReader.read("browser");

        if(obj == null){

            //according to the browser type set up driver correctly

            switch (browserName) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    obj = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    obj = new FirefoxDriver();
                    break;

                default:
                    obj = null;
                    System.out.println("UNKNOWN BROWSER TYPE! " + browserName);

            }
            return obj;
        }
        else{
            //System.out.println("The object already exists");
            return obj;
        }

    }
    /**
     * Quitting the browser and setting the value of
     * WebDriver instance to null because you can re-use already quitted driver
     */
    public static void closeBrowser(){

        // check if we have WebDriver instance or not
        // basically checking if obj is null or not
        // if not null
        // quit the browser
        // make it null , because once quit it can not be used
        if(obj != null ){
            obj.quit();
            // so when ask for it again , it gives us not quited fresh driver
            obj = null ;
        }

    }

}
