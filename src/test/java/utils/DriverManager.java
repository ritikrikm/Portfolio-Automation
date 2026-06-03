package utils;

import java.time.Duration;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {
	private static final Logger LOG  = LogManager.getLogger(DriverManager.class);
	private static final ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();
	private DriverManager(){}
	public static void init(String browser) {
		if(browser==null) browser = "chrome";
		browser = browser.toLowerCase();
		WebDriver driver = chooseBrowser(browser);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driverThread.set(driver);
	}
	public static WebDriver get() {
		WebDriver driver = driverThread.get();
		if(driver==null) {
			throw new IllegalStateException("while closing the browser, we found that WebDriver is not initialised yet");
		}
		return driver;
	}
	public static void quitDriver() {
		WebDriver driver = driverThread.get();
		if(driver!=null) {
			try {
				driver.quit();
			}catch(Exception e) {
			LOG.info("Found an exception having message while quitting driver:",e.getMessage());
			}finally {
				driverThread.remove();
			}
		}
	
	}
	private static WebDriver chooseBrowser(String browser) {
		switch(browser) {
		case "chrome": ChromeOptions options = new ChromeOptions(); 
					   options.addArguments( "--headless=new",
	                        "--no-sandbox",
	                        "--disable-dev-shm-usage",
	                        "--disable-gpu",
	                        "--window-size=1920,1080"); 
					   return new ChromeDriver(options);
		case "safari" : return new SafariDriver();
		default: return new ChromeDriver();
		}
	}
}
