package com.pintu.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pintu.assertion.Assertions;
import com.pintu.helper.ScrollHelper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class RegisterPage {
	private AppiumDriver<MobileElement> driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//*[contains(@resource-id,'textInputEditTextEmail')]")
	private WebElement emailField;

	@FindBy(xpath = "//*[contains(@resource-id,'textInputEditTextName')]")
	private WebElement nameField;

	@FindBy(xpath = "//*[contains(@resource-id,'textInputEditTextPassword')]")
	private WebElement passwordField;

	@FindBy(xpath = "//*[contains(@resource-id,'textInputEditTextConfirmPassword')]")
	private WebElement confirmPasswordField;

	@FindBy(xpath = "//*[contains(@resource-id,'appCompatButtonRegister')]")
	private WebElement registerButton;

	@FindBy(xpath = "//*[contains(@text,'Registration Successful')]")
	private WebElement notificationSuccess;

	@FindBy(xpath = "//*[@class = 'android.widget.TextView' and (@text = 'Enter Valid Email')]")
	private WebElement notifTextEmptyEmail;

	@FindBy(xpath = "//*[@class = 'android.widget.TextView' and (@text = 'Enter Full Name')]")
	private WebElement notifTextEmptyName;

	@FindBy(xpath = "//*[@class = 'android.widget.TextView' and (@text = 'Enter Password')]")
	private WebElement notifTextEmptyPassword;

	@FindBy(xpath = "//*[@class = 'android.widget.TextView' and (@text = 'Password Does Not Matches')]")
	private WebElement notifTextEmptyConfirmPassword;

	@FindBy(xpath = "//*[contains(@resource-id,'appCompatTextViewLoginLink')]")
	private WebElement loginLink;

	public RegisterPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
	}

	public void validateRegisterField() {
		Assertions.assertElementsDisplayed(emailField, nameField, passwordField, confirmPasswordField, registerButton);
	}

	public void fillAllRegisterData(String name, String email, String password) {

		fillNameField(name);
		fillEmailField(email);
		fillSamePasswordAndConfirmPasswordField(password);

	}

	public void submitRegister() {
		registerButton.click();
	}

	public void back() {
		driver.navigate().back();
	}

	public void fillNameField(String name) {

		nameField.sendKeys(name);

	}

	public void fillEmailField(String email) {

		emailField.sendKeys(email);

	}

	public void fillPasswordField(String password) {

		passwordField.sendKeys(password);

	}

	public void fillSamePasswordAndConfirmPasswordField(String password) {

		passwordField.sendKeys(password);
		confirmPasswordField.sendKeys(password);

	}

	public void fillDiffPasswordAndConfirmPasswordField(String password, String confirmPassword) {

		passwordField.sendKeys(password);

		confirmPasswordField.sendKeys(confirmPassword);
	}

	public void validateEmptyNameReminder() {
		Assertions.waitAndAssertVisibility(wait,notifTextEmptyName);
	}

	public void validateEmptyEmailReminder() {
		Assertions.waitAndAssertVisibility(wait,notifTextEmptyEmail);
	}

	public void validateEmptyPasswordReminder() {
		Assertions.waitAndAssertVisibility(wait,notifTextEmptyPassword);
	}

	public void validateEmptyConfirmPasswordReminder() {
		Assertions.waitAndAssertVisibility(wait,notifTextEmptyConfirmPassword);
	}

	public void scrollToLoginLink() {
		ScrollHelper scroll = new ScrollHelper(driver);
		scroll.scrollToElement(loginLink);
	}

	public void clickLoginLink() throws InterruptedException {
		Thread.sleep(3500);
		wait.until(ExpectedConditions.elementToBeClickable(loginLink));
		loginLink.click();
	}

	public void validateSuccessNotif() {
		Assertions.waitAndAssertVisibility(wait,notificationSuccess);
	}

}
