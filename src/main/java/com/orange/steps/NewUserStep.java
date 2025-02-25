package com.orange.steps;

import com.orange.pageObject.LoginExitosoPageObject;
import com.orange.pageObject.NewUserPageObject;
import com.orange.utils.Excel;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class NewUserStep {

 public String rutaExcel="src/test/resources/data/Datos.xlsx";
 @Page
 private NewUserPageObject NewUser;
 private Excel excel;


 @Step("el usuario ingresa a la url")
 public void openUrl() {NewUser.openUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");}

 @Step("el usuario selecciona la opcion Admin")
 public void Admin(){NewUser.getDriver().findElement(NewUser.getBtnAdmin()).click();}
@Step("el usuario selecciona el botob add")
public void Add() {NewUser.getDriver().findElement(NewUser.getBtnAddn()).click();}

 @Step("diligenciar formulario registro")
 public void formulario4() {

  // Paso 1: Hacer clic en el botón para abrir el menú desplegable
  NewUser.getDriver().findElement(NewUser.getBtnUserRole()).click();

// Paso 2: Esperar explícitamente a que las opciones del menú se muestren
  WebDriverWait wait = new WebDriverWait(NewUser.getDriver(), Duration.ofSeconds(20));
  wait.until(ExpectedConditions.visibilityOfElementLocated(NewUser.getLstUserRole()));

// Paso 3: Hacer clic en la opción 'Admin'
  NewUser.getDriver().findElement(NewUser.getLstUserRole()).click();

  NewUser.getDriver().findElement(NewUser.getTxtEmployeName()).sendKeys(Excel.leerDatosExcel(rutaExcel,"Hoja2",1,0));
  NewUser.getDriver().findElement(NewUser.getLstStatus()).click();
  NewUser.getDriver().findElement(NewUser.getBtnStatus()).click();
  NewUser.getDriver().findElement(NewUser.getTxtUserName()).sendKeys(Excel.leerDatosExcel(rutaExcel,"Hoja2",1,1));
  NewUser.getDriver().findElement(NewUser.getTxtPassword()).sendKeys(Excel.leerDatosExcel(rutaExcel,"Hoja2",1,2));
  NewUser.getDriver().findElement(NewUser.getTxtPassword2()).sendKeys(Excel.leerDatosExcel(rutaExcel,"Hoja2",1,3));

  }
 @Step("click boton save")
 public void clickSave() {NewUser.getDriver().findElement(NewUser.getBtnSav()).click();}

}


