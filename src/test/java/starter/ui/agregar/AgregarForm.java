package starter.ui.agregar;

import org.openqa.selenium.By;


public class AgregarForm {

    public static By A_COOKIES = By.xpath("(//button[@type='button'])[54]");
    public static By A_BUSCAR = By.id("search-autocomplete-input");
    public static By A_MORE_RESULT = By.xpath("//*[@id='header']/div/div[2]/div[2]/div[1]/div[2]/div[2]/a/span");
    public static By A_PRODUCT = By.cssSelector(".product-item--460 > div:nth-child(3) > div:nth-child(1) > a:nth-child(1)");
    public static By AGREGAR = By.xpath("/html/body/div[22]/div/div[1]/div[1]/div[5]/div[2]/div[6]/div[5]/button[1]/span[5]");
    public static By CORREO = By.id("delivery-email");
    public static By BTN_ACEPTAR = By.xpath("/html/body/footer/div[3]/div/div/div/div/div/div[3]/button");
    public static By ENTREGA = By.xpath("/html/body/footer/div[3]/div/div/div/div/div/div[2]/div[2]/button[1]");
    public static By ENVIAR = By.xpath("/html/body/footer/div[3]/div/div/div/div/div/div[2]/div/div/div/div[1]/div/div[2]/div[2]/button[2]");

}
