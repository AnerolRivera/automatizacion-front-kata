package com.orange.stepDefinitions;

import com.orange.steps.LoginExitosoStep;
import com.orange.steps.NewUserStep;
import com.orange.steps.UserAdminStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.openqa.selenium.WebDriver;

public class UserAdmin {

    @Managed
    WebDriver driver;  // WebDriver gestionado por Serenity

    @Steps
    private LoginExitosoStep homeStepsExitoso;  // Clase de pasos para login

    @Steps
    private UserAdminStep userAdmin;  // Clase de pasos para el nuevo usuario


    @After
    public void tearDown() {
        // Cerramos el WebDriver después de cada prueba
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("El usuario se loguea correctamente en la aplicación")
    public void elUsuarioSeLogueaCorrectamenteEnLaAplicación() {
        // Abre la URL de login utilizando el método del Step
        homeStepsExitoso.openUrl();

        // Diligencia el formulario de login utilizando los métodos del Step
        homeStepsExitoso.ingresarCredenciales();

        // Da clic en el botón de login
        homeStepsExitoso.presionarBotonLogin();

    }
    @Given("El usuario selecciona en el menu la opcion Admin")
    public void elUsuarioSeleccionaEnElMenuLaOpcionAdmin() {
        userAdmin.Admin();

    }
    @Given("El usuario da clic en el boton Add")
    public void elUsuarioDaClicEnElBotonAdd() {
        userAdmin.Add();
    }
    @When("El usuario registra los datos requeridos en el formulario")
    public void elUsuarioRegistraLosDatosRequeridosEnElFormulario() {
       userAdmin.formulario1();
    }
    @Then("El sistema guarda el nuevo usuario")
    public void elSistemaGuardaElNuevoUsuario() {

    }

}
