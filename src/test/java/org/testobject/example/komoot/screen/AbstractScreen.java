package org.testobject.example.komoot.screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;

public abstract class AbstractScreen {

    protected AppiumDriver driver;

    public AbstractScreen(AppiumDriver driver){
        this.driver = driver;

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    <T> T waitUntil(ExpectedCondition<T> condition){
        return new WebDriverWait(driver, 10).until(condition);
    }

    ExpectedCondition<Boolean> loaded(){
        return invisibilityOfElementLocated(By.tagName("ProgressBar"));
    }
}
