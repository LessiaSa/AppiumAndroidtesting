import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SampleTestAndroid {
    enum Platform {Android, IOS}

    Platform platform = Platform.Android;

    private AppiumDriver driver;
    private MobileObjects mobileObjects;

    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @BeforeEach
    public void setUp() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 10000);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        if (platform == Platform.Android) {
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("appium:deviceName", "Some name");
            desiredCapabilities.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
            desiredCapabilities.setCapability("appium:appActivity", "ru.netology.testing.uiautomator.MainActivity");
            desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
            driver = new AndroidDriver(getUrl(), desiredCapabilities);
            mobileObjects = new MobileObjects(driver);
        } else {
            if (platform == Platform.IOS) {
                desiredCapabilities.setCapability("platformName", "IOS");
                desiredCapabilities.setCapability("appium:deviceName", "iPhone 11");
                desiredCapabilities.setCapability("appium:bundleId", "открываю XCode, вкладка General - и там bundleId");
                desiredCapabilities.setCapability("appium:automationName", "XCUITest");
                driver = new IOSDriver(getUrl(), desiredCapabilities);
            }
            mobileObjects = new MobileObjects(driver);
        }

    }

    @Test
    public void sampleTest() {
        mobileObjects.btnInput.isDisplayed();
        mobileObjects.btnInput.click();
        mobileObjects.btnInput.sendKeys("Hi!");

        mobileObjects.btnActivity.isDisplayed();
        mobileObjects.btnActivity.click();

        mobileObjects.result.isDisplayed();

        Assertions.assertEquals("Hi!", mobileObjects.result.getText());
    }

    @Test
    public void sampleTestEmptyLine() {
        mobileObjects.btnInput.isDisplayed();
        mobileObjects.btnInput.click();
        mobileObjects.btnInput.sendKeys(" ");

        mobileObjects.btnActivity.isDisplayed();
        mobileObjects.btnActivity.click();

        mobileObjects.result.isDisplayed();

        Assertions.assertEquals(" ", mobileObjects.result.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }


}




