package com.orange.pageObject;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewUserPageObject extends PageObject {

    private WebDriver driver;  // Campo para el WebDriver
    // Elementos de la página
    private final By adminTab = By.xpath("(//a[@class='oxd-main-menu-item active toggle']");  // Selector corregido
    private final By btnAdd = By.xpath("(//button[normalize-space()='Add'])[1]");  // Botón de 'Add'
    private final By userRoleDropdown = By.xpath("((//div[@class='oxd-select-text oxd-select-text--active'])[1]"); // Selector dropdown User Role
    private final By statusDropdown = By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]"); // Selector dropdown Status
    private final By employeeNameField = By.xpath("(//input[@placeholder='Type for hints...'])[1]");  // Campo Employee Name
    private final By usernameField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");  // Campo Username
    private final By passwordField = By.xpath("(//input[@type='password'])[1]");  // Campo Password
    private final By confirmPasswordField = By.xpath("(//input[@type='password'])[2]");  // Campo Confirm Password
    private final By saveButton = By.xpath("(//button[normalize-space()='Save'])[1]");  // Botón Save

    // Constructor para inicializar el WebDriver
    public NewUserPageObject(WebDriver driver) {
        this.driver = driver;
    }
    // Métodos para obtener los elementos
    public By getAdminTab() { return adminTab; }
    public By getBtnAdd() { return btnAdd; }
    public By getUserRoleDropdown() { return userRoleDropdown; }
    public By getStatusDropdown() { return statusDropdown; }
    public By getEmployeeNameField() { return employeeNameField; }
    public By getUsernameField() { return usernameField; }
    public By getPasswordField() { return passwordField; }
    public By getConfirmPasswordField() { return confirmPasswordField; }
    public By getSaveButton() { return saveButton; }

    // Métodopara navegar al formulario de Admin
    public void navegarAlFormularioDeAdmin() {
        WebDriver driver = getDriver();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(getAdminTab()));
        driver.findElement(getAdminTab()).click();
    }

    // Métodopara agregar un nuevo usuario
    public void agregarNuevoUsuario(String nombre) {
        WebDriver driver = getDriver();

        // Espera explícita para asegurarse de que el botón 'Add' esté visible
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(getBtnAdd()));
        driver.findElement(getBtnAdd()).click();  // Clic en el botón 'Add'

        // Esperar a que los campos estén disponibles antes de completar el formulario
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(getUserRoleDropdown()));

        // Completar el formulario de nuevo usuario
        // Completar el formulario de nuevo usuario con Select para dropdowns
        Select roleSelect = new Select(driver.findElement(getUserRoleDropdown()));
        roleSelect.selectByVisibleText("Admin");  // Seleccionamos "Admin" como User Role

        Select statusSelect = new Select(driver.findElement(getStatusDropdown()));
        statusSelect.selectByVisibleText("Enabled");  // Seleccionamos "Enabled" como Status

        driver.findElement(getEmployeeNameField()).sendKeys(nombre);  // Nombre del empleado (el nombre que pasa como parámetro)
        driver.findElement(getUsernameField()).sendKeys("1" + nombre + "1234");  // Username
        driver.findElement(getPasswordField()).sendKeys(nombre + "123");  // Password
        driver.findElement(getConfirmPasswordField()).sendKeys(nombre + "123");  // Confirm Password

        // Hacer clic en el botón Save
        driver.findElement(getSaveButton()).click();
    }
}

