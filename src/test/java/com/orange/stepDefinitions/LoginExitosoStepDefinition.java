package com.orange.stepDefinitions;


import com.orange.steps.LoginExitosoStep;
import com.orange.steps.NewUserStep;
import io.cucumber.java.en.And;
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


public class LoginExitosoStepDefinition {

    @Steps
    private LoginExitosoStep homeStepsExotoso;
    @Steps
    private NewUserStep newUserStep;
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
    @Given("El usuario accede en la página de login")
    public void elusuarioaccedeenlapáginadelogin() {
        homeStepsExotoso.openUrl();

    }
    @When("El usuario ingresa su usuario y contraseña")
    public void elusuarioingresasuusuarioycontraseña() {
        homeStepsExotoso.formulario();

    }
    @When("El usuario pulsa el botón login")
    public void elusuariopulsaelbotónlogin() {
        homeStepsExotoso.clickLogin4();
    }
    @And("El usuario selecciona la opcion Admin")
    public void elusuarioseleccionalaopcionadmin() {
        newUserStep.Admin();
    }
    @And("El usuario da clik en el boton Add")
    public void elusuariodaclikenelbotonadd() {
        newUserStep.Add();
    }
    @And("El usuario ingresa los datos de registro")
    public void elusuarioingresalosdatosderegistro() {
        newUserStep.formulario4();
    }
    @And("El usuario da click en el boton save")
    public void elusuariodaclickenelbotonsave() {
        newUserStep.clickSave();
    }
    @Then("El sistema registra el usuario exitosamente")
    public void elsistemaregistraelusuarioexitosamente() {

    }
    @After
    public void finalizar(){
        if (driver !=null){
            driver.quit();
        }
    }

}