/**
 * 
 */
package WRAPPER;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.internal.WrapsElement;

/**
 * @author pmahajan
 *
 */
public interface Element extends WebElement,WrapsElement, Locatable  {
//boolean elementWired();
	void DoubleClick();
        
}
