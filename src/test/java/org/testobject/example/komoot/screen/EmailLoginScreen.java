package org.testobject.example.komoot.screen;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.By.id;

/**
 * Created by aluedeke on 27.09.15.
 */
public class EmailLoginScreen {

    private AppiumDriver driver;

    public EmailLoginScreen(AppiumDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        WebElement emailTextField = driver.findElement(By.id("edittext_email"));
        emailTextField.sendKeys(username);

        WebElement passwordTextField = driver.findElement(By.id("edittext_password"));
        passwordTextField.sendKeys(password);

        WebElement loginButton = driver.findElement(By.id("button_login"));
        loginButton.click();

        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.tagName("ProgressBar")));
    }

    public boolean isLoggedIn() {
        return driver.findElement(By.id("action_bar_container")).isDisplayed();
    }
}
