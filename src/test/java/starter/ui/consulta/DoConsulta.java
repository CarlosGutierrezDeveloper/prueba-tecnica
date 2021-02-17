package starter.ui.consulta;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DoConsulta implements Task {

    private final String consulta;


    public DoConsulta(String consulta) {
        this.consulta = consulta;
    }

    public static Performable enConsulta(String consulta){
        return instrumented(DoConsulta.class, consulta);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ConsultaForm.COOKIES),
                Enter.theValue(consulta).into(ConsultaForm.BUSCAR),
                Click.on(ConsultaForm.MORE_RESULT),
                Click.on(ConsultaForm.PRODUCT));

    }
}
