package org.testobject.example.komoot;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testobject.example.komoot.screen.Komoot;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ThreadLocalRandom;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;

public class SignupTest {

    private Komoot app;

    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.SELENDROID);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "nexus5");
        capabilities.setCapability(MobileCapabilityType.APP, new File("src/test/resources/komoot.apk").getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.APP_WAIT_ACTIVITY, "de.komoot.android.app.JoinKomootActivity");

        app = new Komoot(new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities));
    }

    @After
    public void tearDown(){
        if(app != null) {
            app.quit();
        }
    }

    @Test
    public void signupWithValidRandomDataSucceeds() throws InterruptedException {
        app.welcomeScreen().openEmailSignup();
        app.emailSignupScreen().signup("Test User", "andreas+" + ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE) + "@ludeke.net", "abcd1234");

        assertThat(app.emailSignupScreen().isSignedUp(), is(true));
    }
}
