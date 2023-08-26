package com.pintu.helper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ScrollHelper {

    private AppiumDriver<MobileElement> driver;

    public ScrollHelper(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public boolean scrollToElement(By by) {
        return scrollToElement(driver.findElement(by));
    }

    public boolean scrollToElement(WebElement element) {
        int maxScrollAttempts = 5; // Maximum number of scroll attempts
        int currentScrollAttempt = 0;

        while (currentScrollAttempt < maxScrollAttempts) {
            if (isElementVisible(element)) {
                return true; // Element found
            } else {
                scrollDown();
                currentScrollAttempt++;
            }
        }

        return false; // Element not found after scrolling
    }

    private void scrollDown() {
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();

        int startX = screenWidth / 2;
        int startY = (int) (screenHeight * 0.8); // Starting from 80% of the screen height
        int endY = (int) (screenHeight * 0.2); // Scrolling to 20% of the screen height

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startX, startY))
                   .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                   .moveTo(PointOption.point(startX, endY))
                   .release()
                   .perform();
    }

    private boolean isElementVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
