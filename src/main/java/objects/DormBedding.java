package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import common.CommonFunctions;

public class DormBedding {
	WebDriver driver;
	CommonFunctions commons;

	public DormBedding(WebDriver driver, CommonFunctions commons) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.commons = commons;
	}

	@FindBy(xpath = "//h1[text()='bedding sheets : Dorm Bedding']")
	WebElement titleElement1;
	@FindBy(css = "img[alt='Printed Microfiber Sheet Set - Room Essentials™']")
	WebElement printedMicrofiberSheetSetElement;

	private void getTitle(String expectedTitle) {
		Assert.assertEquals(commons.getText(titleElement1), expectedTitle);

	}

	private void getUrl(String expectedUrl) {
		Assert.assertEquals(commons.getCurrentUrl(driver), expectedUrl);
	}

	private void clickPrintedMicrofiberSheetSet() {
		commons.click(printedMicrofiberSheetSetElement);
	}

	public void dormBeddingSteps(String expectedTitle, String expectedUrl) {
		getTitle(expectedTitle);
		getUrl(expectedUrl);
		clickPrintedMicrofiberSheetSet();

	}

}
