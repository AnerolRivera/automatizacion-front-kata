package com.orange.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EsperaExplicita {
    public static void esperarClick(WebDriver driver, By elementBy) {
        WebDriverWait waitVar = new WebDriverWait(driver, Duration.ofSeconds(60));
        waitVar.until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    public static void esperarElemento(WebDriver driver, By elementBy) {
        WebDriverWait waitVar = new WebDriverWait(driver, Duration.ofSeconds(60));
        waitVar.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    public static void esperarElemento2(WebDriver driver, By elementBy) {
        WebDriverWait waitVar = new WebDriverWait(driver, Duration.ofSeconds(5));
        waitVar.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }
}
