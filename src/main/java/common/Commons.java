package common;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import reporting.Loggers;

public class Commons {

	public void click(WebElement element) {// to inputValue, we need 2 parameters: element, and value

		try {
			element.click();// this element we get from the runtime
			// this is called dynamic approach. We can pass any element and any value
			Loggers.getLog(element + " This element has been clicked");
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

	public void inputValues(WebElement element, String value) {
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

}
