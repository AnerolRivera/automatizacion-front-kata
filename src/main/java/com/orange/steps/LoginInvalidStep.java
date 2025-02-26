package com.orange.steps;

import com.orange.pageObject.LoginInvalidPageObject;
import com.orange.utils.Excel;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

import static org.openqa.selenium.devtools.v122.fedcm.FedCm.openUrl;


public class LoginInvalidStep {

 public String rutaExcel="src/test/resources/data/Datos.xlsx";
 private LoginInvalidPageObject loginPage;

 @Step("el usuario ingresa a la url")
 public void openUrl() {loginPage.openUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");}


 // Paso: ingresar credenciales incorrectas
 @Step("El usuario ingresa un nombre de usuario y una contraseña incorrectos")
 public void ingresarCredencialesIncorrectas() {
  loginPage.getDriver().findElement(loginPage.getTxtUserName()).sendKeys(Excel.leerDatosExcel(rutaExcel,"Hoja1",1,0));
  loginPage.getDriver().findElement(loginPage.getTxtPassword()).sendKeys(Excel.leerDatosExcel(rutaExcel,"Hoja1",1,1));
 }
 // Paso: presionar el botón de login
 @Step("El usuario presiona el botón login")
 public void presionarBotonLogin() {
  loginPage.getDriver().findElement(loginPage.getBtnLogin()).click();
 }

 // Paso: verificar que el mensaje de error sea correcto
 @Step("El sistema debe mostrar el mensaje {0}")
 public void verificarMensajeError(String mensajeEsperado) {
  String mensajeError = loginPage.obtenerMensajeError();
  // Validar que el mensaje de error contiene el texto esperado
  if (!mensajeError.contains(mensajeEsperado)) {
   throw new AssertionError("Se esperaba el mensaje de error: " + mensajeEsperado + " pero se obtuvo: " + mensajeError);
  }
 }

}

