package com.target.qa.test.categories;

import org.testng.annotations.Test;
import base.BaseClass;

public class CategoriesTestClass extends BaseClass {
	
	@Test(enabled = true)
	public void getCategories() {
		categories.homePageCategoriesSteps();
	}

}
