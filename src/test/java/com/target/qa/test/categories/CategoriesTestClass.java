package com.target.qa.test.categories;

import org.testng.annotations.Test;
import base.BaseClass;

public class CategoriesTestClass extends BaseClass {

	@Test(enabled = true)
	public void getCategories() {
		categories.homePageCategoriesSteps();
		dorms.dormMustHavePageSteps("Dorm Must Haves", "https://www.target.com/c/dorm-must-haves/-/N-vwnyd");
		bedding.dormBeddingSteps("bedding sheets : Dorm Bedding",
				"https://www.target.com/c/dorm-bedding/bedding-sheets/-/N-5v9x9Z3k91z?sortBy=PriceLow");
	}

}
