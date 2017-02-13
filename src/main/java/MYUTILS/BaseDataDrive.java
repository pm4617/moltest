/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MYUTILS;

import MYUTILS.ClassParser.ClassParserException;
import MYUTILS.ClassParser.DataNotAvailableException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MY PC
 */
public abstract class BaseDataDrive  {
    private ClassParser clsParser = new ClassParser();
    	protected abstract Map<String, List<String>> getData();
	
        
        public BaseDataDrive()
        {
        System.out.println("In Base Class");
        }
        
	/**
	 * Method to be used to parse the data file and to create data objects of the respective passed class.
	 * Mainly used to provide data drive variables for testng data drive methods.
	 * @param type Class type for which the object has to be created for each entry in the row of the data file.
         * @param <T> The type of data object to be returned
	 * @return {@link Object}[][] containing the objects of the Class - <b>type</b> passed as argument
	 * @throws ClassParserException in case of any issues while parsing the said class
	 * @throws DataNotAvailableException in case no column for the variable present in the class is present in the data file.
	 */
	public <type> Object[][] getTestngData(Class<?> type)   throws ClassParserException,DataNotAvailableException {
		Map<String, List<String>> dataMap = this.getData();
		return clsParser.getTestngData(type, dataMap);
	}
	
	/**
	 * Method to be used to parse the data file and to create data objects of the respective passed class.
	 * 
	 * @param type Class type for which the object has to be created for each entry in the row of the data file.
     * @param <T> The type of data object to be returned
	 * @return {@link List} containing the objects of the Class - <b>type</b> passed as argument
	 * @throws ClassParserException in case of any issues while parsing the said class
	 * @throws DataNotAvailableException in case no column for the variable present in the class is present in the data file.
	 * */
	public <T> List<T> getClassObjectList(Class<?> type) throws ClassParserException,DataNotAvailableException  {
		Map<String, List<String>> dataMap = this.getData();
		return clsParser.getClassObjectList(type, dataMap);
	}

    
}
