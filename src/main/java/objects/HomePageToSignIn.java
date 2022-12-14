package objects;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.CommonFunctions;
import utils.SignInData;

public class HomePageToSignIn {

	CommonFunctions commons;

	 public HomePageToSignIn (WebDriver driver, CommonFunctions commons) {
		PageFactory.initElements(driver, this);
		this.commons = commons;
	}

	@FindBy(xpath = "//span[text()='Sign in']")
	WebElement signInElement1;

	@FindBy(xpath = "//span[contains(@class,'sc-diphzn-1 fVlQrE') and text()='Sign in']")
	WebElement signInElement2;

	private void clickSignIn1() {
		commons.click(signInElement1);
	}

	private void clickSignIn2() {
		commons.click(signInElement2);
	}

	public void homePageSignInSteps() {
		clickSignIn1();
		clickSignIn2();

	}
	public void homePageSignInSteps(SignInData signInData) {
		clickSignIn1();
		clickSignIn2();

	}
	public void homePageSignInSteps(Map<String, String>Map) {
		clickSignIn1();
		clickSignIn2();

	}

}
