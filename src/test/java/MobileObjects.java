import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MobileObjects {
    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/userInput")
    @iOSXCUITFindBy(xpath = "какой то локатор")
    MobileElement btnInput;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/buttonActivity")
    @iOSXCUITFindBy(xpath = "какой то локатор")
    MobileElement btnActivity;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/text")
    @iOSXCUITFindBy(xpath = "какой то локатор")
    MobileElement result;


    private AppiumDriver driver;

    MobileObjects(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(100)), this);
    }
}



