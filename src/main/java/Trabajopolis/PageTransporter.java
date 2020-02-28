package Trabajopolis;

import Core.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class PageTransporter extends BasePage  {
    protected static WebDriver webDriver = WebDriverManager.getInstance().getWebDriver();;
    private static final String BASE_URL = "https://www.trabajopolis.bo/";
    // Encargada de leer el url base
    // almacenar como constantes las variaciones

    public static void navigateToLoginPage(){
        webDriver.get(BASE_URL+ "log-in/");
    }

    public static void navigateToMyAccountPage() {
        webDriver.get(BASE_URL + "my-account/");
    }

    public static void navigateEditProfilePage() {
        webDriver.get(BASE_URL + "edit-profile/");
    }

    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }
}
