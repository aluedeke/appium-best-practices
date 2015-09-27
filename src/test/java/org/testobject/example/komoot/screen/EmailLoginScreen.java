package org.testobject.example.komoot.screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class EmailLoginScreen extends AbstractScreen {

    @AndroidFindBy(id = "edittext_email")
    private MobileElement emailTextField;

    @AndroidFindBy(id = "edittext_password")
    private MobileElement passwordTextField;

    @AndroidFindBy(id = "button_login")
    private MobileElement loginButton;

    public EmailLoginScreen(AppiumDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        emailTextField.sendKeys(username);
        passwordTextField.sendKeys(password);
        loginButton.click();

        waitUntil(loaded());
    }

    public boolean isLoggedIn() {
        return driver.findElement(By.id("action_bar_container")).isDisplayed();
    }
}
