package com.orange.stepDefinitions;


import com.orange.steps.LoginExitosoStep;
import com.orange.steps.NewUserStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;


public class LoginExitosoStepDefinition {

    @Managed
    WebDriver driver;  // WebDriver gestionado por Serenity

    @Steps
    private LoginExitosoStep homeStepsExitoso;  // Clase de pasos para login

    @Steps
    private NewUserStep newUserStep;  // Clase de pasos para el nuevo usuario


    @After
    public void tearDown() {
        // Cerramos el WebDriver después de cada prueba
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("El usuario inicia en la página de login")
    public void elUsuarioIniciaEnLaPaginaDeLogin() {
        homeStepsExitoso.openUrl();
    }

    @When("El usuario ingresa un nombre de usuario y una contraseña correctos")
    public void elUsuarioIngresaNombreYContraseñaCorrectos() {
        homeStepsExitoso.ingresarCredenciales();
    }

    @When("El usuario da clic sobre el botón de login")
    public void elUsuarioDaClicSobreElBotonLogin() {
        homeStepsExitoso.presionarBotonLogin();
    }

    @Then("El sistema debe mostrar la página de inicio")
    public void elSistemaDebeMostrarLaPaginaDeInicio() {
        assertTrue("El dashboard no es visible", homeStepsExitoso.verificarDashboard());
    }
}