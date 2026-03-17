# Automatización Web con Selenium

Proyecto de automatización web desarrollado con **Java**, **Selenium WebDriver**, **Cucumber** y **Maven**, orientado a validar flujos funcionales de una tienda web, como:

- Login exitoso
- Login fallido
- Selección de categorías válidas e inválidas
- Validación de precio de productos en popup y carrito

---

## Tecnologías usadas

- **Java**
- **Selenium WebDriver**
- **Cucumber**
- **JUnit 5**
- **Maven**

---

## Objetivo del proyecto

El objetivo de este proyecto es automatizar escenarios funcionales de una aplicación web de tipo e-commerce, validando el comportamiento esperado de la interfaz de usuario y las reglas básicas del negocio.

---

## Estructura del proyecto

La estructura del proyecto sigue una organización por capas para facilitar el mantenimiento y la reutilización del código.

```bash
src
└── test
    ├── java
    │   └── com.nttdata
    │       ├── core
    │       │   └── DriverManager.java
    │       ├── page
    │       │   ├── LoginPage.java
    │       │   ├── CategoriaPage.java
    │       │   └── StorePage.java
    │       ├── steps
    │       │   ├── LoginSteps.java
    │       │   ├── CategoriaSteps.java
    │       │   └── StoreSteps.java
    │       └── stepsdefinitions
    │           ├── LoginStepsDef.java
    │           ├── CategoriaStepsDef.java
    │           └── StoreStepsDef.java
    │
    └── resources
        └── features
            ├── login.feature
            ├── categoria.feature
            └── store.feature