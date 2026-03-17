package com.nttdata.steps;

import com.nttdata.page.StorePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;
import java.time.Duration;

public class StoreSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    public StoreSteps(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void irATienda(){
        driver.get("https://qalab.bensg.com/store/pe/");
    }

    public void login(String usuario, String clave){
        wait.until(ExpectedConditions.elementToBeClickable(StorePage.loginLink)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(StorePage.emailInput)).sendKeys(usuario);
        driver.findElement(StorePage.passwordInput).sendKeys(clave);
        driver.findElement(StorePage.submitLogin).click();
    }

    public void navegarCategoriaYSubcategoria(String categoria, String subcategoria){
        wait.until(ExpectedConditions.elementToBeClickable(StorePage.categoria(categoria))).click();
        wait.until(ExpectedConditions.elementToBeClickable(StorePage.subcategoria(subcategoria))).click();
    }

    public String obtenerNombrePrimerProducto(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(StorePage.nombrePrimerProducto))
                .getText().trim();
    }

    public BigDecimal obtenerPrecioPrimerProducto(){
        String textoPrecio = wait.until(ExpectedConditions.visibilityOfElementLocated(StorePage.precioPrimerProducto))
                .getText().trim();
        return convertirPrecio(textoPrecio);
    }

    public void abrirPrimerProducto(){
        wait.until(ExpectedConditions.elementToBeClickable(StorePage.nombrePrimerProducto)).click();
    }

    public void establecerCantidad(int cantidad){
        WebElement inputCantidad = wait.until(ExpectedConditions.visibilityOfElementLocated(StorePage.cantidadInput));
        inputCantidad.click();
        inputCantidad.sendKeys(Keys.CONTROL + "a");
        inputCantidad.sendKeys(Keys.DELETE);
        inputCantidad.sendKeys(String.valueOf(cantidad));
    }

    public void agregarAlCarrito(){
        wait.until(ExpectedConditions.elementToBeClickable(StorePage.agregarAlCarritoBtn)).click();
    }

    public void validarPopupVisible(){
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(StorePage.popupProductoAgregado));
        Assertions.assertTrue(popup.isDisplayed(), "El popup de confirmación no se mostró");
    }

    public void validarNombreProductoPopup(String nombreEsperado){
        String nombreActual = wait.until(ExpectedConditions.visibilityOfElementLocated(StorePage.popupNombreProducto))
                .getText().trim();

        Assertions.assertTrue(
                nombreActual.equalsIgnoreCase(nombreEsperado),
                "El nombre del producto en el popup no coincide. Esperado: " 
                        + nombreEsperado + " / Actual: " + nombreActual
        );
    }

    public BigDecimal obtenerMontoTotalPopup(){
        String totalTexto = wait.until(ExpectedConditions.visibilityOfElementLocated(StorePage.popupMontoTotal))
                .getText().trim();
        return convertirPrecio(totalTexto);
    }

    public void finalizarCompra(){
        wait.until(ExpectedConditions.elementToBeClickable(StorePage.finalizarCompraBtn)).click();
    }

    public void validarTituloCarrito(){
        String titulo = wait.until(ExpectedConditions.visibilityOfElementLocated(StorePage.tituloCarrito))
                .getText().trim().toLowerCase();

        Assertions.assertTrue(
                titulo.contains("carrito") || titulo.contains("shopping cart"),
                "El título de la página del carrito no es correcto. Título actual: " + titulo
        );
    }

    public BigDecimal obtenerPrecioUnitarioCarrito(){
        String texto = wait.until(ExpectedConditions.visibilityOfElementLocated(StorePage.carritoPrecioUnitario))
                .getText().trim();
        return convertirPrecio(texto);
    }

    public int obtenerCantidadCarrito(){
        String cantidad = wait.until(ExpectedConditions.visibilityOfElementLocated(StorePage.carritoCantidadInput))
                .getAttribute("value");
        return Integer.parseInt(cantidad);
    }

    public BigDecimal obtenerSubtotalCarrito(){
        String texto = wait.until(ExpectedConditions.visibilityOfElementLocated(StorePage.carritoSubtotal))
                .getText().trim();
        return convertirPrecio(texto);
    }

    private BigDecimal convertirPrecio(String textoPrecio){
        String limpio = textoPrecio
                .replace("S/", "")
                .replace("$", "")
                .replace(",", "")
                .trim();
        return new BigDecimal(limpio);
    }
}