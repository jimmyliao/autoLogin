package com.ibm.ftm;

//import org.joda.time.LocalTime;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
* http://code.google.com/p/selenium/wiki/GettingStarted
**/
public class HelloWebDriver {
    //private static Logger logger = Logger.getLogger("name");
    static Logger logger = Logger.getLogger(HelloWebDriver.class);
    
    public static void main(String[] args) {
        //DOMConfigurator is used to configure logger from xml configuration file
        DOMConfigurator.configure("./log4j-config.xml");
        logger.debug("Log4j appender configuration is successful !!");

        // The Firefox driver supports javascript 
        WebDriver driver = new FirefoxDriver();

        // And now use this to visit Google
        driver.get("https://9.191.66.147:9443/admin");
        logger.debug("Trying to open CPS admin login page !!");

        // Find the text input element by its name
        WebElement e_username = driver.findElement(By.name("j_username"));
        WebElement e_password = driver.findElement(By.name("j_password"));
        WebElement e_btnLogin = driver.findElement(By.name("login"));

        // Enter something to search for
        //element.sendKeys("Cheese!");
        e_username.sendKeys("izhadmin");
        e_password.sendKeys("wb1forfn");

        // Now submit the form. WebDriver will find the form for us from the element
        e_btnLogin.submit();
        logger.debug("User is trying to logging in...");

        // Sleep until the div we want is visible or 5 seconds is over
        long end = System.currentTimeMillis() + 5000;
        while (System.currentTimeMillis() < end) {
            //WebElement resultsDiv = driver.findElement(By.className("gssb_e"));
            WebElement resultsDiv = driver.findElement(By.id("ftm-banner-welcome"));

            // If results have been returned, the results are displayed in a drop down.
            if (resultsDiv.isDisplayed()) {
              logger.debug("User is logged in.");
              break;
            }
        }
        logger.debug("Test Completed.");

  }
}
