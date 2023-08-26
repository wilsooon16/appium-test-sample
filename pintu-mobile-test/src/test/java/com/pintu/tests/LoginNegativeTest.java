package com.pintu.tests;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.pintu.helper.GeneralHelper;
import com.pintu.pages.HomePage;
import com.pintu.pages.LoginPage;
import com.pintu.pages.RegisterPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginNegativeTest {

	private AppiumDriver<MobileElement> driver;
	private DesiredCapabilities desiredCapabilities;
	RegisterPage registerPage;
	LoginPage loginPage;
	HomePage homePage;
	Faker faker;

	@BeforeClass
	public void setUp() {
		desiredCapabilities = GeneralHelper.getDesiredCapabilities();
		driver = GeneralHelper.setAppiumDriver(desiredCapabilities);
		registerPage = new RegisterPage(driver);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		faker = new Faker();

	}

	@Test(priority = 1)
	public void testEmptyEmailLogin() throws InterruptedException {

		String password = faker.ancient().hero();
		loginPage.clearEmailField();
		loginPage.clearPasswordField();
		loginPage.fillPasswordField(password);
		loginPage.submitLogin();
		loginPage.validateEmptyEmailReminder();
		

	}

	@Test(priority = 2)
	public void testEmptyPasswordLogin() throws InterruptedException {

		String email = faker.internet().emailAddress();
		loginPage.clearEmailField();
		loginPage.clearPasswordField();
		loginPage.fillEmailField(email);
		loginPage.submitLogin();
		loginPage.validateEmptyPasswordReminder();
	
	}

	@Test(priority = 3)
	public void testInvalidCredential() throws InterruptedException {

		String email = faker.internet().emailAddress();
		String password = faker.ancient().hero();
		loginPage.clearEmailField();
		loginPage.clearPasswordField();
		loginPage.fillEmailField(email);
		loginPage.fillPasswordField(password);
		loginPage.submitLogin();
		loginPage.validateWrongCredentialNotif();

	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
