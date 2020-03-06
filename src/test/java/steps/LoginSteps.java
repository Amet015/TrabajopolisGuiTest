package steps;

import core.WebDriverManager;
import trabajopolis.PageTransporter;
import trabajopolis.pages.LoginPage;
import trabajopolis.pages.MyAccountPage;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class LoginSteps {
    LoginPage loginPage;
    PageTransporter pageTransporter;

    public LoginSteps(){
        pageTransporter = new PageTransporter();
    }

    @After
    public void afterTest(){
        WebDriverManager.getInstance().quitWebDriver();
    }

    @Given("^I go to Login page$")
    public void iLoginToTheApplication() {

        pageTransporter.navigateToLoginPage();
    }

    @When("^I insert the credentials$")
    public void iInsertTheCredentials() {
        loginPage = new LoginPage();
        loginPage.test_login();
    }

    @Then("^The application displays \"([^\"]*)\"$")
    public void theApplicationDisplays(String miPerfil) {
        MyAccountPage myAccountPage = new MyAccountPage();
        String actual = myAccountPage.getMiCuentaCantidato();
        String expected = miPerfil;
        assertEquals(expected,actual);
    }
}
