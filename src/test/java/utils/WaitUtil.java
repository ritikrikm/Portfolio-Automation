package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {
	
	private final WebDriver driver;
	private final int defaultTime ;
	
	public WaitUtil(WebDriver driver) {
		this.driver = driver;
		this.defaultTime = Integer.parseInt(ConfigReader.get("explicit.wait.time" , "15"));
	}
	public WebElement waitForVisibility(By locator) {
		return myWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public WebElement presenceOfElement(By locator) {
		return myWait().until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	public boolean invisibility(By locator) {
		return myWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public WebElement waitForClickability(By locator) {
		return myWait().until(ExpectedConditions.elementToBeClickable(locator));
	}

	private WebDriverWait myWait() {
		return new WebDriverWait(driver, Duration.ofSeconds(defaultTime));
	}
	
}
