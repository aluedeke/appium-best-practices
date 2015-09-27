package org.testobject.example.komoot.screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;

/**
 * Created by aluedeke on 27.09.15.
 */
public class EmailLoginScreen {

    private AppiumDriver driver;

    @AndroidFindBy(id = "edittext_email")
    private MobileElement emailTextField;

    @AndroidFindBy(id = "edittext_password")
    private MobileElement passwordTextField;

    @AndroidFindBy(id = "button_login")
    private MobileElement loginButton;

    public EmailLoginScreen(AppiumDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        emailTextField.sendKeys(username);
        passwordTextField.sendKeys(password);
        loginButton.click();

        new WebDriverWait(driver, 10).until(invisibilityOfElementLocated(By.tagName("ProgressBar")));
    }

    public boolean isLoggedIn() {
        return driver.findElement(By.id("action_bar_container")).isDisplayed();
    }
}
