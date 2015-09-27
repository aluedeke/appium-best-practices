package org.testobject.example.komoot.screen;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class WelcomeScreen {

    private AppiumDriver driver;

    public WelcomeScreen(AppiumDriver driver) {
        this.driver = driver;
    }

    public void openEmailLogin() {
        WebElement loginLink = driver.findElement(By.id("textview_login"));
        loginLink.click();
    }

    public void openEmailSignup() {
        WebElement signupLink = driver.findElement(By.id("textview_mail_register_txt"));
        signupLink.click();
    }
}
