package moltest;

import MYUTILS.PropertyReader;
import MYUTILS.Log;
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
import org.testng.annotations.AfterMethod;

public class NewTest extends TestBaseSetup {

    
    public LoginPage loginpage;
    public String URL;

    @Test
    public void f() {
        loginpage = new LoginPage(driver);
        //LoginPage.txtuserid().click();
        //LoginPage.txtuserid().sendKeys("Markelonline.com");
        LoginPage.searchtextbox().sendKeys("Test");
        //LoginPage.login().txtclasscodesrch().sendKeys("test");
    }

}
