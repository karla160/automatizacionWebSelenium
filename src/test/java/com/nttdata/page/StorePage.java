package com.nttdata.page;

import org.openqa.selenium.By;

public class StorePage {

    // Login
    public static By loginLink = By.xpath("//span[text()='Iniciar sesión']");
    public static By emailInput = By.id("field-email");
    public static By passwordInput = By.id("field-password");
    public static By submitLogin = By.id("submit-login");

    // Categoría / subcategoría
    public static By categoria(String categoria){
        return By.linkText(categoria);
    }

    public static By subcategoria(String subcategoria){
        return By.linkText(subcategoria);
    }

    // Primer producto
    public static By primerProducto = By.cssSelector(".product-miniature");
    public static By nombrePrimerProducto = By.cssSelector(".product-miniature .product-title a");
    public static By precioPrimerProducto = By.cssSelector(".product-miniature .price");
    public static By quickViewPrimerProducto = By.cssSelector(".product-miniature a.quick-view");

    // Detalle producto / modal
    public static By cantidadInput = By.id("quantity_wanted");
    public static By agregarAlCarritoBtn = By.cssSelector(".add-to-cart");
    
    // Popup confirmación
    public static By popupProductoAgregado = By.id("blockcart-modal");
    public static By popupTitulo = By.cssSelector("#blockcart-modal .modal-title");
    public static By popupNombreProducto = By.cssSelector("#blockcart-modal .product-name");
    public static By popupCantidad = By.cssSelector("#blockcart-modal .product-quantity strong");
    public static By popupMontoTotal = By.cssSelector("#blockcart-modal .product-total .value");
    public static By finalizarCompraBtn = By.cssSelector("#blockcart-modal a[href*='carrito'], #blockcart-modal a.btn.btn-primary");

    // Carrito
    public static By tituloCarrito = By.cssSelector(".card-block h1, .page-title");
    public static By carritoPrecioUnitario = By.cssSelector(".cart-item .current-price span.price");
    public static By carritoCantidadInput = By.cssSelector(".cart-item input.js-cart-line-product-quantity");
    public static By carritoSubtotal = By.cssSelector(".cart-summary-line.cart-total .value, .cart-summary-line .value");
}