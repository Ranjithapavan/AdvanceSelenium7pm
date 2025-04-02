package Generic_Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtility {
	
	public String redingDataFromPropFile(String key) throws IOException 
	{
	FileInputStream fis=new FileInputStream("C:\\Users\\user\\eclipse-workspace_Ranjitha\\AdvanceSelenium\\src\\test\\resources\\commondata.properties");
	Properties prop=new Properties();
	prop.load(fis);
	String data = prop.getProperty(key);
	return data;
	}

}
