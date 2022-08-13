package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import common.Commons;

public class SignInToYourTargetAccount {

	WebDriver driver;
	Commons commons;

	public SignInToYourTargetAccount(WebDriver driver, Commons commons) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.commons = commons;
	}

	@FindBy(xpath = "//span[text()='Sign into your Target account']")
	WebElement titleElement;

	@FindBy(xpath = "//input[@name='username']")
	WebElement userNameElement;

	@FindBy(css = "input#password")
	WebElement passwordElement;

	@FindBy(xpath = "//span[text()='Sign in']")
	WebElement signInElement;

	private void getTitle(String expectedValue) {
		Assert.assertEquals(expectedValue, commons.getText(titleElement));
		commons.getText(titleElement);
	}

	private void getUrl(String expectedUrl) {
		Assert.assertEquals(expectedUrl, commons.getCurrentUrl(driver));
		commons.getCurrentUrl(driver);
	}

	private void inputEmail(String email) {
		commons.inputValues(userNameElement, email);
	}

	private void inputPassword(String password) {
		commons.inputValues(passwordElement, password);
	}

	private void clickSignIn3() {
		commons.click(signInElement);
	}

	public void signInToYourTargetAccountSteps(String expected, String expectedUrl, String email, String password) {
		getTitle(expected);
		getUrl(expectedUrl);
		inputEmail(email);
		inputPassword(password);
		clickSignIn3();

	}
}
