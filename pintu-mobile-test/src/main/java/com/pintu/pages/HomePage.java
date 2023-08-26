package com.pintu.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HomePage {
	private AppiumDriver<MobileElement> driver;
	private WebDriverWait wait;

	public HomePage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 15);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class = 'android.widget.TextView' and (@text = 'Android NewLine Learning')]")
	private WebElement homePageBanner;

	@FindBy(xpath = "(//*[contains(@resource-id, 'textViewName')])[last()]")
	private WebElement textViewName;

	@FindBy(xpath = "(//*[contains(@resource-id, 'textViewEmail')])[last()]")
	private WebElement textViewEmail;

	@FindBy(xpath = "(//*[contains(@resource-id, 'textViewPassword')])[last()]")
	private WebElement textViewPassword;

	public void assertUserDataAtHome(String name, String email, String password) {
		Assert.assertEquals(textViewName.getText(), name);
		Assert.assertEquals(textViewEmail.getText(), email);
		Assert.assertEquals(textViewPassword.getText(), password);

	}

}
