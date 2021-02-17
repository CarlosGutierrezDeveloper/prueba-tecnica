package starter.ui.agregar;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DoAgregar implements Task {

    private final String agregar;
    private final String t_correo;


    public DoAgregar(String agregar, String t_correo) {
        this.agregar = agregar;
        this.t_correo = t_correo;
    }

    public static Performable add(String agregar, String t_correo){
        return instrumented(DoAgregar.class, agregar, t_correo);
    }



    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(AgregarForm.A_COOKIES),
                Enter.theValue(agregar).into(AgregarForm.A_BUSCAR),
                Click.on(AgregarForm.A_MORE_RESULT),
                Click.on(AgregarForm.A_PRODUCT),
                Click.on(AgregarForm.AGREGAR),
                Enter.theValue(t_correo).into(AgregarForm.CORREO),
                Click.on(AgregarForm.BTN_ACEPTAR),
                Click.on(AgregarForm.ENTREGA),
                Click.on(AgregarForm.ENVIAR));
    }
}
