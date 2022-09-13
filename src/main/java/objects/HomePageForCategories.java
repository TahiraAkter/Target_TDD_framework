package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.CommonFunctions;
import common.CommonWaits;

public class HomePageForCategories {

	WebDriver driver;
	CommonFunctions commons;

	public HomePageForCategories(WebDriver driver, CommonFunctions commons) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.commons = commons;
	}

	@FindBy(xpath = "//a[text()='Categories']")
	WebElement categoriesElement;

	@FindBy(xpath = "//span[contains(@class, 'CellSkinny') and text()='Home']")
	WebElement homeElement;

	@FindBy(xpath = "//div[contains(@class,'sc')]/span[text()='Bedding']")
	WebElement beddingElement;

	@FindBy(xpath = "//span[text()='Sheets & Pillowcases']")
	WebElement sheetsPillowcaseElement;

	private void clickCategories() {
		commons.click(categoriesElement);
	}

	private void clickHome() {
		commons.click(homeElement);
	}

	private void clickBedding() {
		commons.click(beddingElement);
	}

	private void clickSheetsPillowcase() {
		commons.click(sheetsPillowcaseElement);
	}

	public void homePageCategoriesSteps() {
		clickCategories();
		clickHome();
		clickBedding();
		clickSheetsPillowcase();
	}

}
