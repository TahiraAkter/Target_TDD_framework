package com.target.qa.test.signIn;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseClass;
import utils.ExcelUtil;

public class SignInTestExcel2D extends BaseClass {

	@DataProvider(name = "signInData2DExcel")
	public Object[][] signInData() {
		String path = readConfigFile.get("excelPath");
		String sheetName = readConfigFile.get("excelSheet");
		ExcelUtil exUtil = new ExcelUtil(path, sheetName);
		return exUtil.dataObjects();
	}

	@Test(enabled = true, dataProvider = "signInData2DExcel")
	public void signIn(String expectedTitle, String expectedUrl, String email, String password) {
		homePageToSignIn.homePageSignInSteps();
		signIn.signInToYourTargetAccountSteps(expectedTitle, expectedUrl, email, password);

	}
}
