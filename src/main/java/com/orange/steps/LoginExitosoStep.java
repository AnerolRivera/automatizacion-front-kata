package com.orange.steps;

import com.orange.pageObject.LoginExitosoPageObject;
import com.orange.utils.Excel;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;


public class LoginExitosoStep {

 public String rutaExcel="src/test/resources/data/Datos.xlsx";
 @Page
 private LoginExitosoPageObject homePageExitoso;
 private Excel excel;


 @Step("el usuario ingresa a la url")
 public void openUrl() {homePageExitoso.openUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");}


 @Step("diligenciar formulario registro")
 public void formulario() {
  homePageExitoso.getDriver().findElement(homePageExitoso.getTxtUserName()).sendKeys(Excel.leerDatosExcel(rutaExcel,"Hoja1",4,0));
  homePageExitoso.getDriver().findElement(homePageExitoso.getTxtPassword()).sendKeys(Excel.leerDatosExcel(rutaExcel,"Hoja1",4,1));

}
 @Step("click boton Login")
 public void clickLogin4() {homePageExitoso.getDriver().findElement(homePageExitoso.getBtnLogin()).click();}



}

