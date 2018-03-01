import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MailTests {

    WebDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "BH902HV515");

        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");

        capabilities.setCapability(CapabilityType.VERSION, "5.1.1");

        capabilities.setCapability("platformName", "Android");

        capabilities.setCapability("appPackage", "com.android.email");

        capabilities.setCapability("appActivity", ".activity.EmailActivity");

        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void gmailTest() {

        driver.findElement(By.id("com.android.email:id/welcome_splash_getstarted_button")).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement emailInput = driver.findElement(By.id("com.android.email:id/account_email"));

        emailInput.sendKeys("andrianlarson@gmail.com");

        WebElement passwordInput = driver.findElement(By.id("com.android.email:id/account_password"));

        passwordInput.sendKeys("qwertyuiop[]");

        WebElement nextButton = driver.findElement(By.id("com.android.email:id/btn_second"));

        nextButton.click();
    }

    @After
    public void end() {
        driver.quit();
    }
}
