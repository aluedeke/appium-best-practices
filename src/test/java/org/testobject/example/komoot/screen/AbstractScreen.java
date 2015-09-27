package org.testobject.example.komoot.screen;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 * Created by aluedeke on 27.09.15.
 */
public abstract class AbstractScreen {

    protected AppiumDriver driver;

    public AbstractScreen(AppiumDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    <T> T waitUntil(ExpectedCondition<T> condition){
        return new WebDriverWait(driver, 10).until(condition);
    }

    ExpectedCondition<Boolean> loaded(){
        return invisibilityOfElementLocated(By.tagName("ProgressBar"));
    }
}
