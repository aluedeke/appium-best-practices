package org.testobject.example.komoot.screen;

import io.appium.java_client.AppiumDriver;

public class Komoot {

    private AppiumDriver driver;

    public Komoot(AppiumDriver driver) {
        this.driver = driver;
    }

    public WelcomeScreen welcomeScreen() {
        return new WelcomeScreen(driver);
    }

    public EmailLoginScreen emailLoginScreen() {
        return new EmailLoginScreen(driver);
    }

    public EmailSignupScreen emailSignupScreen() {
        return new EmailSignupScreen(driver);
    }

    public void quit() {
        driver.quit();
    }

}
