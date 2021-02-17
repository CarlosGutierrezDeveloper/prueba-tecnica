package starter.ui.resultado;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class CreditAvailable implements Question<String> {

    public static Question<String> value(){
        return new CreditAvailable();
    }


    @Override
    public String answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).find(FinancialOverview.SEARCH_PRODUCT).getText();
    }
}
