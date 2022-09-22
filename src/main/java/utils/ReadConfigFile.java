package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigFile {
	
	private static ReadConfigFile readConfigFile; //for singleton
	private Properties properties;
	private final String defaultPath = "configuration/configure.properties"; //where

	/*public ReadConfigFile(String path) { 
		if (path == null || path.length() < 11) {
			loadProperty(defaultPath);
		} else {
			loadProperty(path); 
		}

	}*/
	
	private ReadConfigFile() { //for singleton
		loadProperty();
	}
	private void loadProperty() { //for singleton
		properties = new Properties(); 
		try {
			InputStream iStream = new FileInputStream(defaultPath); 
			properties.load(iStream);
			iStream.close();
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	/*private void loadProperty(String path) {
		properties = new Properties(); 
		try {
			InputStream iStream = new FileInputStream(path); 
			properties.load(iStream);
			iStream.close();
		} catch (IOException e) {
			e.printStackTrace();

		}
	}*/

	/*public String getReadConfigFile(String key) { 
			return properties.getProperty(key);
		}*/
	
	public static ReadConfigFile getInstance() { //for singleton --- >getter method to access the 'readConfigFile' object in another class
		if (readConfigFile==null) {                      // because the constructor of that Class is private. 
			readConfigFile=new ReadConfigFile();
		}
		return readConfigFile; 
	}
	public String get(String key) {
		if (key !=null) {
			return properties.getProperty(key);
		}else {
			return null;
		}
		
	}

	}

