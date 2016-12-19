package POLIB;

import MYUTILS.Log;
import MYUTILS.PropertyReader;
import static POLIB.LoginPage.Lsearchtextbox;
import static POLIB.LoginPage.searchtextbox;
import WRAPPER.WebElementImpl;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
 

public class HomePage extends BasePage {
	public static WebElementImpl classcodesrch;

	static By Lclasscodesrch ;
                //= By.cssSelector("#lst-ib");
	
	public static WebDriver driver;
        private PropertyReader HomeProp;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
                try {
            this.HomeProp = new PropertyReader("src/main/java/config/HomePage.properties");
            Lsearchtextbox = HomeProp.getByReference("Lclasscodesrch");
         //   Lsearchtextbox = LoginProp.getProperty("Lsearchtextbox");
      
        } catch (IOException ex) {
            Log.fatal("EXCEPTION : In " + LoginPage.class.getName() + ". Got " + ex.toString());
            ex.printStackTrace();
        }
	}
	
	public static WebElementImpl txtclasscodesrch() {
		//classcodesrch = new WebElementImpl(driver.findElement(Lclasscodesrch));
                classcodesrch = new WebElementImpl(Lclasscodesrch);
                Log.info("Looked up txtclasscodesrch by locator " + Lclasscodesrch);
		return classcodesrch;
	}


}