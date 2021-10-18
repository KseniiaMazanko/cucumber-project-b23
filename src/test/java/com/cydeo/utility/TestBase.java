package com.cydeo.utility;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * This class is meant to be superclass
 * to provide driver setup and closing browser
 * for its subclasses
 */
public abstract class TestBase {

    protected WebDriver driver;

    @BeforeEach
    public void setupWebDriver(){
        /*WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
         */
        driver= com.cydeo.utility.Driver.getDriver(); //using Singleton pattern instead of this --> //WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterEach
    public void closeBrowser(){

       // driver.quit();
        //quit the browser plus make it null
        com.cydeo.utility.Driver.closeBrowser();

    }



}
