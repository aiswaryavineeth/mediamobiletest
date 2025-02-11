import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Main {

    protected static AppiumDriver driver;
    protected static WebDriverWait wait;

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("ignoreHiddenApiPolicyError", true);
        capabilities.setCapability("skipUnlock", true);
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("deviceName", "OPPO Reno10 5G");
        capabilities.setCapability("udid", "R9WX30CYWJF");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "14");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.aqary.aqary_international");
        capabilities.setCapability("appActivity", "com.aqary.aqary_international.MainActivity");

        driver = new AndroidDriver(new URL("http://localhost:4723"), capabilities);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("All tests completed successfully.");
        }
    }

    public void click(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public void enterText(By locator, String value) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
        element.clear();
        element.sendKeys(value);
    }

    public String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }
}
