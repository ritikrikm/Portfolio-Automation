package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	private static final Properties PROP = new Properties();
	
	static {
		 try (InputStream is = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
	            if (is == null) {
	                throw new RuntimeException("config.properties not found in classpath!");
	            }
	            PROP.load(is);
	        } catch (IOException e) {
	            throw new RuntimeException("Failed to load config.properties", e);
	        }
	}
public static String get(String key) {
	String value = System.getProperty(key , PROP.getProperty(key));
	if(value==null) {
		throw new RuntimeException("Required Config key :" + key + " is not defined");
	}
	return value;
	
}
public static String get(String key, String defaltValue) {
	String value = System.getProperty(key, PROP.getProperty(key));
	
	return value;
	
}
}
