package POLIB;

import org.openqa.selenium.WebDriver;

public class BasePage {
	
	public static WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
	driver = driver;		
	}
	
 
	public boolean clickme()
	{
		System.out.println("Clicked Me ");
		
		
		return true;
 
		
	}
	
	
	public boolean type()
	{
		// find element , check precondition type in it { 
		
		return true;
		
		// else return false ;
		
		
	}
}
