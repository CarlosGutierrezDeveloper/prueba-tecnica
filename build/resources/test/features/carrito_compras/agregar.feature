Feature: Agrego producto
  Scenario: Como usuario requiero agregar mi producto al carrito de compras
    Given carlos consulta el producto preferido
    When Se agrega la carrito el producto seleccionado
    Then obtengo el producto en el carrito de compras