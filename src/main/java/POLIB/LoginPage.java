package POLIB;

import WRAPPER.WebElementImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

	// @FindBy(how=How.CSS, using="#lst-ib")
	public static WebElementImpl searchtextbox;
	public static WebElement searchtextbox1;

	public static WebDriver driver;

	static By Lsearchtextbox = By.cssSelector("#lst-ib");
	// static By Luserid = By.id("username");
	// static By Lpassword = By.id("password");
	// static By Lloginbutton = By.id("submit");

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// searchtextbox1= driver.findElement(Lsearchtextbox);
		// searchtextbox1.click();
		// searchtextbox.click();

	}

	public static HomePage login() {
		//txtuserid().sendKeys("Markelonlin.com");
		return new HomePage(driver);
	}

	public static WebElementImpl txtuserid() {
		searchtextbox = new WebElementImpl(driver.findElement(Lsearchtextbox));
		return searchtextbox;
	}

}