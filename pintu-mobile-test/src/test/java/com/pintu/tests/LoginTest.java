package com.pintu.tests;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.pintu.helper.GeneralHelper;
import com.pintu.pages.HomePage;
import com.pintu.pages.LoginPage;
import com.pintu.pages.RegisterPage;
import com.pintu.utils.Listener;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

@Listeners(Listener.class)
public class LoginTest {

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

	@Test
	public void testLoginJourney() throws InterruptedException {
		String name = faker.name().name();
		String email = faker.internet().emailAddress();
		String password = faker.ancient().hero();

		loginPage.goToRegisterPage();
		registerPage.fillAllRegisterData(name, email, password);
		registerPage.submitRegister();
		registerPage.validateSuccessNotif();
		registerPage.scrollToLoginLink();
		registerPage.clickLoginLink();
		loginPage.fillEmailField(email);
		loginPage.fillPasswordField(password);
		loginPage.submitLogin();
		homePage.assertUserDataAtHome(name, email, password);

	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
