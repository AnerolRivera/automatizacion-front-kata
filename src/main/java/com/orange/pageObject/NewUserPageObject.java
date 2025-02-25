package com.orange.pageObject;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewUserPageObject extends PageObject {


    // Elementos de la página
    private final By btnAdmin = By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']");
    private final By btnAdd = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    private final By btnStatus = By.xpath("//div[contains(@class, 'oxd-select-dropdown')]/div[contains(text(), '')]");
    private final By lstStatus = By.xpath("(//div[contains(@class, 'oxd-select-text--active')])[2]");
    private final By btnUserRole = By.xpath("(//div[contains(@class, 'oxd-select-text--active')])[1]");
    private final By lstUserRole = By.xpath("//div[contains(@class, 'oxd-select-dropdown')]/div[contains(text(), 'Admin')]");
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

    // Método para seleccionar el rol de usuario 'Admin'
    public void selectUserRole(WebDriver driver) {
        // Hacer clic en el selector para abrir las opciones
        WebElement userRoleButton = driver.findElement(getBtnUserRole());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", userRoleButton); // Desplazar al elemento
        userRoleButton.click();

        // Espera explícita para asegurarse de que el menú desplegable esté visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(getLstUserRole())); // Espera que la opción 'Admin' sea visible

        // Ahora seleccionamos la opción 'Admin'
        WebElement adminOption = driver.findElement(getLstUserRole());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", adminOption); // Desplazar al elemento
        adminOption.click();
    }

    // Método para seleccionar el estado
    public void selectStatus(WebDriver driver) {
        WebElement statusButton = driver.findElement(getBtnStatus());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", statusButton); // Desplazar al elemento
        statusButton.click();

        // Espera explícita para asegurarse de que el menú desplegable esté visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(getLstStatus())); // Espera que la opción del estado sea visible

        // Seleccionar el estado
        WebElement statusOption = driver.findElement(getLstStatus());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", statusOption); // Desplazar al elemento
        statusOption.click();
    }

    // Método para llenar el formulario de creación de usuario
    public void fillUserForm(WebDriver driver, String employeeName, String username, String password) {
        // Llenar los campos de formulario
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Espera a que el campo de nombre de empleado esté visible y luego lo llena
        WebElement empNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(getTxtEmployeName()));
        empNameField.sendKeys(employeeName);

        // Espera a que el campo de nombre de usuario esté visible y luego lo llena
        WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(getTxtUserName()));
        userNameField.sendKeys(username);

        // Espera a que el campo de contraseña esté visible y luego lo llena
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(getTxtPassword()));
        passwordField.sendKeys(password);

        // Espera a que el campo de confirmación de contraseña esté visible y luego lo llena
        WebElement confirmPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(getTxtPassword2()));
        confirmPasswordField.sendKeys(password);
    }

    // Método para guardar el usuario
    public void saveUser(WebDriver driver) {
        WebElement saveButton = driver.findElement(getBtnSav());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveButton); // Desplazar al elemento
        saveButton.click();
    }

    // Método para agregar un nuevo usuario
    public void addNewUser(WebDriver driver, String employeeName, String username, String password) {
        // Hacer clic en el botón "Agregar"
        WebElement addButton = driver.findElement(getBtnAdd());
        addButton.click();

        // Llenar el formulario de usuario
        fillUserForm(driver, employeeName, username, password);

        // Seleccionar el rol y el estado
        selectUserRole(driver);
        selectStatus(driver);

        // Guardar el nuevo usuario
        saveUser(driver);
    }

}

