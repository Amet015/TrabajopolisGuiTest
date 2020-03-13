package TestTrabajopolis.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import trabajopolis.PageTransporter;
import trabajopolis.pages.LoginPage;
import trabajopolis.pages.MyAccountPage;

import static org.junit.Assert.assertEquals;

public class LoginSteps {
    LoginPage loginPage;
    PageTransporter pageTransporter;

    public LoginSteps() {
        pageTransporter = new PageTransporter();
    }

    @Given("^I go to (.*) with user credentials$")
    public void iLoginToTheApplication(String endPoint) {
        pageTransporter.navigateToPage(endPoint);
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
        assertEquals(expected, actual);
    }
}
