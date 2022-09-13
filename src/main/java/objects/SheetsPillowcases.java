package objects;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import common.CommonFunctions;
import common.CommonWaits;

public class SheetsPillowcases {
	WebDriver driver;
	CommonFunctions commons;
	CommonWaits waits;

	public SheetsPillowcases(WebDriver driver, CommonFunctions commons, CommonWaits waits) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.commons = commons;
		this.waits = waits;

	}

	@FindBy(xpath = "//h1[contains(@class, 'Heading__StyledHeading')]")
	WebElement titleElement;

	@FindBy(xpath = "//div/picture/img[contains(@alt, '400 Thread Count Solid Performance Sheet Set')]")
	WebElement sheetsElement;

	// "//span[text()='Sheets']"
	// span[text()='Water bottles'

	private void getTitle(String expectedValue) {
		assertEquals(commons.getText(titleElement), expectedValue);
	}

	private void getUrl(String expectedUrl) {
		assertEquals(commons.getCurrentUrl(driver), expectedUrl);

	}

	private void clickSheets() {
		commons.scrollPageDown();
		commons.click(sheetsElement);

	}

	public void sheetsPillowcasesPageSteps(String expectedValue, String expectedUrl) {
		getTitle(expectedValue);
		getUrl(expectedUrl);
		clickSheets();
	}
}
