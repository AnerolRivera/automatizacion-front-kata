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
    private LoginInvalidStep homeSteps;

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

    @Given("El usuario está en la página de login")
    public void elusuarioestáenlapáginadelogin() {

        homeSteps.openUrl();
    }

    @When("El usuario ingresa un nombre de usuario y una contraseña incorrectos")
    public void elusuarioingresaunnombredeusuarioyunacontraseñaincorrectos() {

        homeSteps.formulario1();
    }

    @When("El usuario presiona el botón login")
    public void elusuariopresionaelbotónlogin() {

        homeSteps.clickLogin();
    }

    @Then("El sistema debe mostrar el mensaje {string}")
    public void elsistemadebemostrarelmensaje(String Invalid) {

    }

    @After
    public void finalizar(){
        if (driver !=null){
            driver.quit();
        }
    }

}