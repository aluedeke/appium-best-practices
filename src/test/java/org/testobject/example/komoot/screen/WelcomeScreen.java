package org.testobject.example.komoot.screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class WelcomeScreen {

    @AndroidFindBy(id = "textview_login")
    private MobileElement loginLink;

    @AndroidFindBy(id = "textview_mail_register_txt")
    private MobileElement signupLink;

    private AppiumDriver driver;

    public WelcomeScreen(AppiumDriver driver) {
        this.driver = driver;
    }

    public void openEmailLogin() {
        loginLink.click();
    }

    public void openEmailSignup() {
        signupLink.click();
    }
}
