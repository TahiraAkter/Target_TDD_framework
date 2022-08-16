package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import common.Commons;

public class DormBedding {
	WebDriver driver;
	Commons commons;

	public DormBedding(WebDriver driver, Commons commons) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.commons = commons;
	}

	@FindBy(css = "div.styles__HeadingContainer-sc-4tej7h-0.hVEHfS")
	WebElement titleElement;
	@FindBy(css = "img[alt='Printed Microfiber Sheet Set - Room Essentials™']")
	WebElement printedMicrofiberSheetSetElement;

	private void getTitle(String expectedTitle) {
		Assert.assertEquals(expectedTitle, commons.getText(titleElement));
		commons.getText(titleElement);

	}

	private void getUrl(String expectedUrl) {
		Assert.assertEquals(expectedUrl, commons.getCurrentUrl(driver));
		commons.getCurrentUrl(driver);
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
