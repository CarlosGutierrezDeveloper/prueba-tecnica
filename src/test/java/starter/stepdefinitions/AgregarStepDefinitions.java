package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import starter.navigation.NavigateTo;
import starter.ui.agregar.DoAgregar;


import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class AgregarStepDefinitions {

    String name;
    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("(.*) consulta el producto preferido")
    public void consulta_el_producto_preferido(String name) {
        this.name = name;
    }

    @When("Se agrega la carrito el producto seleccionado")
    public void se_agrega_la_carrito_el_producto_seleccionado() {
        theActorCalled(name).attemptsTo(NavigateTo.elWongHomePage(),
                DoAgregar.add("Aceite de Oliva", "carlos@gmail.com"));

    }

    @Then("obtengo el producto en el carrito de compras")
    public void obtengo_el_producto_en_el_carrito_de_compras() {

    }
}
