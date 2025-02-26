package com.orange.steps;

import com.orange.pageObject.LoginReq2PageObject;
import com.orange.pageObject.LoginReqPageObject;
import com.orange.utils.Excel;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;


public class LoginReq2Step {


 private LoginReq2PageObject homePageReq2;

 public String rutaExcel="src/test/resources/data/Datos.xlsx";


 @Step("el usuario ingresa a la url")
 public void openUrl() {homePageReq2.openUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");}


 // Paso: ingresar credenciales incorrectas
 @Step("El usuario deja el campo de nombre de usuario vacío y coloca una contraseña")
 public void dejarCamposVacios() {
  homePageReq2.getDriver().findElement(homePageReq2.getTxtUserName()).sendKeys(Excel.leerDatosExcel(rutaExcel,"Hoja1",3,0));
  homePageReq2.getDriver().findElement(homePageReq2.getTxtPassword()).sendKeys(Excel.leerDatosExcel(rutaExcel,"Hoja1",3,1));
 }
 // Paso: presionar el botón de login
 @Step("El usuario presiona el botón login")
 public void presionarBotonLogin() {
  homePageReq2.getDriver().findElement(homePageReq2.getBtnLogin()).click();
 }
 // Paso: verificar que el mensaje de error "Required" aparece en Username
 @Step("El sistema debe mostrar el mensaje 'Required' en el campo Username")
 public void verificarMensajeRequiredUserName() {
  String mensajeError = homePageReq2.obtenerMensajeErrorUserName();
  // Validar que el mensaje de error contiene el texto esperado "Required"
  if (!mensajeError.equals("Required")) {
   throw new AssertionError("Se esperaba el mensaje 'Required' en Username, pero se obtuvo: " + mensajeError);
  }
 }

 // Paso: verificar que el mensaje de error "Required" aparece en Password
 @Step("El sistema debe mostrar el mensaje 'Required' en el campo Password")
 public void verificarMensajeRequiredPassword() {
  String mensajeError = homePageReq2.obtenerMensajeErrorPassword();
  // Validar que el mensaje de error contiene el texto esperado "Required"
  if (!mensajeError.equals("Required")) {
   throw new AssertionError("Se esperaba el mensaje 'Required' en Password, pero se obtuvo: " + mensajeError);
  }
 }

}

