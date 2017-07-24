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
	public static WebElementImpl classcodesrch,signinbutton,email;

	static By Lclasscodesrch , Lsigninbutton,Lemail;
                //= By.cssSelector("#lst-ib");
	
	public static WebDriver driver;
        private PropertyReader HomeProp;
	
	public HomePage(WebDriver driver) {
		super(driver);
                this.driver = driver;

		initialize();
	}
	
	public static WebElementImpl txtclasscodesrch() {
		 classcodesrch = new WebElementImpl(driver.findElement(Lclasscodesrch));
                //classcodesrch = new WebElementImpl(Lclasscodesrch);
                Log.info("Looked up txtclasscodesrch by locator " + Lclasscodesrch);
		return classcodesrch;
	}
        
        
      
        
             public static WebElementImpl email() {
		 email = new WebElementImpl(Lemail);
                //classcodesrch = new WebElementImpl(Lclasscodesrch);
                Log.info("Looked up Lemail by locator " + Lemail);
		return email;
	}


    private void initialize() {
                        try {
            this.HomeProp = new PropertyReader("src/main/java/config/HomePage.properties");
   
         //   Lsearchtextbox = LoginProp.getProperty("Lsearchtextbox");
         Lsearchtextbox = HomeProp.getByReference("Lclasscodesrch");   
         Lsigninbutton = HomeProp.getByReference("Lsigninbutton");
         Lemail = HomeProp.getByReference("Lemail");
                        }
                        
         catch (IOException ex) {
            Log.fatal("EXCEPTION : In " + LoginPage.class.getName() + ". Got " + ex.toString());
            ex.printStackTrace();
        }
    }


}