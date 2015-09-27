package org.testobject.example.komoot;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;

public class SignupTest {

    private AndroidDriver driver;

    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.SELENDROID);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "nexus5");
        capabilities.setCapability(MobileCapabilityType.APP, new File("src/test/resources/komoot.apk").getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.APP_WAIT_ACTIVITY, "de.komoot.android.app.JoinKomootActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
    @After
    public void tearDown(){
        if(driver != null) {
            driver.quit();
        }
    }
    @Test
    public void signupWithValidRandomDataSucceeds() throws InterruptedException {
        WebElement signupLink = driver.findElement(By.id("textview_mail_register_txt"));
        signupLink.click();

        driver.hideKeyboard();

        WebElement displayNameTextField = driver.findElement(By.id("edittext_display_name"));
        displayNameTextField.sendKeys("Test User");

        driver.hideKeyboard();

        WebElement emailTextField = driver.findElement(By.id("edittext_email"));
        emailTextField.sendKeys("andreas+" + ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE) + "@ludeke.net");

        driver.hideKeyboard();

        WebElement passwordTextField = driver.findElement(By.id("edittext_password"));
        passwordTextField.sendKeys("abcd1234");

        driver.hideKeyboard();

        WebElement signupButton = driver.findElement(By.id("button_register"));
        signupButton.click();

        System.out.println(driver.getPageSource());

        new WebDriverWait(driver, 10).until(invisibilityOfElementLocated(By.tagName("ProgressBar")));

        assertThat(driver.findElement(id("textview_header_title")).isDisplayed(), is(true));
    }
}
