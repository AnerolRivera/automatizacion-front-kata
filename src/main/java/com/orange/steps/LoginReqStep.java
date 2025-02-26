package com.orange.steps;

import com.orange.pageObject.LoginInvalidPageObject;
import com.orange.pageObject.LoginReqPageObject;
import com.orange.utils.Excel;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;


public class LoginReqStep {

 public String rutaExcel="src/test/resources/data/Datos.xlsx";
 private LoginReqPageObject loginPageR;

 @Step("el usuario ingresa a la url")
 public void openUrl() {loginPageR.openUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");}


 // Paso: ingresar credenciales incorrectas
 @Step("El usuario deja el campo de nombre de usuario vacío y coloca una contraseña")
 public void ingresarSoloContraseña() {
  loginPageR.getDriver().findElement(loginPageR.getTxtUserName()).sendKeys(Excel.leerDatosExcel(rutaExcel,"Hoja1",2,0));
  loginPageR.getDriver().findElement(loginPageR.getTxtPassword()).sendKeys(Excel.leerDatosExcel(rutaExcel,"Hoja1",2,1));
 }
 // Paso: presionar el botón de login
 @Step("El usuario presiona el botón login")
 public void presionarBotonLogin() {
  loginPageR.getDriver().findElement(loginPageR.getBtnLogin()).click();
 }
 // Paso: verificar que el mensaje de error "Required" aparece
 @Step("El sistema debe mostrar el mensaje 'Required'")
 public void verificarMensajeRequired() {
  String mensajeError = loginPageR.obtenerMensajeError();
  // Validar que el mensaje de error contiene el texto esperado "Required"
  if (!mensajeError.equals("Required")) {
   throw new AssertionError("Se esperaba el mensaje 'Required' pero se obtuvo: " + mensajeError);
  }
 }

}

