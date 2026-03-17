package com.nttdata.page;

import com.nttdata.core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoriaPage {

    //Localizadores de elementos
    public static By categoriaAutos = By.linkText("Autos");
    public static By categoriaClothes = By.linkText("Clothes");

    public static By categoria(String nombreCategoria) {
        return By.linkText(nombreCategoria);
    }
}