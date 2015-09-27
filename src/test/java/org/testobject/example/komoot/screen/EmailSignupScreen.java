package org.testobject.example.komoot.screen;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.ThreadLocalRandom;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;

/**
 * Created by aluedeke on 27.09.15.
 */
public class EmailSignupScreen {

    private AppiumDriver driver;

    public EmailSignupScreen(AppiumDriver driver) {

        this.driver = driver;
    }

    public void signup(String displayName, String email, String password) {
        driver.hideKeyboard();

        WebElement displayNameTextField = driver.findElement(By.id("edittext_display_name"));
        displayNameTextField.sendKeys(displayName);

        driver.hideKeyboard();

        WebElement emailTextField = driver.findElement(By.id("edittext_email"));
        emailTextField.sendKeys(email);

        driver.hideKeyboard();

        WebElement passwordTextField = driver.findElement(By.id("edittext_password"));
        passwordTextField.sendKeys(password);

        driver.hideKeyboard();

        WebElement signupButton = driver.findElement(By.id("button_register"));
        signupButton.click();

        new WebDriverWait(driver, 10).until(invisibilityOfElementLocated(By.tagName("ProgressBar")));
    }

    public boolean isSignedUp() {
        return driver.findElement(By.id("textview_header_title")).isDisplayed();
    }
}
