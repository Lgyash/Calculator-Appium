package com.example.calculator;
import io.appium.java_client.android.AndroidDriver;
import capabilities.AndroidCapabilities;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalculatorTest {
    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        driver = AndroidCapabilities.setUp();
    }

    @Test
    public void testAddition() {
        MobileElement digit2 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_2");
        MobileElement plus = (MobileElement) driver.findElementByAccessibilityId("plus");
        MobileElement digit3 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_3");
        MobileElement equals = (MobileElement) driver.findElementByAccessibilityId("equals");
        MobileElement result = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");

        digit2.click();
        plus.click();
        digit3.click();
        equals.click();

        Assert.assertEquals(result.getText(), "5");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
