package com.orange.pageObject;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class UserAdminPageObject extends PageObject {
    // Elementos de la página
    private final By btnAdmin = By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']");
    private final By btnAdd = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    private final By lstUserRole = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]");
    private final By btnUserRole = By.xpath("(//div[contains(@class=oxd-select-text-input)]//span[text()='Admin'])");
    private final By lstStatus = By.xpath("((//div[@class='oxd-select-text oxd-select-text--active'])[2]");
    private final By btnStatus = By.xpath("(//div[contains(@class=oxd-select-text-input)]//span[text()='Enable'])");
    private final By txtEmployeName = By.xpath("(//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active'])");
    private final By txtUserName = By.xpath("(//input[@class='oxd-input oxd-input--active'])");
    private final By txtPassword = By.xpath("(//input[@type='password'])[1]");
    private final By txtPassword2 = By.xpath("(//input[@type='password'])[2]");
    private final By btnSav = By.xpath("(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])");

    // Métodos para obtener los elementos
    public By getBtnAdmin() {
        return btnAdmin;
    }

    public By getBtnAdd() {
        return btnAdd;
    }

    public By getBtnStatus() {
        return btnStatus;
    }

    public By getLstStatus() {
        return lstStatus;
    }

    public By getBtnUserRole() {
        return btnUserRole;
    }

    public By getLstUserRole() {
        return lstUserRole;
    }

    public By getTxtEmployeName() {
        return txtEmployeName;
    }

    public By getTxtUserName() {
        return txtUserName;
    }

    public By getTxtPassword() {
        return txtPassword;
    }

    public By getTxtPassword2() {
        return txtPassword2;
    }

    public By getBtnSav() {
        return btnSav;
    }
}
