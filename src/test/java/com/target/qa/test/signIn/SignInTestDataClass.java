package com.target.qa.test.signIn;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseClass;
import utils.SignInData;

public class SignInTestDataClass extends BaseClass {

	@DataProvider(name = "signInDataIterator")
	public Iterator<SignInData> signInDataIterator() {
		List<SignInData> list = new ArrayList<SignInData>();
		SignInData signInData01 = new SignInData("Sign into your Target account",
				"https://www.target.com/login?client_id=ecom-web-1.0.0&ui_namespace=ui-default&back_button_action=browser&keep_me_signed_in=true&kmsi_default=false&actions=create_session_signin",
				"abcd@gmail.com", "987453#$!");
		SignInData signInData02 = new SignInData("Sign into your Target account",
				"https://www.target.com/login?client_id=ecom-web-1.0.0&ui_namespace=ui-default&back_button_action=browser&keep_me_signed_in=true&kmsi_default=false&actions=create_session_signin",
				"abcd@yahoo.com", "T345h#$!");
		list.add(signInData01);
		list.add(signInData02);
		return list.iterator();

	}
	@DataProvider(name = "signInDataObject")
	public Object[][]signInDataObject() {
		SignInData signInData01 = new SignInData("Sign into your Target account",
				"https://www.target.com/login?client_id=ecom-web-1.0.0&ui_namespace=ui-default&back_button_action=browser&keep_me_signed_in=true&kmsi_default=false&actions=create_session_signin",
				"taha@gmail.com", "987453#$!");
		SignInData signInData02 = new SignInData("Sign into your Target account",
				"https://www.target.com/login?client_id=ecom-web-1.0.0&ui_namespace=ui-default&back_button_action=browser&keep_me_signed_in=true&kmsi_default=false&actions=create_session_signin",
				"tahira@yahoo.com", "T345h#$!");
		return new Object[][] {{signInData01}, {signInData02}};
	}

	@Test(enabled = true, dataProvider = "signInDataObject")
	public void signIn(SignInData signInData) {
		homePageToSignIn.homePageSignInSteps();
		signIn.signInToYourTargetAccountSteps(signInData);

	}

}
