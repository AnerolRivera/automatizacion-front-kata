package com.orange.stepDefinitions;


import com.orange.pageObject.LoginReqPageObject;
import com.orange.steps.LoginInvalidStep;
import com.orange.steps.LoginReqStep;
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


public class LoginRequiredStepDefinition {

    @Steps
    private LoginReqStep loginPageR;  // Inyección de pasos

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
    @Given("El usuario ingresa en la página de login")
    public void elUsuarioIngreaEnLaPaginaDeLogin() {
        loginPageR.openUrl();  // Llama al método para abrir la página de login
    }

    // Paso When: El usuario deja vacío el campo Username y coloca la contraseña
    @When("El usuario deja el campo de nombre de usuario vacío y coloca la contraseña")
    public void elUsuarioDejaCampoUsuarioVacio() {
        loginPageR.ingresarSoloContraseña();  // Ingresa solo la contraseña
    }

    // Paso And: El usuario presiona el botón login
    @When("El usuario selecciona el botón login")
    public void elUsuarioSeleccionaElBotonLogin() {
        loginPageR.presionarBotonLogin();  // Llama al método para hacer clic en el botón de login
    }

    // Paso Then: El sistema debe mostrar el mensaje de error
    @Then("El sistema debe mostrar en el campo usuario el texto {string}")
    public void elSistemaDebeMostrarEnElCampoUsuarioElTexto(String mensajeEsperado) {
        loginPageR.verificarMensajeRequired();
    }


    // Limpieza después de la ejecución de todas las pruebas
    @After
    public void finalizar() {
        if (driver != null) {
            driver.quit();
        }
    }

}