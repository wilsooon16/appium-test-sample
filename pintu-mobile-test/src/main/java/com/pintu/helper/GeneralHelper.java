package com.pintu.helper;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.gson.Gson;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class GeneralHelper {

	public static DesiredCapabilities getDesiredCapabilities() {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		// Set platform name
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

		// Set device name
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5556");

		// Set platform version
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");

		// Set app package and activity
		capabilities.setCapability("appPackage", "com.loginmodule.learning");
		capabilities.setCapability("appActivity", "com.loginmodule.learning.activities.LoginActivity");

		// Set automation name
		capabilities.setCapability("automationName", "UiAutomator2");

		// Specify the path to the APK file
		File filePath = new File(System.getProperty("user.dir"));
		File appDir = new File(filePath, "/app");
		File app = new File(appDir, "sample.apk");

		// Set the app capability to the APK file
		capabilities.setCapability("app", app.getAbsolutePath());

		// Print Desired Capabilities JSON

		return capabilities;
	}

	public static AppiumDriver<MobileElement> setAppiumDriver(DesiredCapabilities desiredCapabilities) {
		AppiumDriver<MobileElement> driver;
		// Appium server URL
		URL appiumServerURL;
		try {
			appiumServerURL = new URL("http://127.0.0.1:4723/wd/hub");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		// Initialize the AppiumDriver
		driver = new AndroidDriver<MobileElement>(appiumServerURL, desiredCapabilities);
		return driver;
	}
}
