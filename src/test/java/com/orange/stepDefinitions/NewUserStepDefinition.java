package com.orange.stepDefinitions;

import com.orange.steps.LoginExitosoStep;
import com.orange.steps.NewUserStep;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class NewUserStepDefinition {

    WebDriver driver;
    NewUserStep newUserStep;
    @Steps
    private LoginExitosoStep homeStepsExitoso;  // Clase de pasos para login

    @Before
    public void setup() {
        // Configurar WebDriver
        WebDriverManager.chromedriver().clearDriverCache().setup();
        driver = new ChromeDriver();

        // Inicializar NewUserStep
        newUserStep = new NewUserStep();
        newUserStep.setDriver(driver);  // Enlazamos el WebDriver con la página de Admin
    }

    @After
    public void tearDown() {
        // Cerrar el navegador después de cada prueba
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("El usuario está logueado correctamente en la aplicación")
    public void elUsuarioEstaLogueadoCorrectamente() {
        // Abre la URL de login utilizando el método del Step
        homeStepsExitoso.openUrl();

        // Diligencia el formulario de login utilizando los métodos del Step
        homeStepsExitoso.ingresarCredenciales();

        // Da clic en el botón de login
        homeStepsExitoso.presionarBotonLogin();

    }

    @When("El usuario navega a la sección de Admin y agrega un nuevo usuario con el nombre {string}")
    public void elUsuarioAgregaNuevoUsuario(String nombre) {
        // Navegar a la sección de Admin y agregar el nuevo usuario
        newUserStep.navegarAlFormularioDeAdmin();
        newUserStep.agregarNuevoUsuario(nombre);  // Pasamos el nombre para completar los campos
    }


    @Then("El sistema debe guardar el nuevo usuario y mostrarlo en la lista de usuarios")
    public void elSistemaDebeMostrarElNuevoUsuario() {
        // Aquí llamamos un método para verificar que el nuevo usuario está en la lista
        boolean usuarioCreado = newUserStep.verificarUsuarioEnLista("1" + "nombre" + "1234");  // Nombre esperado

        // Aserción para validar si el nuevo usuario fue creado correctamente
        assertTrue("El nuevo usuario no se ha agregado correctamente", usuarioCreado);
    }
}
