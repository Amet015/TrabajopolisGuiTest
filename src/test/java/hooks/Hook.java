package hooks;

import core.WebDriverManager;
import trabajopolis.PageTransporter;
import trabajopolis.pages.LoginPage;
import trabajopolis.entities.Context;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook {
    Context context;

    public Hook(Context context) {
        this.context = context;
    }

    @Before
    public void loginInThePage() {
        PageTransporter pageTransporter = new PageTransporter();
        pageTransporter.navigateToLoginPage();
        LoginPage loginPage = new LoginPage();
        loginPage.test_login();

    }

    @After
    public void quitWebDriver() {
        WebDriverManager.getInstance().getWebDriver().quit();
    }
}
