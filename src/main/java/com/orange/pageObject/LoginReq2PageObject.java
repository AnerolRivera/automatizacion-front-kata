package com.orange.pageObject;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class LoginReq2PageObject extends PageObject {


    private final By txtUserName = By.xpath("(//input[@placeholder=\"Username\"])");
    private final By txtPassword = By.xpath("(//input[@placeholder=\"Password\"])");
    private final By btnLogin = By.xpath("(//button[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"])");

    // Selectores para los mensajes de error "Required" de ambos campos
    private final By txtRequiredUserNameMessage = By.xpath("(//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'][normalize-space()='Required'])[1]");  // Mensaje 'Required' para Username
    private final By txtRequiredPasswordMessage = By.xpath("(//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'][normalize-space()='Required'])[2]");  // Mensaje 'Required' para Password

    public By getTxtUserName() { return txtUserName; }
    public By getTxtPassword() { return txtPassword; }
    public By getBtnLogin() { return btnLogin; }
    public By getTxtRequiredUserNameMessage() { return txtRequiredUserNameMessage; }
    public By getTxtRequiredPasswordMessage() { return txtRequiredPasswordMessage; }

    public String obtenerMensajeErrorUserName() {
        return getDriver().findElement(txtRequiredUserNameMessage).getText(); // Obtiene el mensaje 'Required' para Username
    }

    public String obtenerMensajeErrorPassword() {
        return getDriver().findElement(txtRequiredPasswordMessage).getText(); // Obtiene el mensaje 'Required' para Password
    }

    public void login(String username, String password) {
        getDriver().findElement(txtUserName).sendKeys(username);
        getDriver().findElement(txtPassword).sendKeys(password);
        getDriver().findElement(btnLogin).click();
    }


}

