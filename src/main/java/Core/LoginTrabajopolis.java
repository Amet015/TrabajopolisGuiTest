package Core;

import Trabajopolis.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginTrabajopolis {

    private WebDriver driver;
    private static final String URL = "https://www.trabajopolis.bo/log-in/";
    private HomePage homePage;

    public LoginTrabajopolis() {
        driver = WebDriverManager.getInstance().getWebDriver();
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    public void test_login() {
        driver.get(URL);
        driver.manage().window().maximize();
        homePage.setCredentials("at11.fundacion.jala@gmail.com", "at11.2020");

    }
}
