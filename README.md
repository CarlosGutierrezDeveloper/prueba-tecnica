# Se utilizó el patron ScreenPlay

El lenjuaje de programación utilizado fue Java, y el proyecto se construyo con Gradle.

Plugins que se utlizaron en el proyecto:  Cucumber for Java, git toolbox para el manejo de versiones.

## Código en Git

Git:

    git clone https://github.com/serenity-bdd/serenity-cucumber4-starter.git
    cd serenity-cucumber4-starter


## Ejecutar por CDM
Para ejecutar el proyecto por CDM es necesario ir a la carpeta donde se encuentra los archivos del proyecto y  luego correr el siguiente comando.


CMD:

    gradle  clean test -Pwebdriver.driver=chrome -Denvironment=staging

### Estructura de carpetas

El proyecto tiene scripts de compilación para Gradle, y sigue la estructura de directorio estándar utilizada en la mayoría de los proyectos de Serenity:
```Gherkin
src
  + main
  + test
    + java                         
    + resources
      + features                   
        + carrito_compras                   
          consulta.feature  
      + webdriver                   
        + linux
        + mac
        + windows
          chromedriver.exe          
          geckodriver.exe

```


## Scenario utilizado en el proyecto

```Gherkin
Feature: Busqueda de producto

  Scenario: Como usuario requiero realizar una busqueda de mi producto
    Given carlos ingresa al navegador web en la pagina de la tienda
    When Se introduce la palabra de busqueda "Aceite de Oliva"
    Then Se muestra el resultado de "Aceite de Oliva"
```

Este escenario nos permite explorar algunas de las nuevas expresiones de Cucumber 4. Cucumber 4 admite tanto las expresiones regulares clásicas como las nuevas _Cucumber Expressions_, que son más legibles aunque no tan potentes en algunos casos. 


### Objetos de página ajustada y clases de acción
Estas clases se declaran utilizando la anotación de Serenity `@ Steps`, que se muestra a continuación:
```java
    @Steps
    NavigateTo navigateTo;

    @Steps
    SearchFor searchFor;

    @Steps
    SearchResult searchResult;
```


Lo hace utilizando un objeto de página de Serenity estándar. Los objetos de página suelen ser mínimos y solo almacenan la URL de la página en sí:
```java
@DefaultUrl("https://www.wong.pe")
public class WongHomePage extends PageObject {
}
```
La clase `ConsultaForm` es típica de un objeto de página liviano: es responsable únicamente de ubicar elementos en la página, y lo hace definiendo localizadores u ocasionalmente resolviendo elementos web dinámicamente.
```java
class ConsultaForm {
    public static By COOKIES = By.xpath("(//button[@type='button'])[54]");
    public static By BUSCAR = By.id("search-autocomplete-input");
}
```

Las clases de guiones enfatizan los componentes reutilizables y un estilo declarativo muy legible, mientras que los objetos de página ajustada y las clases de acción optan por un estilo más imperativo.
La clase `NavigateTo` desempeña la misma función que su equivalente en la versión Lean Page Object / Action Class, y se ve bastante similar:
```java
public class NavigateTo  {

    public static Performable elWongHomePage(){
        return Task.where("{0} opens the Wong home page",
                Open.browserOn().the(WongHomePage.class)
        );
    }
} 
```
El proyecto también incluye algunos de los binarios de WebDriver que necesitas para ejecutar pruebas de Selenium en los directorios `src / test / resources / webdriver`. Estos binarios se configuran en la sección `drivers` del archivo de configuración` serenity.conf`:
```json
drivers {
  windows {
    webdriver.chrome.driver = "src/test/resources/webdriver/windows/chromedriver.exe"
    webdriver.gecko.driver = "src/test/resources/webdriver/windows/geckodriver.exe"
  }
  mac {
    webdriver.chrome.driver = "src/test/resources/webdriver/mac/chromedriver"
    webdriver.gecko.driver = "src/test/resources/webdriver/mac/geckodriver"
  }
  linux {
    webdriver.chrome.driver = "src/test/resources/webdriver/linux/chromedriver"
    webdriver.gecko.driver = "src/test/resources/webdriver/linux/geckodriver"
  }
}
```
Esta configuración significa que las máquinas de desarrollo y los servidores de compilación no necesitan tener instalada una versión particular de los controladores WebDriver para que las pruebas se ejecuten correctamente.

### Configuraciones específicas del entorno
También podemos configurar propiedades y opciones específicas del entorno, para que las pruebas se puedan ejecutar en diferentes entornos. Aquí, configuramos tres entornos, __dev__, _staging_ y _prod_, con diferentes URL de inicio para cada uno:
```json
environments {
  default {
    webdriver.base.url = "https://www.wong.pe/especiales/cyberwong"
  }
  dev {
    webdriver.base.url = "https://www.wong.pe/especiales/cyberwong"
  }
  staging {
    webdriver.base.url = "https://www.wong.pe/especiales/cyberwong"
  }
  prod {
    webdriver.base.url = "https://www.wong.pe/especiales/cyberwong"
  }
}
```