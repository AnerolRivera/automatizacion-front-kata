package com.orange.pageObject;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginExitosoPageObject extends PageObject {


    private final By txtUserName = By.xpath("//input[@placeholder='Username']");
    private final By txtPassword = By.xpath("//input[@placeholder='Password']");
    private final By btnLogin = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");
    private final By dashboardTitle = By.xpath("(//div[@class='oxd-topbar-header'])[1]");

    // Métodos para obtener los elementos
    public By getTxtUserName() { return txtUserName; }
    public By getTxtPassword() { return txtPassword; }
    public By getBtnLogin() { return btnLogin; }
    public By getDashboardTitle() { return dashboardTitle; }

    // Métodopara realizar el login
    public void realizarLogin(String username, String password) {
        getDriver().findElement(txtUserName).sendKeys(username);
        getDriver().findElement(txtPassword).sendKeys(password);
        getDriver().findElement(btnLogin).click();
    }

    // Verificar si el login fue exitoso
    public boolean verificarDashboardVisible() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10)); // Usamos Duration.ofSeconds en lugar de un int
        WebElement dashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardTitle));
        return dashboard.isDisplayed();
    }


}

