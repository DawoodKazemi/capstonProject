package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

//import io.cucumber.core.logging.Logger;

public class Base {
	
	public static Properties properties;
	public static WebDriver driver;
	public static Logger logger;
	private String configPath =".\\src\\trest\\resources\\input\\config.properties";
	private String log4jPath= ".\\src\\trest\\resources\\input\\log4j.properties";
	
	public Base() throws FileNotFoundException {
		try {
			BufferedReader reader = new BufferedReader (new FileReader(configPath));
			properties = new Properties();
			
				properties.load(reader);
				reader.close();
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		logger = Logger.getLogger(log4jPath);
		PropertyConfigurator.configure(log4jPath);	
	}

	public static String getUrl() {
		
		String url = properties.getProperty("url");
		return url;

}
}