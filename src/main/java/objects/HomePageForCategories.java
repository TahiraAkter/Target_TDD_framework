package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.Commons;

public class HomePageForCategories {
	
	WebDriver driver;
	Commons commons;

	public HomePageForCategories(WebDriver driver, Commons commons) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		this.commons = commons;
	}

	@FindBy(xpath = "//a[text()='Categories']")
	WebElement categoriesElement;
	
	@FindBy(xpath = "//span[text()='College']")
	WebElement collegElement;

	private void clickCategories() {
		commons.click(categoriesElement);
	}

	private void clickCollege() {
		commons.click(collegElement);
	}

	public void homePageCategoriesSteps() {
		clickCategories();
		clickCollege();
	}

}
