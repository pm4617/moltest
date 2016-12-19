package POLIB;

import MYUTILS.Log;
import MYUTILS.PropertyReader;
import WRAPPER.WebElementImpl;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    // @FindBy(how=How.CSS, using="#lst-ib")
    public static WebElementImpl searchtextbox;
    public static WebElement searchtextbox1;

    public static WebDriver driver;

    static By Lsearchtextbox;
    //static By Lsearchtextbox = By.cssSelector("#lst-ib");
    // static By Luserid = By.id("username");
    // static By Lpassword = By.id("password");
    // static By Lloginbutton = By.id("submit");

    PropertyReader LoginProp;

    public LoginPage(WebDriver driver) {
        super(driver);

        this.driver = driver;
        // searchtextbox1= driver.findElement(Lsearchtextbox);
        // searchtextbox1.click();
        // searchtextbox.click();
      
        
    }

    public static HomePage login() {
        //txtuserid().sendKeys("Markelonlin.com");
        Log.info("Inside login method , Navigating to Home page after login" );
        return new HomePage(driver);
    }

    public static WebElementImpl searchtextbox() {
        //searchtextbox = new WebElementImpl(driver.findElement(Lsearchtextbox));
        
        searchtextbox = new WebElementImpl(Lsearchtextbox);
        Log.info("Looked up searchtextbox by locator " + Lsearchtextbox);
        return searchtextbox;
    }

    private void initialize() {
  try {
            this.LoginProp = new PropertyReader("src/main/java/config/LoginPage.properties");
            Lsearchtextbox = LoginProp.getByReference("Lsearchtextbox");
         //   Lsearchtextbox = LoginProp.getProperty("Lsearchtextbox");
      
        } catch (IOException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }

}
}
