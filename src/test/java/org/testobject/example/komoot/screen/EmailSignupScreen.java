package org.testobject.example.komoot.screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.testobject.example.komoot.data.User;

public class EmailSignupScreen extends AbstractScreen {

    @AndroidFindBy(id = "edittext_display_name")
    private MobileElement displayNameTextField;

    @AndroidFindBy(id = "edittext_email")
    private MobileElement emailTextField;

    @AndroidFindBy(id = "edittext_password")
    private MobileElement passwordTextField;

    @AndroidFindBy(id = "button_register")
    private MobileElement signupButton;

    public EmailSignupScreen(AppiumDriver driver) {
        super(driver);
    }

    public void signup(User user) {
        driver.hideKeyboard();

        displayNameTextField.sendKeys(user.displayName);

        driver.hideKeyboard();

        emailTextField.sendKeys(user.email);

        driver.hideKeyboard();

        passwordTextField.sendKeys(user.password);

        driver.hideKeyboard();

        signupButton.click();

        waitUntil(loaded());
    }

    public boolean isSignedUp() {
        return driver.findElement(By.id("textview_header_title")).isDisplayed();
    }
}
