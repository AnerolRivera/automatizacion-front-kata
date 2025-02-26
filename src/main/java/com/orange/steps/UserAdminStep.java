package com.orange.steps;

import com.orange.pageObject.UserAdminPageObject;
import com.orange.utils.Excel;
import com.orange.utils.Scroll;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import static com.orange.utils.EsperaExplicita.esperarElemento;
import static com.orange.utils.Scroll.scrollElemento;

public class UserAdmin {

    public String rutaExcel="src/test/resources/data/Datos.xlsx";


    private UserAdminPageObject userAdmin;
    private Excel excel;
    private Scroll scroll;

    @Step("el usuario ingresa a la url")
    public void openUrl() {userAdmin.openUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");}

    @Step("diligenciar formulario registro")
    public void formulario1() {
        userAdmin.getDriver().findElement(userAdmin.getBtnAdmin()).click();
        userAdmin.getDriver().findElement(userAdmin.getBtnAdd()).click();
        scrollElemento(userAdmin.getDriver(),userAdmin.getLstUserRole());
        esperarElemento(userAdmin.getDriver(),userAdmin.getLstUserRole());
        userAdmin.getDriver().findElement(userAdmin.getLstUserRole()).click();
        userAdmin.getDriver().findElement(userAdmin.getBtnUserRole()).click();
        scrollElemento(userAdmin.getDriver(),userAdmin.getLstStatus());
        esperarElemento(userAdmin.getDriver(),userAdmin.getLstStatus());
        userAdmin.getDriver().findElement(userAdmin.getLstStatus()).click();
        userAdmin.getDriver().findElement(userAdmin.getBtnStatus()).click();
        userAdmin.getDriver().findElement(userAdmin.getTxtEmployeName()).sendKeys(Excel.leerDatosExcel(rutaExcel,"Hoja2",1,1));
        userAdmin.getDriver().findElement(userAdmin.getTxtUserName()).sendKeys(Excel.leerDatosExcel(rutaExcel,"Hoja2",1,3));
        userAdmin.getDriver().findElement(userAdmin.getTxtPassword()).sendKeys(Excel.leerDatosExcel(rutaExcel,"Hoja2",1,4));
        userAdmin.getDriver().findElement(userAdmin.getTxtPassword2()).sendKeys(Excel.leerDatosExcel(rutaExcel,"Hoja2",1,5));;
        userAdmin.getDriver().findElement(userAdmin.getBtnSav()).click();

    }

}
