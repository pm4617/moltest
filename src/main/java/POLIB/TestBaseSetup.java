/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POLIB;

import MYUTILS.Log;
import MYUTILS.PropertyReader;
import java.io.IOException;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import POLIB.*;
import org.testng.annotations.BeforeMethod;
/**
 *
 * @author MY PC
 */
public class TestBaseSetup {

	public static WebDriver driver;
	static String driverPath = "D:\\chromedriver\\" ;
        public String URL = "no such page";
	public static WebDriver getDriver() {
		return driver;
	}

	private void setDriver(String browserType, String appURL) {
		switch (browserType) {
		case "chrome":
			driver = initChromeDriver(appURL);
			break;
		case "firefox":
			driver = initFirefoxDriver(appURL);
			break;
		default:
			System.out.println("browser : " + browserType
					+ " is invalid, Launching Firefox as browser of choice..");
			driver = initFirefoxDriver(appURL);
		}
	}

        
	private static WebDriver initChromeDriver(String appURL) {
		System.out.println("Launching google chrome with new profile..");
		System.setProperty("webdriver.chrome.driver", driverPath
				+ "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	private static WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox browser..");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

 
        
        
        
        
        
        @BeforeTest
    public void beforeTest() {
 
        DOMConfigurator.configure("log4j.xml");
              // Start printing the logs and printing the Test Case name
        Log.startTestCase(this.toString());
        try {
            PropertyReader pr = new PropertyReader("src/main/java/config/molconfig.properties");
               URL= pr.getProperty("ebay");

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Log.fatal("Exception" + e.toString() + " in class " +this.getClass().getName());
        }
        
           System.out.println("In before TEST method");

  
    }

    @BeforeMethod
    public void beforeMethod()
    {
  //          driver = new FirefoxDriver();
            setDriver("chrome", "http://www.ebay.com");
     //       driver.get(URL);
            System.out.println(" In Before Method ");
    }
    
    
    
    @AfterMethod
    public void afterMethod() {
        // Printing beautiful logs to end the test case
        Log.endTestCase(this.toString());
        System.out.println(" In AfterMethod ");
        driver.close();
        
        // Closing the opened driver
        //driver.close();
    }

}