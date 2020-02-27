package Trabajopolis;

import Core.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class PageTransporter {
    protected WebDriver webDriver = WebDriverManager.getInstance().getWebDriver();;
    private static final String BASE_URL = "https://www.trabajopolis.bo/";
    // Encargada de leer el url base
    // almacenar como constantes las variaciones

    public void navigateToMyAccountPage() {
        webDriver.get(BASE_URL + "my-account/");
    }

    public void navigateEditProfilePage() {
        webDriver.get(BASE_URL + "edit-profile/");
    }
}
