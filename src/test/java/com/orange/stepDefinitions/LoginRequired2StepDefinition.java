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
    @Given("El usuario entra a la página de login")
    public void elusuarioentraalapáginadelogin() {
        homeStepsReq2.openUrl();

    }
    @When("El usuario no ingresa datos")
    public void elusuarionoingresadatos() {
        homeStepsReq2.formulario3();

    }
    @When("El usuario da clik el botón")
    public void elusuariodaclikelbotón() {
        homeStepsReq2.clickLogin3();

    }
    @Then("El sistema debe mostrar los campos {string} y {string} en rojo y con el texto {string}")
    public void elsistemadebemostrarloscamposyenrojoyconeltexto(String string, String string2, String string3) {

    }

    @After
    public void finalizar(){
        if (driver !=null){
            driver.quit();
        }
    }

}