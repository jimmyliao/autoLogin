package net.jimmyliao.selenium;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author jimmy
 */
public class HelloWebDriver {
    static Logger logger = Logger.getLogger(HelloWebDriver.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        HelloWebDriver testObj = new HelloWebDriver();
        testObj.test01();
	}
    
    @Test
    public void test01() {
        DOMConfigurator.configure("./log4j-config.xml");
        logger.debug("Log4j appender configuration is successful !!");

        // The Firefox driver supports javascript 
        WebDriver driver = new FirefoxDriver();

        // And now use this to visit Google
        driver.get("https://tw.stock.yahoo.com/");
        logger.debug("Trying to open Yahoo! Stock page !!");

        // Find the text input element by its name
//        WebElement e_username = driver.findElement(By.name("j_username"));
//        WebElement e_password = driver.findElement(By.name("j_password"));
//        WebElement e_btnLogin = driver.findElement(By.name("login"));
        WebElement element_searchStock = driver.findElement(By.id("stock_id"));
        WebElement element_searchSubmit = driver.findElement(By.cssSelector("input[type='submit']"));

        // Enter something to search for
        //element.sendKeys("Cheese!");
//        e_username.sendKeys("izhadmin");
//        e_password.sendKeys("wb1forfn");
        element_searchStock.clear();
        element_searchStock.sendKeys("2454"); // MediaTek
        element_searchSubmit.click();;

        // Now submit the form. WebDriver will find the form for us from the element
//        e_btnLogin.submit();
//        logger.debug("User is trying to logging in...");

        // Sleep until the div we want is visible or 5 seconds is over

        long end = System.currentTimeMillis() + 5000;
        while (System.currentTimeMillis() < end) {
            //WebElement resultsDiv = driver.findElement(By.className("gssb_e"));
            //WebElement resultsDiv = driver.findElement(By.id("ftm-banner-welcome"));
        	WebElement resultsDiv = driver.findElement(By.partialLinkText("2454"));

            // If results have been returned, the results are displayed in a drop down.
            if (resultsDiv.isDisplayed()) {
              logger.debug("Stock found!");
              break;
            }
        }

        logger.debug("Test Completed.");

        driver.quit();    	
    }

}
