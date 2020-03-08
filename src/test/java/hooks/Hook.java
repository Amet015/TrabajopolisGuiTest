package hooks;

import core.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import trabajopolis.PageTransporter;
import trabajopolis.pages.LoginPage;
import trabajopolis.entities.Context;


public class Hook {
    Context context;

    public Hook(Context context) {
        this.context = context;
    }

    @Before
    public void loginInThePage() {
        PageTransporter pageTransporter = new PageTransporter();
        pageTransporter.navigateToPage("Login Page");
        LoginPage loginPage = new LoginPage();
        loginPage.test_login();

    }

    @After
    public void quitWebDriver() {
        WebDriverManager.getInstance().getWebDriver().quit();
    }
}
