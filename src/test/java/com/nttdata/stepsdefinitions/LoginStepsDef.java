package com.nttdata.stepsdefinitions;

import com.nttdata.steps.LoginSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import com.nttdata.page.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nttdata.core.DriverManager.*;

public class LoginStepsDef {

    private WebDriver driver;

    @Dado("que me encuentro en la página de login")
    public void que_me_encuentro_en_la_página_de_login() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/pe/iniciar-sesion");
        screenShot();
    }
    @Cuando("inicio sesión con las credenciales correctas")
    public void inicio_sesión_con_las_credenciales_correctas() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.ingresoUsuarioYClave("pruebasKarla@testing.com", "pruebas1234.");
        screenShot();
    }
    @Entonces("valido que deber redirigido a la página de home")
    public void valido_que_deber_redirigido_a_la_página_de_home() {
        String urlActual = driver.getCurrentUrl();
        System.out.println("aca" + urlActual);
        String urlEsperada = "https://qalab.bensg.com/store/pe/";
        Assertions.assertEquals(urlEsperada, urlActual, "La URL actual no coincide con la URL esperada");
        esperaImplicita();
    }

    @Cuando("inicio sesión con las credenciales usuario: {string} y contraseña: {string}")
    public void inicio_sesion_con_las_credenciales_usuario_y_contrasena(String usuario, String contrasena) {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.ingresoUsuarioYClave(usuario, contrasena);
        screenShot();
    }

    @Entonces("valido que debería aparecer el mensaje de error {string}")
    public void valido_que_deberia_aparecer_el_mensaje_de_error(String mensajeEsperado) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String mensajeActual = wait.until(
                ExpectedConditions.visibilityOfElementLocated(LoginPage.errorMessage)
        ).getText().trim();

        screenShot();
        Assertions.assertEquals(mensajeEsperado, mensajeActual, "El mensaje de error no coincide");
    }
}
