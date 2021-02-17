package starter.ui.resultado;

import org.openqa.selenium.By;

public class FinancialOverview {
    //public static By CREDIT_AVAILABLE = By.xpath("//div[contains(text(), 'Credit Available')]/following-sibling::div[@class='balance-value']");
    public static By SEARCH_PRODUCT = By.cssSelector("div.product-info:nth-child(5) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1)");
    public static By CODE_PRODUCT = By.cssSelector(".aditional-info > span:nth-child(2) > div:nth-child(1)");
}
