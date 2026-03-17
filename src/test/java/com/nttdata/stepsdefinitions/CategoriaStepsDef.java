package com.nttdata.stepsdefinitions;

import com.nttdata.steps.CategoriaSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.*;

public class CategoriaStepsDef {

    private WebDriver driver;
    private CategoriaSteps categoriaSteps;
    private boolean categoriaExiste;
    private String categoriaSeleccionada;

    @Dado("que me encuentro en la página de inicio")
    public void que_me_encuentro_en_la_página_de_inicio() {

        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/pe/");
        categoriaSteps = new CategoriaSteps(driver);
        screenShot();
    }

    @Cuando("selecciono la categoría {string}")
    public void selecciono_la_categoria(String categoria) {

        categoriaSeleccionada = categoria;

        categoriaExiste = categoriaSteps.existeCategoria(categoria);

        if(categoriaExiste){
            categoriaSteps.seleccionarCategoria(categoria);
        }

        screenShot();
    }

    @Entonces("valido que no existe la categoria")
    public void valido_que_no_existe_la_categoria() {

        Assertions.assertFalse(categoriaExiste,
                "La categoría sí existe cuando no debería");

    }

    @Entonces("valido que nos dirija a la categoría")
    public void valido_que_nos_dirija_a_la_categoria() {

        Assertions.assertTrue(categoriaExiste,
                "La categoría no existe");

        categoriaSteps.validarRedireccionCategoria(categoriaSeleccionada);

        screenShot();
    }
}