package org.testobject.example.komoot;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testobject.example.komoot.screen.Komoot;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class AbstractTest {

    protected Komoot app;

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

}
