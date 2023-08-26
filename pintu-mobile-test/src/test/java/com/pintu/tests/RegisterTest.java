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
public class RegisterTest {

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
	public void testRegisterFieldVisible() {
		loginPage.goToRegisterPage();
		registerPage.validateRegisterField();

	}

	@Test(priority = 2)
	public void testRegisterFlow() {

		registerPage.fillAllRegisterData(faker.name().name(),faker.internet().emailAddress(),faker.ancient().hero());
		registerPage.submitRegister();
		registerPage.validateSuccessNotif();

	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
