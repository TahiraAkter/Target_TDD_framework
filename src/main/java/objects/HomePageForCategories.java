package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.CommonFunctions;

public class HomePageForCategories {
	
	WebDriver driver;
	CommonFunctions commons;

	public HomePageForCategories(WebDriver driver, CommonFunctions commons) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		this.commons = commons;
	}

	@FindBy(xpath = "//a[text()='Categories']")
	WebElement categoriesElement;
	
	@FindBy(xpath = "//span[text()='College']")
	WebElement collegElement;
	
	@FindBy(xpath = "//span[text()='Dorm Must Haves']")
	WebElement dormMustHavesElement;

	private void clickCategories() {
		commons.click(categoriesElement);
	}

	private void clickCollege() {
		commons.click(collegElement);
	}
	private void clickDormMustHaves() {
		commons.click(dormMustHavesElement);
	}

	public void homePageCategoriesSteps() {
		clickCategories();
		clickCollege();
		clickDormMustHaves();
	}

}
