package com.target.qa.test.signIn;
import org.testng.annotations.Test;
import base.BaseClass;

public class SignInTestClass extends BaseClass {

	@Test(enabled = false)
	public void signIn() {
		homePageToSignIn.homePageSignInSteps();
		signIn.signInToYourTargetAccountSteps("Sign into your Target account",
				"https://www.target.com/login?client_id=ecom-web-1.0.0&ui_namespace=ui-default&back_button_action=browser&keep_me_signed_in=true&kmsi_default=false&actions=create_session_signin",
				"abcd@gmail.com", "987453#$!");

	}

}
