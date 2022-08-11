package com.target.qa.test.signIn;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import base.BaseClass;

public class SignInTestClass extends BaseClass{
	
	@Test
	public void signIn() {
		homePage.homePageSteps("abcd@gmail.com", "987453#$!");
		
	}

}
