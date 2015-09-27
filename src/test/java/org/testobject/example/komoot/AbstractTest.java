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

    private static final String APPIUM_SERVER_URL = getEnvOrUseDefault("APPIUM_SERVER", "http://127.0.0.1:4723/wd/hub");
    private static final String APK_FILE_PATH = getEnvOrUseDefault("APK_FILE_PATH", "src/test/resources/komoot.apk");

    protected Komoot app;

    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.SELENDROID);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "nexus5");
        capabilities.setCapability(MobileCapabilityType.APP, new File(APK_FILE_PATH).getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.APP_WAIT_ACTIVITY, "de.komoot.android.app.JoinKomootActivity");

        app = new Komoot(new AndroidDriver(new URL(APPIUM_SERVER_URL), capabilities));
    }

    @After
    public void tearDown(){
        if(app != null) {
            app.quit();
        }
    }

    private static final String getEnvOrUseDefault(String envName, String def){
        return System.getenv(envName) != null ? System.getenv(envName) : def;
    }

}
