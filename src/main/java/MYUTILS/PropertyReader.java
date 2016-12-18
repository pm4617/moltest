package MYUTILS;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.testng.internal.PropertiesFile;

public class PropertyReader {

	public PropertiesFile prop ;
	public File file;
	
	public PropertyReader(String filename) throws IOException{
		
		prop = new PropertiesFile(filename);
	
	}
	
	public String getProperty(String propertyname)
	{
		System.out.println(prop.getProperties().getProperty(propertyname.toLowerCase()));
		return prop.getProperties().getProperty(propertyname);
	}
	
	
	
}
