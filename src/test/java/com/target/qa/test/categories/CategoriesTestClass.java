package com.target.qa.test.categories;

import org.testng.annotations.Test;
import base.BaseClass;

public class CategoriesTestClass extends BaseClass {

	@Test(enabled = true)
	public void getCategories() {
		categories.homePageCategoriesSteps();
		sheets.sheetsPillowcasesPageSteps("Sheets & Pillowcases", "https://www.target.com/c/sheets-pillowcases-bedding-home/-/N-5xtuv");
	}

}
