package com.orange.pageObject;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewUserPageObject extends PageObject {


    private final By btnAdmin = By.xpath("//a[@href=\"/web/index.php/admin/viewAdminModule\"]");
    public By getBtnAdmin() {
        return btnAdmin;
    }
    private final By btnAdd = By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]");
    public By getBtnAddn() {
        return btnAdd;
    }
    private final By btnStatus = By.xpath("//div[contains(@class, 'oxd-select-dropdown')]/div[contains(text(), '')]");
    private final By lstStatus = By.xpath("(//div[contains(@class, 'oxd-select-text--active')])[2]\n");

    public By getLstStatus() {
        return btnStatus;
    }

    public By getBtnStatus() {
        return btnStatus;
    }

    private final By btnUserRole = By.xpath("(//div[contains(@class, 'oxd-select-text--active')])[1]");
    private final By lstUserRole = By.xpath("//div[contains(@class, 'oxd-select-dropdown')]/div[contains(text(), 'Admin')]");

    // Método para obtener el botón del selector de rol
    public By getBtnUserRole() {
        return btnUserRole;
    }

    // Método para obtener la opción específica del rol 'Admin'
    public By getLstUserRole() {
        return lstUserRole;
    }

       public void selectUserRole(WebDriver driver) {
        // Hacer clic en el selector para abrir las opciones
        WebElement userRoleButton = driver.findElement(getBtnUserRole());
        userRoleButton.click();

        // Espera explícita para asegurarse de que el menú desplegable esté visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(getLstUserRole())); // Espera que la opción 'Admin' sea visible

        // Ahora seleccionamos la opción 'Admin'
        WebElement adminOption = driver.findElement(getLstUserRole());
        adminOption.click();
    }

    private final By txtEmployeName = By.xpath("(//div[@class=\"oxd-autocomplete-text-input oxd-autocomplete-text-input--active\"])");
    public By getTxtEmployeName() {
        return txtEmployeName;
    }

    private final By txtUserName = By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])");
    public By getTxtUserName() {
        return txtUserName;
    }

    private final By txtPassword = By.xpath("(//input[@type=\"password\"])");

    public By getTxtPassword() {return txtPassword;}

    private final By txtPassword2 = By.xpath("(//input[@type=\"password\"])");

    public By getTxtPassword2() {return txtPassword2;}

    private final  By btnSav = By.xpath("(//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"])");

    public By getBtnSav() {
        return btnSav;
    }

}

