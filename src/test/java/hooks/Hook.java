package hooks;

import core.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import trabajopolis.PageTransporter;
import trabajopolis.pages.LoginPage;
import trabajopolis.entities.Context;


public class Hook {
    private Context context;
    private PageTransporter pageTransporter;

    public Hook(Context context) {
        this.context = context;
        pageTransporter = new PageTransporter();
    }

    @Before
    public void loginInThePage() {

//        pageTransporter.navigateToPage("Login Page");
//        LoginPage loginPage = new LoginPage();
//        loginPage.test_login();

    }

    @After
    public void quitWebDriver() {
//        WebDriverManager.getInstance().quitWebDriver();
    }
}
