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

public class WebElementImpl implements Element   {
 
	public  final WebElement element;

 	
	public WebElementImpl( final WebElement element){
		this.element = element;
	}

    public WebElementImpl(By Lsearchtextbox) {
       // throw new UnsupportedOperationException("Not supported yet."); 
        this.element = findElement(Lsearchtextbox);
//To change body of generated methods, choose Tools | Templates.
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
		}
		
	}

	public void submit() {
		// TODO Auto-generated method stub

	}

	public void sendKeys(CharSequence... keysToSend) {
		// TODO Auto-generated method stub
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

	public WebElement findElement(By by) {
		// TODO Auto-generated method stub
                
                try {
		element.findElement(by);
		return findElement(by);
                } catch (Exception e) {
                Log.fatal("EXCEPTION in Looking Up Element : " + by.toString() + " in Class " +this.getClass().getSimpleName() + ". Got " +  e.toString());    
              findElementAgain(by);
                e.printStackTrace();
                               }
                Log.info("findElement performed on " +  element.toString() );
                return findElement(by);
		 
	}
        
        public WebElement findElementAgain (By by) {
             try {
                Thread.sleep(15000);
                Log.info("Trying to find element again after 15 seconds...");
                 
		element.findElement(by);
		return findElement(by);
                } catch (Exception e) {
                Log.fatal("EXCEPTION in Looking Up Element Again: " + by.toString() + " in Class " +this.getClass().getSimpleName() + ". Got " +  e.toString());    
                 e.printStackTrace();
                               }
                Log.info("When Tried again findElement performed on " +  element.toString() );
                return findElement(by);
            
        }

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

}
