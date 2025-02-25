package com.orange.steps;

import com.orange.pageObject.LoginReqPageObject;
import com.orange.utils.Excel;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;


public class LoginReqStep {

 public String rutaExcel="src/test/resources/data/Datos.xlsx";
 @Page
 private LoginReqPageObject homePageReq;
 private Excel excel;


 @Step("el usuario ingresa a la url")
 public void openUrl() {homePageReq.openUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");}


 @Step("diligenciar formulario registro")
 public void formulario2() {
  homePageReq.getDriver().findElement(homePageReq.getTxtUserName()).sendKeys(Excel.leerDatosExcel(rutaExcel,"Hoja1",2,0));
  homePageReq.getDriver().findElement(homePageReq.getTxtPassword()).sendKeys(Excel.leerDatosExcel(rutaExcel,"Hoja1",2,1));


}
 @Step("click boton Login")
 public void clickLogin2() {homePageReq.getDriver().findElement(homePageReq.getBtnLogin()).click();}



}

