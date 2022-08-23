package objects;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import common.CommonFunctions;
import common.CommonWaits;

public class DormMustHaves {
	WebDriver driver;
	CommonFunctions commons;
	CommonWaits waits;

	public DormMustHaves(WebDriver driver, CommonFunctions commons, CommonWaits waits) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.commons = commons;
		this.waits = waits;

	}

	@FindBy(xpath = "//h1[text()='Dorm Must Haves']")
	WebElement titleElement;

	@FindBy(xpath = "//span[@style='font-weight: 200;' and text()='Sheets']")
	WebElement sheetsElement;
	
	// "//span[text()='Sheets']"
	//span[text()='Water bottles'
	
	private void getTitle(String expectedValue) {
        assertEquals(commons.getText(titleElement),expectedValue);
	}

	private void getUrl(String expectedUrl) {
		assertEquals(commons.getCurrentUrl(driver),expectedUrl);

	}

	private void clickSheets() {
		//JavascriptExecutor js=(JavascriptExecutor) driver;
		//WebElement sheetElement=driver.findElement(By.xpath("//span[@style='font-weight: 200;' and text()='Sheets']"));
		//js.executeScript("argument[0].click())", sheetElement);
		commons.click(sheetsElement);

	}

	public void dormMustHavePageSteps(String expectedValue, String expectedUrl) {
		getTitle(expectedValue);
		getUrl(expectedUrl);
		clickSheets();
	}
}
