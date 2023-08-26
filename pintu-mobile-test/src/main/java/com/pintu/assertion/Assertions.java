package com.pintu.assertion;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assertions {
	
	
	public static void waitAndAssertVisibility(WebDriverWait wait, WebElement element) {
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed());
	}
	
	public static void assertElementsDisplayed(WebElement... elements) {
		for (WebElement element : elements) {
			Assert.assertTrue(element.isDisplayed());
		}
	}
}
