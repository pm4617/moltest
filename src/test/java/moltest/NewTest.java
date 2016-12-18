package moltest;

import MYUTILS.PropertyReader;
import MYUTILS.Log;
import POLIB.*;


import org.testng.annotations.Test;

import java.io.IOException;
import org.apache.log4j.xml.DOMConfigurator;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
 
public class NewTest {

    public static FirefoxDriver driver;
    public LoginPage loginpage;
    public String URL;

    @Test
    public void f() {

        //LoginPage.txtuserid().click();
        //LoginPage.txtuserid().sendKeys("Markelonline.com");
        LoginPage.login().txtclasscodesrch().sendKeys("test");

    }
    
    
/**********************Before and AfterTest Methods******************************/
    @BeforeTest
    public void beforeTest() {
        try {
            PropertyReader pr = new PropertyReader("src/main/java/molconfig.properties");
            URL = pr.getProperty("uwurl");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        	DOMConfigurator.configure("log4j.xml");
	  	
	   	  	
	  	// Start printing the logs and printing the Test Case name
	  	Log.startTestCase(this.toString());
                
        driver = new FirefoxDriver();
        driver.get(URL);
        loginpage = new LoginPage(driver);
    }

      @AfterMethod
  public void afterMethod() {
	    // Printing beautiful logs to end the test case
	    Log.endTestCase(this.toString());
	    // Closing the opened driver
	    driver.close();
  		}
    
   /**********************Before and AfterTest Methods******************************/ 
    
}
