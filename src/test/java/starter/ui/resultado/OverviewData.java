package starter.ui.resultado;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

public class OverviewData {

    public static Question<String> searchProduct(){
        return actor -> TextContent.of(FinancialOverview.SEARCH_PRODUCT).viewedBy(actor).asString().trim();
    }
    public static Question<String> codeProduct(){
        return actor -> TextContent.of(FinancialOverview.CODE_PRODUCT).viewedBy(actor).asString();
    }
}
