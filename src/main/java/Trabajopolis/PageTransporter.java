package Trabajopolis;

import Core.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class PageTransporter {
    protected WebDriver webDriver;
    private static final String BASE_URL = "apps.brightspot.com";
    // Encargada de leer el url base
    // almacenar como constantes las variaciones

    public LoginPage navigateToLoginPage() {
        webDriver = WebDriverManager.getInstance().getWebDriver();
        webDriver.get("www.trabajopolis.bo/");
        return new LoginPage();
    }
}
