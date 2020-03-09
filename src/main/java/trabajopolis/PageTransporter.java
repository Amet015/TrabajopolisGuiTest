package trabajopolis;

import core.WebDriverManager;

import java.util.HashMap;

public class PageTransporter {

    private final String BASE_URL = "https://www.trabajopolis.bo/";
    private HashMap<String, String> urlMap;

    public PageTransporter(){
        urlMap = new HashMap<>();
        urlMap.put("Pagina principal","");
        urlMap.put("Login Page","log-in/");
        urlMap.put("Mi cuenta", "my-account/");
        urlMap.put("Mis curriculos", "my-listings/");
        urlMap.put("Mi perfil", "edit-profile/");
        urlMap.put("Busquedas guardadas", "saved-searches/");
    }

    public void navigateToPage(String endPoint) {
        WebDriverManager.getInstance().getWebDriver().get(BASE_URL + urlMap.get(endPoint));

    }
}
