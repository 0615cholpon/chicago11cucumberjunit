package test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidTest {
    AndroidDriver androidDriver;
    AppiumDriverLocalService service;


@Test
    public void testMobileWeb() throws MalformedURLException {

        service = AppiumDriverLocalService.buildDefaultService();
        service.start();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("appPackage","com.kehe.delivery.qa");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomation2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android SDK built for x86");
        capabilities.setCapability("avd", "Android SDK built for x86");
        capabilities.setCapability(MobileCapabilityType.APP, "TBD");


        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
        capabilities.setCapability("chromedriverExecutable", "/Users/chopa/Desktop/chicago11cucumberjunit/src/test/java/drivers/chromedriver 2");

        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("newCommandTimeout", 60000);


        WebDriver androidWebDriver = new AndroidDriver(new URL("http://127.0.01:4723/wd/hub"), capabilities);
        androidWebDriver.get("https://www.amazon.com");
        String actualTitle = androidWebDriver.getTitle();
        String expectedTitle = "Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));





    }
}
