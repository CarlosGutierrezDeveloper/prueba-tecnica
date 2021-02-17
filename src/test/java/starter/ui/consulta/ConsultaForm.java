package starter.ui.consulta;

import org.openqa.selenium.By;

public class ConsultaForm {

    public static By COOKIES = By.xpath("(//button[@type='button'])[54]");
    public static By BUSCAR = By.id("search-autocomplete-input");
    public static By MORE_RESULT = By.xpath("//*[@id='header']/div/div[2]/div[2]/div[1]/div[2]/div[2]/a/span");
    public static By PRODUCT = By.cssSelector(".product-item--13485 > div:nth-child(3) > div:nth-child(1) > a:nth-child(1)");


}
