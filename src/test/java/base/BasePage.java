package base;


import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import utils.WaitUtil;

public abstract class BasePage {
	private static final Logger LOG = LogManager.getLogger(BasePage.class);
	protected WebDriver driver;
	protected WaitUtil wait;
	protected BasePage(WebDriver driver){
		this.driver=driver;
		this.wait = new WaitUtil(driver);
		LOG.info("Page Object Initialised with driver :" + driver);
	}
	public void navigateTo(String URL) {
		driver.navigate().to(URL);
		LOG.info("Driver Navigating to :" + URL);
	}
	protected String getTitle() {
		return driver.getTitle();
	}
	protected String getURL() {
		return driver.getCurrentUrl();
	}
	protected void type(By locator , String input) {
		WebElement element = wait.waitForVisibility(locator);
		element.clear();
		element.sendKeys(input);
		
	}
	protected void click(By locator) {
		WebElement element = wait.waitForClickability(locator);
		element.click();
		
	}
	protected void selectByVisibleText(By locator, String value) {
		WebElement element = wait.waitForVisibility(locator);
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
	protected void sendFile(By locator, String filePath) {
		WebElement element = wait.waitForVisibility(locator);
		element.sendKeys(filePath);
	}
	protected void slider(By locator,  int pos) {
		Actions act = new Actions(driver);
		WebElement element = wait.waitForVisibility(locator);
		act.dragAndDropBy(element, pos, 0).perform();
	}
	protected String getText(By locator) {
		WebElement element = wait.waitForVisibility(locator);
		return element.getText();
		
	}
	protected int countCards(By locator) {
		
		List<WebElement> list = driver.findElements(locator);
		return list.size();
	}
	protected String getToastText(By locator) {
		return wait.presenceOfElement(locator).getText();
		
	}
	protected void actionClick(By locator) {
		WebElement element = wait.waitForVisibility(locator);
		Actions act = new Actions(driver);
		act.moveToElement(element).pause(Duration.ofSeconds(2)).click().perform();
	}
	protected String getCSSAttribute(By locator, String key) {
		WebElement element = wait.waitForVisibility(locator);
		
		return element.getCssValue(key);
	}
	protected String getAttribute(By locator, String key) {
		WebElement element = wait.waitForVisibility(locator);
		return element.getAttribute(key);
	}
	protected boolean elementInvisible(By locator) {
		return wait.invisibility(locator);
	}
}
