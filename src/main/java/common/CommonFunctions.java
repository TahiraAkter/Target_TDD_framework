package common;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.google.common.io.Files;
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

	public void failText() {
		Loggers.getLog(getClass().getMethods()[0].getName() + " ----> has failed");
		Assert.fail();
	}

	public String getScreenshot(String testName) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("MMddyyyy_hh.mm.ss");
		String extension = format.format(date);
		File file = new File("screenShots/" + testName + "_" + extension + ".png");
		TakesScreenshot ss = (TakesScreenshot)driver;
		File outPutFile = ss.getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(outPutFile, file.getAbsoluteFile());
			Loggers.getLog("Test has been failed \nScreenshot taken here ---> " + file.getAbsolutePath());
		} catch (Exception e) {
			e.printStackTrace();
			Loggers.getLog("Error while taking screenshot");
		}
		return file.getAbsolutePath();
	}

	}

