package common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import reporting.Loggers;

public class CommonFunctions {
	WebDriver driver;
	CommonWaits waits;

	public CommonFunctions(WebDriver driver, CommonWaits waits) {
		this.driver = driver;
		this.waits = waits;
	}

	public void click(WebElement element) {

		try {
			waits.waitUntilClickable(element);
			element.click();// this element we get from the runtime
			// this is called dynamic approach. We can pass any element and any value
			Loggers.getLog(" This element has been clicked" + element);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.getLog(element + " : This element is not found");
			Assert.fail();
		}
	}

	public String getText(WebElement element) {
		String valueString = null;
		try {
			valueString = element.getText();
			Loggers.getLog(element + " :has value---->" + valueString);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
		}
		return valueString;
	}

	public void inputValues(WebElement element, String value) {// to inputValue, we need 2 parameters: element, and
																// value
		try {
			element.sendKeys(value);
			Loggers.getLog(value + " : This value has been passed through this " + element);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.getLog(element + " :This element is not found");
			Assert.fail();

		}
	}

	public String getCurrentUrl(WebDriver driver) {
		Loggers.getLog("Current Url is: " + driver.getCurrentUrl());
		return driver.getCurrentUrl();

	}

	public void selectByVisibleText(WebElement element, String value) {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(value);
			Loggers.getLog(value + " : This value has been passed through this " + element);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.getLog(element + " :This element is not found");
			Assert.fail();

		}

	}

	public void scrollPageDown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");
	}

}
