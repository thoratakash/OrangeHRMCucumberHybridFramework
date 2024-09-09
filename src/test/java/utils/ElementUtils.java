package utils;

import java.time.Duration;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	public WebDriver driver;
	
	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getTitleOfPage() {
		driver.getTitle();
	}
	public WebElement waitForWebElement(WebElement element,long durationOfSeconds) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(durationOfSeconds));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public WebElement waitForVisibilityOfElement(WebElement element, long durationInSeconds) {
		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return webElement;
	}
	
	public void typeTextIntoField(WebElement element,String textToBeTyped, long durationOfSeconds) {
		WebElement webElement=waitForWebElement(element, durationOfSeconds);
		webElement.sendKeys(textToBeTyped);		
	}
	
	public void clickOnElement(WebElement element, long durationOfSeconds) {
		WebElement webElement=waitForVisibilityOfElement(element, durationOfSeconds);
		webElement.click();
	}

	public void isDisplayOfElement(WebElement element, long durationOfSeconds) {
		WebElement webElement=waitForWebElement(element, durationOfSeconds);
		webElement.isDisplayed();		
	}
	
	public String getTextFromElement(WebElement element, long durationOfSeconds) {
		WebElement webElement = waitForWebElement(element, durationOfSeconds);
		return webElement.getText();
	}
	
	public void javaScriptClick(WebElement element, long durationInSeconds) {

		WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].click();", webElement);
		webElement.clear();
	}
	
	public void selectRadioButtonOfElement(WebElement element, long durationInSeconds) {
		WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
		if(!webElement.isSelected()) {
			webElement.click();
		}
		else {
			webElement.click();
		}
	}
	
	public static String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public void selectOptionFromDropDown(List<WebElement> ListOfelement,String drpdwnElement, long durationInSeconds) {
		
		for (WebElement option : ListOfelement) {
			
			String opt=option.getText();
			System.out.println("Akash : "+opt);
			
			if(opt.equals(drpdwnElement)) {
				option.click();
				break;
			}	
		}
	}
	
	public void clearTextFieldUsingActionsClass(WebElement element, long durationInSeconds) {

		element.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        element.sendKeys(Keys.BACK_SPACE);
        
//   	    javaScriptClick(element, durationInSeconds);	
//		Actions actions=new Actions(driver);
//		actions.click(element)
//		.keyDown(Keys.CONTROL)
//		.sendKeys("a")
//    	.keyUp(Keys.CONTROL)
//		.sendKeys(Keys.DELETE).build().perform();
	}
	
	public void ClickByUsingActionsClass(WebElement element, long durationInSeconds) {
		Actions actions=new Actions(driver);
		actions.moveToElement(element).click().perform();
	}
	
}//class
