package com.orange.steps;

import com.orange.pageObject.LoginExitosoPageObject;
import com.orange.utils.Excel;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;


public class LoginExitosoStep {

 public String rutaExcel="src/test/resources/data/Datos.xlsx";
 @Page
 private LoginExitosoPageObject homePageExitoso;



 @Step("el usuario ingresa a la url")
 public void openUrl() {homePageExitoso.openUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");}


 @Step("diligenciar formulario registro")
 public void ingresarCredenciales() {
  homePageExitoso.getDriver().findElement(homePageExitoso.getTxtUserName()).sendKeys(Excel.leerDatosExcel(rutaExcel,"Hoja1",4,0));
  homePageExitoso.getDriver().findElement(homePageExitoso.getTxtPassword()).sendKeys(Excel.leerDatosExcel(rutaExcel,"Hoja1",4,1));

}
 // Paso: presionar el botón de login
 @Step("El usuario presiona el botón login")
 public void presionarBotonLogin() {
  homePageExitoso.getDriver().findElement(homePageExitoso.getBtnLogin()).click();
 }


 // Paso para verificar que el dashboard es visible
 @Step("Verificar que el dashboard es visible")
 public boolean verificarDashboard() {
  return homePageExitoso.verificarDashboardVisible();
 }

}

