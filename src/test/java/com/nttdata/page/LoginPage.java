package com.nttdata.page;

import com.nttdata.core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    //Localizadores de elementos
    public static By userInput = By.id("field-email");
    public static By passInput = By.id("field-password");
    public static By loginButton = By.id("submit-login");
    public static By errorMessage = By.cssSelector("li.alert.alert-danger");
}
