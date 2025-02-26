package com.orange.stepDefinitions;


import com.orange.steps.LoginReq2Step;
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


public class LoginRequired2StepDefinition {

    @Steps
    private LoginReq2Step homeStepsReq2;

    WebDriver driver;
    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
    }
    @BeforeEach
    void setupTest() {driver = new ChromeDriver();
    }
    @AfterEach
    void teardown() {driver.quit();
    }
    @Given("El usuario accede a la página de login")
    public void elusuarioaccedealapáginadelogin() {
        homeStepsReq2.openUrl();

    }
    // Paso When: El usuario deja los campos Username y Password vacíos
    @When("El usuario deja los campos de nombre de usuario y contraseña vacíos")
    public void elUsuarioDejaCamposVacios() {
        homeStepsReq2.dejarCamposVacios();  // Llama al método para dejar ambos campos vacíos
    }
    @When("El usuario hace clic el en botón login")
    public void elusuariohaceclicenelbotón() {
        homeStepsReq2.presionarBotonLogin();

    }
    @Then("El sistema debe mostrar el texto {string} en el campo Username")
    public void elSistemaDebeMostrarElTextoEnelCampousername(String string) {
        homeStepsReq2.verificarMensajeRequiredUserName();

    }
    @Then("El sistema debe mostrar el texto {string} en el campo Password")
    public void elsistemaDebeMostrarElTextoEnElCampopassword(String string) {
        homeStepsReq2.verificarMensajeRequiredPassword();

    }

    @After
    public void finalizar(){
        if (driver !=null){
            driver.quit();
        }
    }

}