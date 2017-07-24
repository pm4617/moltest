package moltest;

import MYUTILS.PropertyReader;
import MYUTILS.Log;
import MYUTILS.*;
import MYUTILS.ClassParser.ClassParserException;
import MYUTILS.ClassParser.DataNotAvailableException;
import POLIB.*;
import static POLIB.LoginPage.searchtextbox;

import org.testng.annotations.Test;

import java.io.IOException;
import org.apache.log4j.xml.DOMConfigurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;


public class NewTest extends TestBaseSetup {

    
    public LoginPage loginpage;
    
    public HomePage homepage;
    public String URL;

    @Test (dataProvider="googleSearchData")
        public void f(GoogleSearchData data) {
  
       loginpage = new LoginPage(driver);
       homepage = new HomePage(driver);
        //LoginPage.txtuserid().click();
        //homepage=  loginpage.login();
       loginpage.searchtextbox().click();
       loginpage.signinbutton().click();
       System.out.println(data.email);
       homepage.email().sendKeys(data.email);
    
     
        //LoginPage.searchtextbox().sendKeys("Test");
        //LoginPage.login().txtclasscodesrch().sendKeys("test");
    }
    
 
    @DataProvider(name="mm")
    public Object[][] mm() throws ClassParserException, DataNotAvailableException {
            ExcelDataDrive excelData = new ExcelDataDrive("src/test/resources/datadrive/GoogleSearchData.xls");
		return excelData.getTestngData(GoogleSearchData.class);
    }
    
    
    @DataProvider(name="googleSearchData")
    public Object[][] googleSearchData() throws ClassParserException, DataNotAvailableException {
 		ExcelDataDrive excelData = new ExcelDataDrive("src/test/resources/datadrive/GoogleSearchData.xls");
		return excelData.getTestngData(GoogleSearchData.class);
	}

} 
