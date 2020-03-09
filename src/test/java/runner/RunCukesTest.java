package runner;

import core.WebDriverManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import trabajopolis.PageTransporter;
import trabajopolis.pages.LoginPage;
import trabajopolis.reports.Report;


public class RunCukesTest extends AbstractTestNGCucumberTests {
    
    @BeforeTest
    public void loginInThePage() {
        PageTransporter pageTransporter = new PageTransporter();
        pageTransporter.navigateToPage("Login Page");
        LoginPage loginPage = new LoginPage();
        loginPage.test_login();
    }

    @AfterTest
    public void quitWebDriver() {
        WebDriverManager.getInstance().quitWebDriver();
        Report.getInstance().generateReport();
    }
}
