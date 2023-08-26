package com.pintu.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pintu.assertion.Assertions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * Hello world!
 *
 */
public class LoginPage {
	private AppiumDriver<MobileElement> driver;
	private WebDriverWait wait;

	public LoginPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 15);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[contains(@resource-id,'textViewLinkRegister')]")
	private WebElement registerText;

	@FindBy(xpath = "//*[contains(@resource-id,'textInputEditTextEmail')]")
	private WebElement emailField;

	@FindBy(xpath = "//*[contains(@resource-id,'textInputEditTextPassword')]")
	private WebElement passwordField;

	@FindBy(xpath = "//*[contains(@resource-id,'appCompatButtonLogin')]")
	private WebElement loginButton;

	@FindBy(xpath = "//*[contains(@text,'Wrong Email or Password')]")
	private WebElement notifyWrongCredential;

	@FindBy(xpath = "//*[@class = 'android.widget.TextView' and (@text = 'Enter Valid Email')]")
	private WebElement notifTextEmptyEmail;

	@FindBy(xpath = "//*[@class = 'android.widget.TextView' and (@text = 'Enter Valid Email')]")
	private WebElement notifTextEmptyPassword;

	public void validateWrongCredentialNotif() {
		Assertions.waitAndAssertVisibility(wait, notifyWrongCredential);
	}

	public void validateEmptyEmailReminder() {
		Assertions.waitAndAssertVisibility(wait, notifTextEmptyEmail);
	}

	public void validateEmptyPasswordReminder() {
		Assertions.waitAndAssertVisibility(wait, notifTextEmptyPassword);
	}

	public void fillEmailField(String email) {

		emailField.sendKeys(email);

	}

	public void clearEmailField() {

		emailField.clear();

	}

	public void clearPasswordField() {

		passwordField.clear();

	}

	public void fillPasswordField(String password) {

		passwordField.sendKeys(password);

	}

	public void submitLogin() {
		loginButton.click();
	}

	public void goToRegisterPage() {
		Assertions.waitAndAssertVisibility(wait, registerText);
		registerText.click();

	}

}
