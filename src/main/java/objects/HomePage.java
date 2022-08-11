package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.Commons;

public class HomePage {

	Commons commons;

	public HomePage(WebDriver driver, Commons commons) {
		PageFactory.initElements(driver, this);
		this.commons = commons;
	}

	@FindBy(xpath =   "//span[text()='Sign in']")
	WebElement signInElement1;

	@FindBy(xpath = "//span[starts-with(@class, 'styles__ListItemText-sc-5oc0g9-1') and text()='Sign in']")
	WebElement signInElement2;

	@FindBy(xpath =  "//input[@id='username']")
	WebElement emailElement;

	@FindBy(css = "input#password")
	WebElement passwordElement;

	private void clickSignIn1() {
		commons.click(signInElement1);
	}

	private void clickSignIn2() {
		commons.click(signInElement2);
	}

	private void inputEmail(String value) {
		commons.inputValues(emailElement, value);
	}

	private void inputPassword(String value) {
		commons.inputValues(passwordElement, value);
	}

	public void homePageSteps(String value1, String value2) {
		clickSignIn1();
		clickSignIn2();
		inputEmail(value1);
		inputPassword(value2);

	}

}
