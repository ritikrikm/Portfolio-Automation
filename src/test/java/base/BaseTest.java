package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import listeners.TestListener;
import utils.DriverManager;
@Listeners(TestListener.class)
public abstract class BaseTest {
	protected WebDriver driver;
	
	
	@BeforeMethod(alwaysRun=true)
	@Parameters({"browser"})
	public void setup(String browser) {
		DriverManager.init(browser);
	}
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		DriverManager.quitDriver();
	}

	protected WebDriver getDriver() {
		return DriverManager.get();
	}
}
