package trabajopolis;

import core.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class PageTransporter {
    private WebDriver webDriver = WebDriverManager.getInstance().getWebDriver();
    private final String BASE_URL = "https://www.trabajopolis.bo/";
    // Encargada de leer el url base
    // almacenar como constantes las variaciones

    public void navigateToLoginPage() {
        WebDriverManager.getInstance().getWebDriver().get(BASE_URL + "log-in/");
    }

    public void navigateToPage(final String pageName) {
        WebDriverManager.getInstance().getWebDriver().get(BASE_URL + pageName);
    }

    public void navigateToMyAccountPage() {
        webDriver.get(BASE_URL + "my-account/");
    }

    public void navigateEditProfilePage() {
        webDriver.get(BASE_URL + "edit-profile/");
    }

    public void navigateToMyCurriculums() {
        webDriver.get(BASE_URL + "my-listings/");
    }

}
