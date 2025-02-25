package com.orange.stepDefinitions;


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
    private LoginReqStep homeStepsReq;

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

    @Given("El usuario ingresa en la página de login")
    public void elusuarioingresaenlapáginadelogin() {

        homeStepsReq.openUrl();
    }

    @When("El usuario ingresa una contraseña incorrecta")
    public void elusuarioingresaunacontraseñaincorrecta() {
        homeStepsReq.formulario2();

    }

    @When("El usuario da clik el botón login")
    public void elusuariodaclikelbotónlogin() {

        homeStepsReq.clickLogin2();
    }
    @Then("El sistema debe mostrar el campo Username en rojo y con el texto {string}")
    public void elsistemadebemostrarelcampousernameenrojoyconeltexto(String Required) {

    }


    @After
    public void finalizar(){
        if (driver !=null){
            driver.quit();
        }
    }

}