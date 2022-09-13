package com.target.qa.test.categories;

import org.testng.annotations.Test;
import base.BaseClass;

public class CategoriesTestClass extends BaseClass {

	@Test(enabled = true)
	public void getCategories() {
		categories.homePageCategoriesSteps();
		sheets.sheetsPillowcasesPageSteps("Sheets & Pillowcases", "https://www.target.com/c/sheets-pillowcases-bedding-home/-/N-5xtuv");
		//bedding.dormBeddingSteps("bedding sheets : Dorm Bedding",
				//"https://www.target.com/c/dorm-bedding/bedding-sheets/-/N-5v9x9Z3k91z?sortBy=PriceLow");
	}

}
