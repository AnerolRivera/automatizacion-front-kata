package com.orange.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Scroll {
    public static void scrollElemento (WebDriver driver, By elemento){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        WebElement element = driver.findElement(elemento);
        jse.executeScript("arguments[0].scrollIntoView()", element);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
