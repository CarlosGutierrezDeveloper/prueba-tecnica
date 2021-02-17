Feature: Quito producto
  Scenario: Como usuario requiero quitar un producto del carrito de compras
    Given carlos consulta el producto en el carrito
    When Se quita el producto del carrito de compras
    Then el producto no esta en el carrito de compras