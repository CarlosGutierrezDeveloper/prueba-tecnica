Feature: Busqueda de producto
  Scenario: Como usuario requiero realizar una busqueda de mi producto
    Given carlos ingresa al navegador web en la pagina de la tienda
    When Se introduce la palabra de busqueda "Aceite de Oliva"
    Then Se muestra el resultado de "Aceite de Oliva"