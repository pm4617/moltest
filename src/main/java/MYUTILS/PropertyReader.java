package MYUTILS;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;

import org.testng.internal.PropertiesFile;

public class PropertyReader {

	public PropertiesFile prop ;
	public File file;
	public By by;
        String filename ;
	public PropertyReader(String filename) throws IOException{
	 
            this.filename = filename;
		prop = new PropertiesFile(filename);
		 
        }
	
	public String getProperty(String propertyname)
	{
		Log.info("Getting Property value of " + propertyname + " from file " + filename +" = "+ prop.getProperties().getProperty(propertyname));
		return prop.getProperties().getProperty(propertyname);
	}
	
	 public By getByReference(String Loc)
         {
             
             Loc = this.getProperty(Loc);
             String one = Loc.substring(Loc.indexOf(",")+1);
             String two = Loc.substring(0, Loc.indexOf(","));
                  
             switch (two.toLowerCase()) {
                           
                 case "css" :
                     return By.cssSelector(one);
                   
                     
                 case "id" :
                     return By.id(one);
                       
                     case "xpath" :
                     return By.xpath(one);
                     
                 default : 
                     break; 
    
             }
             
             return by;
         }
	
	
}
