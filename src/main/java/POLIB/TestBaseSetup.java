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
/**
 *
 * @author MY PC
 */
public class TestBaseSetup {

	public static WebDriver driver;
	static String driverPath = "D:\\chromedriver\\" ;

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
    String URL = "no such page";
        DOMConfigurator.configure("log4j.xml");
              // Start printing the logs and printing the Test Case name
        Log.startTestCase(this.toString());
        try {
            PropertyReader pr = new PropertyReader("src/main/java/config/molconfig.properties");
               URL= pr.getProperty("uwurl");

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Log.fatal("Exception" + e.toString() + " in class " +this.getClass().getName());
        }

        driver = new FirefoxDriver();
        driver.get(URL);
    }

    @AfterMethod
    public void afterMethod() {
        // Printing beautiful logs to end the test case
        Log.endTestCase(this.toString());
        // Closing the opened driver
        driver.close();
    }

}