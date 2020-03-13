package TestTrabajopolis.hooks;

import core.WebDriverManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import trabajopolis.PageTransporter;
import trabajopolis.entities.Context;


public class Hook {
    private WebDriver webDriver;
    private Context context;
    private PageTransporter pageTransporter;

    public Hook(Context context) {
        this.context = context;
        pageTransporter = new PageTransporter();
        webDriver = WebDriverManager.getInstance().getWebDriver();
    }

    @Before
    public void loginInThePage() {
//        pageTransporter.navigateToPage("Login Page");
//        LoginPage loginPage = new LoginPage();
//        loginPage.test_login();
        System.out.println("loginPage Before--- Hook Cucumber Before");

    }

//    @After(order = 1)
//    public void quitWebDriver() {
//        WebDriverManager.getInstance().quitWebDriver();
//    }

    /**
     * Take a Screenshoot when the scenario fail
     * @param scenario
     */
    @After(order = 2)
    public void isFailed(final Scenario scenario) {
        System.out.println("IsFailed--- Hook Cucumber After");
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot,"image/png","prueba1");
        }
    }


}
