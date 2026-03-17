package com.nttdata.stepsdefinitions;

import com.nttdata.steps.StoreSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;

import static com.nttdata.core.DriverManager.*;

public class StoreStepsDef {

    private WebDriver driver;
    private StoreSteps storeSteps;

    private String nombreProducto;
    private BigDecimal precioUnitario;
    private int cantidad;
    private BigDecimal totalEsperado;

    @Dado("estoy en la página de la tienda")
    public void estoy_en_la_pagina_de_la_tienda() {
        driver = getDriver();
        storeSteps = new StoreSteps(driver);
        storeSteps.irATienda();
        screenShot();
    }

    @Y("me logueo con mi usuario {string} y clave {string}")
    public void me_logueo_con_mi_usuario_y_clave(String usuario, String clave) {
        storeSteps.login(usuario, clave);
        screenShot();
    }

    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navego_a_la_categoria_y_subcategoria(String categoria, String subcategoria) {
        storeSteps.navegarCategoriaYSubcategoria(categoria, subcategoria);
        screenShot();
    }

    @Y("agrego {int} unidades del primer producto al carrito")
    public void agrego_unidades_del_primer_producto_al_carrito(int unidades) {
        nombreProducto = storeSteps.obtenerNombrePrimerProducto();
        precioUnitario = storeSteps.obtenerPrecioPrimerProducto();
        cantidad = unidades;
        totalEsperado = precioUnitario.multiply(BigDecimal.valueOf(cantidad));

        storeSteps.abrirPrimerProducto();
        storeSteps.establecerCantidad(unidades);
        storeSteps.agregarAlCarrito();

        screenShot();
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void valido_en_el_popup_la_confirmacion_del_producto_agregado() {
        storeSteps.validarPopupVisible();
        storeSteps.validarNombreProductoPopup(nombreProducto);
        screenShot();
    }

    @Y("valido en el popup que el monto total sea calculado correctamente")
    public void valido_en_el_popup_que_el_monto_total_sea_calculado_correctamente() {
        BigDecimal montoPopup = storeSteps.obtenerMontoTotalPopup();

        Assertions.assertEquals(
                0,
                totalEsperado.compareTo(montoPopup),
                "El monto total del popup no coincide con el esperado"
        );

        screenShot();
    }

    @Cuando("finalizo la compra")
    public void finalizo_la_compra() {
        storeSteps.finalizarCompra();
        screenShot();
    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void valido_el_titulo_de_la_pagina_del_carrito() {
        storeSteps.validarTituloCarrito();
        screenShot();
    }

    @Y("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvo_a_validar_el_calculo_de_precios_en_el_carrito() {
        BigDecimal precioUnitarioCarrito = storeSteps.obtenerPrecioUnitarioCarrito();
        int cantidadCarrito = storeSteps.obtenerCantidadCarrito();
        BigDecimal subtotalCarrito = storeSteps.obtenerSubtotalCarrito();

        BigDecimal totalEsperadoCarrito = precioUnitarioCarrito.multiply(BigDecimal.valueOf(cantidadCarrito));

        Assertions.assertEquals(
                0,
                totalEsperadoCarrito.compareTo(subtotalCarrito),
                "El cálculo de precios en el carrito no coincide"
        );

        screenShot();
    }
}