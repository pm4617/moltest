package moltest;

import POLIB.*;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class test2 extends TestBaseSetup {
 
@Test
 public void ftest2() throws InterruptedException
{
       
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        
        Integer i[] = {10,15,5,1,99};
        WebElement we = driver.findElement(By.xpath(".//*[@id='gf-BIG']/table/tbody/tr/td[2]"));
        
        List<WebElement> we1 = new ArrayList<WebElement>(we.findElements(By.tagName("li")));
        ListIterator <WebElement> it = we1.listIterator();
         
    
       while(it.hasNext()) {
            
            WebElement e = it.next();
            System.out.println("Before " + e.getText());
        }
        
          //  Collections.reverse(we1);
        
        
          while(it.hasPrevious()) {
            WebElement e = it.previous();
            System.out.println("After " + e.getText());
        }
          
          
          
        /*
        System.out.println(we.getText());
        System.out.println(we1.size());
    
        List<Integer> li = new ArrayList<Integer> (Arrays.asList(i));
        li.add(100);
        
        
        
                
        Set<String> wh= driver.getWindowHandles();
        
        System.out.print("Number of Window Handle = "+wh.size() + " Handles = "  + wh  + "\n");
        Thread.sleep(5000);
        System.out.println(we.getText());
        
        ArrayList<WebElement> frames = (ArrayList<WebElement>) driver.findElements(By.xpath("//iframe"));
        
       
        System.out.println("\n Found " + frames.size() +  " number of frames");
        Iterator<WebElement> fit = frames.iterator();
        WebElement frame1;
        int j = 0;
        int sz1 = 0;
        for(j=frames.size()-1;j>=0;j--)
        {
             Thread.sleep(5000);
           System.out.println("In loop ... \n");
            
               int sz = 0;
           driver.switchTo().frame(j);
         Thread.sleep(5000);
         //check if iframe has another iframe
         
         
           sz = driver.findElements(By.xpath("//*[@id='gf-BIG']/table/tbody/tr/td[2]")).size();
           
           if(sz>0)          
            {
                System.out.println("Index found in frame "  + j);
                 break;
            }
         
        
           if(sz>0)          
            {
                System.out.println("Index found in frame "  + j);
                 break;
            }
           
      
              j--;
           System.out.println(j);
           driver.switchTo().defaultContent();
        }
    
   // WebElement col = driver.findElement(By.xpath("//div[@id='gf-BIG']/table/tr/td[2]"));
 
   // ArrayList<WebElement> colelements =    (ArrayList<WebElement>) col.findElements(By.tagName("a"));
   // Iterator<WebElement> it = colelements.iterator();
    //WebElement e;
 
    while(it.hasNext()) {
        e = it.next();
        System.out.println(e.getText());
        
    }*/
    
    
    
    
}

} 
