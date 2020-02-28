package steps;

import Core.WebDriverManager;
import Trabajopolis.PageTransporter;
import Trabajopolis.Pages.LoginPage;
import Trabajopolis.Pages.MyAccountPage;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class LoginSteps {
    LoginPage loginPage;

    public LoginSteps(){

    }

    @After
    public void afterTest(){
        WebDriverManager.getInstance().quitWebDriver();
    }

    @Given("^I go to Login page$")
    public void iLoginToTheApplication() {
        PageTransporter.navigateToLoginPage();
    }

    @When("^I insert the credentials$")
    public void iInsertTheCredentials() {
        loginPage = new LoginPage();
        loginPage.test_login();
        
    }

    @Then("^The application displays \"([^\"]*)\"$")
    public void theApplicationDisplays(String arg0) {
        MyAccountPage myAccountPage = new MyAccountPage();
        String actual = myAccountPage.getMiCuentaCantidato();
        String expected = arg0;
        assertEquals(expected,actual);
    }
}
