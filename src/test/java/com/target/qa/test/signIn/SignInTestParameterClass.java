package com.target.qa.test.signIn;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base.BaseClass;

public class SignInTestParameterClass extends BaseClass{
	
	@Parameters("email")
	@Test(enabled = true)
	public void signIn(String email) {
		homePageToSignIn.homePageSignInSteps();
		signIn.signInToYourTargetAccountSteps("Sign into your Target account",
				"https://www.target.com/login?client_id=ecom-web-1.0.0&ui_namespace=ui-default&back_button_action=browser&keep_me_signed_in=true&kmsi_default=false&actions=create_session_signin",
				email, "987453#$!");

}
}
