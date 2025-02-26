package com.orange.stepDefinitions;


import com.orange.steps.LoginInvalidStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginInvalidStepDefinition {

    @Steps
    private LoginInvalidStep loginSteps;  // Inyección de pasos

    WebDriver driver;

    // Configuración antes de ejecutar todas las pruebas
    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
    }

    // Configuración antes de cada prueba
    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
    }

    // Limpieza después de cada prueba
    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Paso Given: El usuario está en la página de login
    @Given("El usuario está en la página de login")
    public void elUsuarioEstaEnLaPaginaDeLogin() {
        loginSteps.openUrl();  // Llama al método para abrir la página de login
    }

    // Paso When: El usuario ingresa un nombre de usuario y una contraseña incorrectos
    @When("El usuario ingresa un nombre de usuario y una contraseña incorrectos")
    public void elUsuarioIngresaCredencialesIncorrectas() {
        loginSteps.ingresarCredencialesIncorrectas();  // Llama al método para ingresar credenciales incorrectas
    }

    // Paso Then: El sistema debe mostrar el mensaje de error
    @Then("El sistema debe mostrar el mensaje {string}")
    public void elSistemaDebeMostrarElMensaje(String mensajeEsperado) {
        loginSteps.verificarMensajeError(mensajeEsperado);  // Llama al método para verificar el mensaje de error
    }
    // Paso And: El usuario presiona el botón login
    @When("El usuario presiona el botón login")
    public void elUsuarioPresionaElBotonLogin() {
        loginSteps.presionarBotonLogin();  // Llama al método para hacer clic en el botón de login
    }

    // Limpieza después de la ejecución de todas las pruebas
    @After
    public void finalizar() {
        if (driver != null) {
            driver.quit();
        }
    }

}