package com.pintu.tests;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.pintu.helper.GeneralHelper;
import com.pintu.pages.RegisterPage;
import com.pintu.utils.Listener;
import com.pintu.pages.LoginPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


@Listeners(Listener.class)
public class RegisterNegativeTest {

	private AppiumDriver<MobileElement> driver;
	private DesiredCapabilities desiredCapabilities;
	RegisterPage registerPage;
	LoginPage loginPage;
	Faker faker;

	@BeforeClass
	public void setUp() {
		desiredCapabilities = GeneralHelper.getDesiredCapabilities();
		driver = GeneralHelper.setAppiumDriver(desiredCapabilities);
		registerPage = new RegisterPage(driver);
		loginPage = new LoginPage(driver);
		faker = new Faker();

	}

	@Test(priority = 1)
	public void testSubmitEmptyName() {

		loginPage.goToRegisterPage();
		registerPage.submitRegister();
		registerPage.validateEmptyNameReminder();
		registerPage.back();

	}

	@Test(priority = 2)
	public void testSubmitEmptyEmail() {
		loginPage.goToRegisterPage();
		registerPage.fillNameField(faker.name().name());
		registerPage.submitRegister();
		registerPage.validateEmptyEmailReminder();
		registerPage.back();

	}
	

	@Test(priority = 3)
	public void testSubmitEmptyPassword() {
		loginPage.goToRegisterPage();
		registerPage.fillNameField(faker.name().name());
		registerPage.fillEmailField(faker.internet().emailAddress());
		registerPage.submitRegister();
		registerPage.validateEmptyPasswordReminder();
		registerPage.back();
	}
	
	@Test(priority = 4)
	public void testSubmitEmptyConfirmPassword() {
		loginPage.goToRegisterPage();
		registerPage.fillNameField(faker.name().name());
		registerPage.fillEmailField(faker.internet().emailAddress());
		registerPage.fillPasswordField(faker.ancient().hero());
		registerPage.submitRegister();
		registerPage.validateEmptyConfirmPasswordReminder();
		registerPage.back();
	}
	
	@Test(priority = 5)
	public void testSubmitDifferentConfirmPassword() {
		loginPage.goToRegisterPage();
		registerPage.fillNameField(faker.name().name());
		registerPage.fillEmailField(faker.internet().emailAddress());
		registerPage.fillDiffPasswordAndConfirmPasswordField(faker.ancient().hero(), faker.ancient().titan());
		registerPage.submitRegister();
		registerPage.validateEmptyConfirmPasswordReminder();
		registerPage.back();
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
