package com.target.qa.test.signIn;
import java.util.Map;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseClass;
import utils.ExcelUtil;
import static utils.DataMap.*;

public class SignInTestMapDataProvider extends BaseClass { 

	@DataProvider(name = "excelMap")
	public Object[][] mapData() {
		String path = readConfigFile.get("excelPath");
		String sheetName = readConfigFile.get("excelSheetMap");
		ExcelUtil exUtil = new ExcelUtil(path, sheetName);
		int size = exUtil.dataMap().size();
		Object[][] objects2d = new Object[size][1]; 
		for (int i = 0; i < size; i++) {

			objects2d[i][0] = exUtil.dataMap().get(i);  
		}
		return objects2d;

	}

	@Test(enabled = false, dataProvider = "excelMap")
	public void signInWithMapDataProvider(Map<String, String> map) {
		homePageToSignIn.homePageSignInSteps();
		signIn.signInToYourTargetAccountSteps(map.get("Title"), map.get("URL"), map.get("Email"), map.get("Password"));

	}
	@Test(enabled = true, dataProvider = "excelMap")
	public void signInWithMapDataProviderWithEnum(Map<String, String> map) {
		homePageToSignIn.homePageSignInSteps();
		signIn.signInToYourTargetAccountSteps(map.get(Title.name()), map.get(URL.name()),map.get(Email.getValue()), map.get(Password.getValue()));
		
	}

}
