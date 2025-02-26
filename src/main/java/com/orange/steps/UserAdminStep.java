package com.orange.steps;

import com.orange.pageObject.UserAdminPageObject;
import com.orange.utils.Excel;
import com.orange.utils.Scroll;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.orange.utils.EsperaExplicita.esperarElemento;
import static com.orange.utils.Scroll.scrollElemento;

public class UserAdminStep {

    public String rutaExcel="src/test/resources/data/Datos.xlsx";


    private UserAdminPageObject userAdmin;
    private Excel excel;
    private Scroll scroll;

    @Step("el usuario ingresa a la url")
    public void openUrl() {userAdmin.openUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");}

    @Step("El usuario selecciona la opción Admin")
    public void Admin() {
        userAdmin.getDriver().findElement(userAdmin.getBtnAdmin()).click();
    }

    @Step("El usuario selecciona el botón Add")
    public void Add() {
        userAdmin.getDriver().findElement(userAdmin.getBtnAdd()).click();
    }


    @Step("diligenciar formulario registro")
    public void formulario1() {

        scrollElemento(userAdmin.getDriver(), userAdmin.getLstUserRole());
        esperarElemento(userAdmin.getDriver(), userAdmin.getLstUserRole());

        // Seleccionar 'User Role' usando el método 'seleccionarCampo'
        seleccionarCampo("User Role", "Admin");  // O "ESS", dependiendo del valor necesario

        scrollElemento(userAdmin.getDriver(), userAdmin.getLstStatus());
        esperarElemento(userAdmin.getDriver(), userAdmin.getLstStatus());

        // Seleccionar 'Status' usando el método 'seleccionarCampo'
        seleccionarCampo("Status", "Enabled");  // O "Disabled", dependiendo del valor necesario

        // Rellenar el resto del formulario

        userAdmin.getDriver().findElement(userAdmin.getLstStatus()).click();
        userAdmin.getDriver().findElement(userAdmin.getBtnStatus()).click();
        userAdmin.getDriver().findElement(userAdmin.getTxtEmployeName()).sendKeys(Excel.leerDatosExcel(rutaExcel,"Hoja2",1,1));
        userAdmin.getDriver().findElement(userAdmin.getTxtUserName()).sendKeys(Excel.leerDatosExcel(rutaExcel,"Hoja2",1,3));
        userAdmin.getDriver().findElement(userAdmin.getTxtPassword()).sendKeys(Excel.leerDatosExcel(rutaExcel,"Hoja2",1,4));
        userAdmin.getDriver().findElement(userAdmin.getTxtPassword2()).sendKeys(Excel.leerDatosExcel(rutaExcel,"Hoja2",1,5));;
        userAdmin.getDriver().findElement(userAdmin.getBtnSav()).click();

    }
    public void seleccionarCampo(String campo, String opcion) {
        // Desplegar el campo de selección utilizando el texto visible del campo (como User Role o Status)
        WebElement campoDropdown = userAdmin.getDriver().findElement(
                By.xpath("//label[text()='" + campo + "']/ancestor::div[@class='oxd-input-group']//div[contains(@class, 'oxd-select-wrapper')]"));
        campoDropdown.click();  // Hacer clic para desplegar el menú

        // Esperar a que las opciones estén disponibles
        WebDriverWait wait = new WebDriverWait(userAdmin.getDriver(), Duration.ofSeconds(10));
        WebElement opcionDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class, 'oxd-select-dropdown')]//span[text()='" + opcion + "']")
        ));

        // Seleccionar la opción deseada
        opcionDropdown.click();
    }




}
