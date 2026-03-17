@testCompleto
Feature: Selección de categoría

    @categoriaInvalida
    Scenario: Seleccionar una categoría no válida
        Given que me encuentro en la página de inicio
        When selecciono la categoría "Autos"
        Then valido que no existe la categoria

    @categoriaValida
    Scenario: Seleccionar una categoría válida
        Given que me encuentro en la página de inicio
        When selecciono la categoría "CLOTHES"
        Then valido que nos dirija a la categoría