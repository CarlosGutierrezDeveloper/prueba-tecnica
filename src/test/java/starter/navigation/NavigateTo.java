package starter.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {

    public static Performable elWongHomePage(){
        return Task.where("{0} opens the Wong home page",
                Open.browserOn().the(WongHomePage.class));
    }

}