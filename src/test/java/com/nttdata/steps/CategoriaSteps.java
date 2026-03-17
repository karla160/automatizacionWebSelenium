package com.nttdata.steps;

import com.nttdata.page.CategoriaPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class CategoriaSteps {

    private WebDriver driver;

    public CategoriaSteps(WebDriver driver){
        this.driver = driver;
    }

    public boolean existeCategoria(String categoria){
        return !driver.findElements(CategoriaPage.categoria(categoria)).isEmpty();
    }

    public void seleccionarCategoria(String categoria){
        driver.findElement(CategoriaPage.categoria(categoria)).click();
    }

    public void validarRedireccionCategoria(String categoria){

        String urlActual = driver.getCurrentUrl();

        Assertions.assertTrue(urlActual.toLowerCase().contains(categoria.toLowerCase()),
                "No se redirigió a la categoría esperada. URL actual: " + urlActual);
    }
}