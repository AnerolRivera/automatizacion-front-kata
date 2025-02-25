package com.orange.steps;

import com.orange.pageObject.LoginInvalidPageObject;
import com.orange.utils.Excel;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;


public class LoginInvalidStep {

 public String rutaExcel="src/test/resources/data/Datos.xlsx";
 @Page
 private LoginInvalidPageObject homePage;
 private Excel excel;


 @Step("el usuario ingresa a la url")
 public void openUrl() {homePage.openUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");}


 @Step("diligenciar formulario registro")
 public void formulario1() {
  homePage.getDriver().findElement(homePage.getTxtUserName()).sendKeys(Excel.leerDatosExcel(rutaExcel,"Hoja1",1,0));
  homePage.getDriver().findElement(homePage.getTxtPassword()).sendKeys(Excel.leerDatosExcel(rutaExcel,"Hoja1",1,1));

}
 @Step("click boton Login")
 public void clickLogin() {homePage.getDriver().findElement(homePage.getBtnLogin()).click();}



}

