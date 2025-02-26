package com.orange.runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features ="src/test/resources/features",
        tags = "@NewUser1",
        glue = "com.orange.stepDefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class Runner {

}



