package com.orange.pageObject;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

import static net.serenitybdd.core.Serenity.getDriver;
import static org.openqa.selenium.devtools.v123.fedcm.FedCm.openUrl;

public class LoginInvalidPageObject extends PageObject {



    // Definición de elementos
    private final By txtUserName = By.xpath("//input[@placeholder='Username']");
    private final By txtPassword = By.xpath("//input[@placeholder='Password']");
    private final By btnLogin = By.xpath("//button[@type='submit']");
    private final By txtMensaje = By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");

    // Métodos para obtener los elementos
    public By getTxtUserName() {
        return txtUserName;
    }

    public By getTxtPassword() {
        return txtPassword;
    }

    public By getBtnLogin() {
        return btnLogin;
    }

    public By getTxtMensaje() {
        return txtMensaje;
    }


    // Métodopara realizar login con datos de prueba
    public void login(String username, String password) {
        getDriver().findElement(txtUserName).sendKeys(username);
        getDriver().findElement(txtPassword).sendKeys(password);
        getDriver().findElement(btnLogin).click();
    }

    // Métodopara obtener el mensaje de error
    public String obtenerMensajeError() {
        return getDriver().findElement(txtMensaje).getText();
    }

}







