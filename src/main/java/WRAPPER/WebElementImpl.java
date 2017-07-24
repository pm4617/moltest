package WRAPPER;


import MYUTILS.Log;
import java.util.List;
import WRAPPER.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;

import java.lang.annotation.*;
import POLIB.*;
import static POLIB.TestBaseSetup.driver;
import com.thoughtworks.selenium.Wait;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementImpl implements Element   {
 
	public  final WebElement element;
        WebDriverWait wait = new WebDriverWait(driver,30);
 	
	public WebElementImpl( final WebElement element){
		this.element = element;
	}

    public WebElementImpl(By Lsearchtextbox) {
       element = findElement(Lsearchtextbox);
    }

   

    
  
 /* (non-Javadoc)
	 * @see org.openqa.selenium.internal.Locatable#getCoordinates()
	 */
	public Coordinates getCoordinates() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.internal.WrapsElement#getWrappedElement()
	 */
	public WebElement getWrappedElement() {
		// TODO Auto-generated method stub
		return null;
	}

 public void click() {
		// TODO Auto-generated method stub
		if (element.isDisplayed() &&  element.isEnabled())  
		{
		element.click();
		Log.info(element.toString() + " is Clicked from the WebElementImpl");
               //        flash(element);
		}
		
	}

	public void submit() {
		// TODO Auto-generated method stub

	}

	public void sendKeys(CharSequence... keysToSend) {
		// TODO Auto-generated method stub
              //  flash(element);
                Log.info("Inside");
		if(element.isEnabled() && element.isDisplayed() ) {
		element.sendKeys(keysToSend);
		Log.info("sendKeys performed on " +  element.toString() + " , sent '" + keysToSend.toString()+ "'");
		} else {
                Log.info("Element "  +  element.toString() + " is either not displayed or diabled.Can not perform send Keys");
                } 
	 
	}

	public void clear() {
		// TODO Auto-generated method stub

	}

	public String getTagName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAttribute(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isSelected() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<WebElement> findElements(By by) {
		// TODO Auto-generated method stub
		return null;
	}

   /* public WebElement findElement(By by) {
        // TODO Auto-generated method stub

        //  Log.info("inside find element");
        return null;

    }
     */   
        

	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	public Point getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	public Dimension getSize() {
		// TODO Auto-generated method stub
		return null;
	}

	public Rectangle getRect() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCssValue(String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}

	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean elementWired() {
		// TODO Auto-generated method stub
		return false;
	}


	public void DoubleClick() {
		// TODO Auto-generated method stub
		
	}

   
    public WebElement findElement(By by) {
     //   JavascriptExecutor jse = (JavascriptExecutor) driver;
     //   jse.executeScript("arguments[0].style.border='3px solid red'", driver.findElement(by));
       
       wait.until(ExpectedConditions.presenceOfElementLocated(by));
       return driver.findElement(by) ;
    }
 
    public static void flash(WebElement element ) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String bgcolor  = element.getCssValue("backgroundColor");
        for (int i = 0; i <  3; i++) {
            changeColor("rgb(0,200,0)", element, js);
            changeColor(bgcolor, element, js);
        }
    }
    public static void changeColor(String color, WebElement element,  JavascriptExecutor js) {
        js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",  element);

        try {
            Thread.sleep(20);
        }  catch (InterruptedException e) {
        }
     }

}
