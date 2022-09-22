package com.target.qa.test.signIn;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseClass;
import utils.ExcelUtil;
import utils.SignInData;

public class SignInTestExcel2SignInData extends BaseClass {

	@DataProvider(name = "excelSignInData")
	public Iterator<SignInData> signInData() {
		String path = readConfigFile.get("excelPath");
		String sheetName = readConfigFile.get("excelSheet");
		ExcelUtil exUtil = new ExcelUtil(path, sheetName);
		String[][] objects = exUtil.dataObjects();
		List<SignInData> list = new ArrayList<SignInData>();
		for (int i = 0; i < objects.length; i++) {
			SignInData signInData = new SignInData(objects[i][0], objects[i][1], objects[i][2], objects[i][3]);
			list.add(signInData);
		}
		return list.iterator();
	}

	@Test(enabled = true, dataProvider = "excelSignInData")
	public void signInExcel(SignInData signInData) {
		homePageToSignIn.homePageSignInSteps();
		signIn.signInToYourTargetAccountSteps(signInData);
	}

}
