package com.orange.steps;

import com.orange.pageObject.LoginExitosoPageObject;
import com.orange.pageObject.NewUserPageObject;
import com.orange.utils.Excel;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class NewUserStep {

 public String rutaExcel = "src/test/resources/data/Datos.xlsx";
 @Page
 private NewUserPageObject NewUser;
 private Excel excel;

 @Step("El usuario ingresa a la URL")
 public void openUrl() {
  NewUser.openUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
 }

 @Step("El usuario selecciona la opción Admin")
 public void Admin() {
  NewUser.getDriver().findElement(NewUser.getBtnAdmin()).click();
 }

 @Step("El usuario selecciona el botón Add")
 public void Add() {
  NewUser.getDriver().findElement(NewUser.getBtnAdd()).click();
 }

 @Step("Diligenciar formulario de registro")
 public void formulario4() {
  WebDriver driver = NewUser.getDriver();

  // Paso 1: Hacer clic en el botón para abrir el menú desplegable de roles
  WebElement userRoleButton = driver.findElement(NewUser.getBtnUserRole());
  userRoleButton.click();

  // Paso 2: Esperar explícitamente a que las opciones del menú se muestren
  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
  wait.until(ExpectedConditions.visibilityOfElementLocated(NewUser.getLstUserRole()));

  // Paso 3: Hacer clic en la opción 'Admin'
  WebElement adminOption = driver.findElement(NewUser.getLstUserRole());
  adminOption.click();

  // Paso 4: Rellenar los campos con los datos del Excel
  String employeeName = Excel.leerDatosExcel(rutaExcel, "Hoja2", 1, 0);
  String userName = Excel.leerDatosExcel(rutaExcel, "Hoja2", 1, 1);
  String password = Excel.leerDatosExcel(rutaExcel, "Hoja2", 1, 2);
  String confirmPassword = Excel.leerDatosExcel(rutaExcel, "Hoja2", 1, 3);

  // Ingresar los datos en el formulario
  driver.findElement(NewUser.getTxtEmployeName()).sendKeys(employeeName);

  // Seleccionar el estado (si es necesario)
  driver.findElement(NewUser.getLstStatus()).click();
  WebElement statusOption = driver.findElement(NewUser.getBtnStatus());
  statusOption.click();

  // Ingresar nombre de usuario y contraseñas
  driver.findElement(NewUser.getTxtUserName()).sendKeys(userName);
  driver.findElement(NewUser.getTxtPassword()).sendKeys(password);
  driver.findElement(NewUser.getTxtPassword2()).sendKeys(confirmPassword);
 }

 @Step("Hacer clic en el botón Save")
 public void clickSave() {
  WebDriver driver = NewUser.getDriver();

  // Esperar explícitamente a que el botón Save esté visible
  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
  wait.until(ExpectedConditions.elementToBeClickable(NewUser.getBtnSav()));

  // Hacer clic en el botón Save
  driver.findElement(NewUser.getBtnSav()).click();
 }
}

