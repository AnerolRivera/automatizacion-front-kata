package com.orange.steps;

import com.orange.pageObject.LoginReq2PageObject;
import com.orange.utils.Excel;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;


public class LoginReq2Step {

 public String rutaExcel="src/test/resources/data/Datos.xlsx";
 @Page
 private LoginReq2PageObject homePageReq2;
 private Excel excel;


 @Step("el usuario ingresa a la url")
 public void openUrl() {homePageReq2.openUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");}


 @Step("diligenciar formulario registro")
 public void formulario3() {
  homePageReq2.getDriver().findElement(homePageReq2.getTxtUserName()).sendKeys(Excel.leerDatosExcel(rutaExcel,"Hoja1",3,0));
  homePageReq2.getDriver().findElement(homePageReq2.getTxtPassword()).sendKeys(Excel.leerDatosExcel(rutaExcel,"Hoja1",3,1));


}
 @Step("click boton Login")
 public void clickLogin3() {homePageReq2.getDriver().findElement(homePageReq2.getBtnLogin()).click();}



}

