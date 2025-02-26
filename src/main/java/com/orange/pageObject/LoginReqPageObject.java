package com.orange.pageObject;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class LoginReqPageObject extends PageObject {


    private final By txtUserName = By.xpath("(//input[@placeholder=\"Username\"])");
    private final By txtPassword = By.xpath("(//input[@placeholder=\"Password\"])");
    private final By btnLogin = By.xpath("(//button[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"])");
    private final By txtRequiredMessage = By.xpath("//span[text()='Required']");

    public By getTxtUserName() { return txtUserName; }
    public By getTxtPassword() { return txtPassword; }
    public By getBtnLogin() { return btnLogin; }
    public By getTxtRequiredMessage() { return txtRequiredMessage; }

    public String obtenerMensajeError() {
        return getDriver().findElement(txtRequiredMessage).getText(); // Obtiene el mensaje 'Required'
    }

    public void login(String username, String password) {
        getDriver().findElement(txtUserName).sendKeys(username);
        getDriver().findElement(txtPassword).sendKeys(password);
        getDriver().findElement(btnLogin).click();
    }


}

