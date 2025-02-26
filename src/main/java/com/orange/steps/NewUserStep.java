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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.orange.utils.EsperaExplicita.esperarElemento;
import static com.orange.utils.Scroll.scrollElemento;
import static net.serenitybdd.core.Serenity.getDriver;


public class NewUserStep {


 private WebDriver driver;  // Campo para el WebDriver
 public NewUserPageObject newUserPageObject;  // Página de Admin donde se gestionan los usuarios

 // Método para establecer el WebDriver
 public void setDriver(WebDriver driver) {
  this.driver = driver;
  this.newUserPageObject = new NewUserPageObject(driver);  // Se inicializa el Page Object con el WebDriver
 }

 // Paso para navegar al formulario de Admin
 @Step
 public void navegarAlFormularioDeAdmin() {

  // Espera hasta que un modal desaparezca si es necesario
  new WebDriverWait(driver, Duration.ofSeconds(10))
          .until(ExpectedConditions.invisibilityOfElementLocated(By.id("modalId")));  // Ajusta el id si hay un modal bloqueando

  // Espera explícita para asegurarse de que el tab Admin sea visible y clickeable
  new WebDriverWait(driver, Duration.ofSeconds(15))
          .until(ExpectedConditions.visibilityOfElementLocated(newUserPageObject.getAdminTab()));

  new WebDriverWait(driver, Duration.ofSeconds(15))
          .until(ExpectedConditions.elementToBeClickable(newUserPageObject.getAdminTab()));  // Asegura que el tab Admin sea clickeable

  // Clic en el tab Admin
  driver.findElement(newUserPageObject.getAdminTab()).click();
 }

 // Paso para agregar un nuevo usuario
 @Step
 public void agregarNuevoUsuario(String nombre) {
  // Espera explícita para asegurarse de que el botón 'Add' esté disponible antes de hacer clic
  new WebDriverWait(driver, Duration.ofSeconds(10))
          .until(ExpectedConditions.elementToBeClickable(newUserPageObject.getBtnAdd()));

  // Clic en el botón 'Add' para agregar un nuevo usuario
  driver.findElement(newUserPageObject.getBtnAdd()).click();

  // Completa los campos para el nuevo usuario
  newUserPageObject.agregarNuevoUsuario(nombre);
 }

 // Verifica si el usuario está en la lista de usuarios
 public boolean verificarUsuarioEnLista(String nombreUsuario) {
  // Espera explícita para asegurarse de que la lista de usuarios esté visible
  new WebDriverWait(driver, Duration.ofSeconds(10))
          .until(ExpectedConditions.visibilityOfElementLocated(By.id("userList")));  // Ajusta el id si es necesario

  // Busca el nombre del usuario en la lista de usuarios
  List<WebElement> usuarios = driver.findElements(By.xpath("//table//tr//td[contains(text(), '" + nombreUsuario + "')]"));

  // Verifica si el nombre del usuario existe en la lista
  return !usuarios.isEmpty();  // Devuelve true si el usuario está en la lista
 }
  }

