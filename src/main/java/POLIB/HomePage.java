package POLIB;

import WRAPPER.WebElementImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
 

public class HomePage extends BasePage {
	public static WebElementImpl classcodesrch;

	static By Lclasscodesrch = By.cssSelector("#lst-ib");
	
	public static WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public static WebElementImpl txtclasscodesrch() {
		classcodesrch = new WebElementImpl(driver.findElement(Lclasscodesrch));
		return classcodesrch;
	}


}