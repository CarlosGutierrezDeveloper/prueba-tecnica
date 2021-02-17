package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import starter.ui.consulta.DoConsulta;
import starter.navigation.NavigateTo;
import starter.ui.resultado.CreditAvailable;
import starter.ui.resultado.OverviewData;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;

public class ConsultaStepDefinitions {

    String name;

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("(.*) ingresa al navegador web en la pagina de la tienda")
    public void un_navegador_web_en_la_pagina_de_la_tienda(String name) {
        this.name = name;

    }

    @When("Se introduce la palabra de busqueda {string}")
    public void se_introduce_la_palabra_de_busqueda(String string) {
        theActorCalled(name).attemptsTo(NavigateTo.elWongHomePage(), DoConsulta.enConsulta("Aceite de Oliva"));
    }

    @Then("Se muestra el resultado de {string}")
    public void se_muestra_el_resultado_de(String string) {
        System.out.println("+++++++++++++"+ CreditAvailable.value().answeredBy(theActorInTheSpotlight()));

        theActorInTheSpotlight().should(
                seeThat("El Aceite desplegado sea el correcto",OverviewData.searchProduct(), equalTo("Aceite de Oliva Carbonell Virgen Spray 200 ml")),
                seeThat("El codigo del producto desplegado sea el correcto",OverviewData.codeProduct(), equalTo("497349001"))
        );

    }
}
