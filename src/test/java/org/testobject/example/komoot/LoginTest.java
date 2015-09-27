package org.testobject.example.komoot;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.openqa.selenium.By.id;

public class LoginTest {

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
    public void loginWithValidCredentialsSucceeds() throws InterruptedException {
        WebElement loginLink = driver.findElement(By.id("textview_login"));
        loginLink.click();

        WebElement emailTextField = driver.findElement(By.id("edittext_email"));
        emailTextField.sendKeys("andreas@ludeke.net");

        WebElement passwordTextField = driver.findElement(By.id("edittext_password"));
        passwordTextField.sendKeys("abcd1234");

        WebElement loginButton = driver.findElement(By.id("button_login"));
        loginButton.click();

        System.out.println(driver.getPageSource());

        Thread.sleep(1000);

        assertThat(driver.findElement(id("action_bar_container")).isDisplayed(), is(true));
    }
}
