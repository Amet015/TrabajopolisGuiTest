package hooks;

import Core.WebDriverManager;
import Trabajopolis.PageTransporter;
import Trabajopolis.Pages.EditProfilePage;
import Trabajopolis.Pages.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook {

    @Before
    public void loginInThePage(){
        PageTransporter pageTransporter = new PageTransporter();
        pageTransporter.navigateToLoginPage();
        LoginPage loginPage = new LoginPage();
        loginPage.test_login();
    }

    @After
    public void quitWebDriver(){
        WebDriverManager.getInstance().getWebDriver().quit();
    }
}
