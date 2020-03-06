package runner;

import core.WebDriverManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import trabajopolis.PageTransporter;
import trabajopolis.pages.LoginPage;


public class RunCukesTest extends AbstractTestNGCucumberTests {
    
    @BeforeTest
    public void loginInThePage() {
        PageTransporter pageTransporter = new PageTransporter();
        pageTransporter.navigateToLoginPage();
        LoginPage loginPage = new LoginPage();
        loginPage.test_login();

    }

    @AfterTest
    public void quitWebDriver() {
        WebDriverManager.getInstance().getWebDriver().quit();
    }
}
