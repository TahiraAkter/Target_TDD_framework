package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigFile {
	
	private Properties properties;
	private final String defaultPath = "configuration/configure.properties"; //where

	public ReadConfigFile(String path) { 
		if (path == null || path.length() < 11) {
			loadProperty(defaultPath);
		} else {
			loadProperty(path); 
		}

	}

	private void loadProperty(String path) {
		properties = new Properties(); 
		try {
			InputStream iStream = new FileInputStream(path); 
			properties.load(iStream);
			iStream.close();
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public String getReadConfigFile(String key) { 
			return properties.getProperty(key);
		}

	}

