package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import common.Commons;

public class DormMustHaves {
	WebDriver driver;
	Commons commons;
	
	public DormMustHaves(WebDriver driver, Commons commons) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		this.commons=commons;
		
	}
	
	@FindBy(xpath = "//h1[text()='Dorm Must Haves']")
	WebElement titleElement;
	
	@FindBy(xpath = "//span[text()='Sheets']")
	WebElement sheetsElement;
	
	private void getTitle(String expectedValue) {
		Assert.assertEquals(expectedValue, commons.getText(titleElement));
		commons.getText(titleElement);
		
	}
	private void getUrl(String expectedUrl) {
		Assert.assertEquals(expectedUrl, commons.getCurrentUrl(driver));
		commons.getCurrentUrl(driver);

}private void clickSheets() {
	commons.click(titleElement);
}
	public void dormMustHavePageSteps(String expectedValue, String expectedUrl) {
		getTitle(expectedValue);
		getUrl(expectedUrl);
		clickSheets();
	}
}
