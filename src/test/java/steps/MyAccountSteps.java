package steps;

import Trabajopolis.PageTransporter;
import Trabajopolis.Pages.EditProfilePage;
import Trabajopolis.Pages.MyAccountPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class MyAccountSteps {
    private MyAccountPage myAccountPage;
    PageTransporter pageTransporter =  new PageTransporter();
    private Map<String, String> searchCriteria = new HashMap<>();
    private EditProfilePage editProfilePage;
    private String oldSalary;
    private String newSalary;

    @Given("^I navitate to My Account Page$")
    public void iNavitateToMyAccountPage() {
        myAccountPage = new MyAccountPage();
        myAccountPage.clickMiPerfil();
        System.out.println("click mi perfil");
    }

    @When("^I edit Mi Perfil")
    public void iEdit(final Map<String, String> searchCriteria) {
        //this.searchCriteria.putAll(searchCriteria);
        //oldSalary = editProfilePage.getSalaryField();
        editProfilePage = new EditProfilePage();
        System.out.println(searchCriteria.get("Salary"));
        String salary =  String.valueOf(searchCriteria.get("Salary"));

        editProfilePage.setSalaryField(salary);
        newSalary = editProfilePage.getSalaryField();
    }

    @And("^I save changes$")
    public void iSaveChanges() {
        editProfilePage.clickSave();
    }

    @Then("^The application displays a message \"([^\"]*)\"$")
    public void theApplicationDisplaysAMessage(String cambios) {
        String expectedMessageSuccesful = cambios;
        String actualMessageSuccesful=  editProfilePage.getMessageSuccesful();
        Assert.assertEquals(actualMessageSuccesful,expectedMessageSuccesful);
    }

    @And("^I reload the page and verify the changes$")
    public void iReloadThePageAndVerifyTheChanges() {
        pageTransporter.navigateEditProfilePage();
        String actualSalary = editProfilePage.getSalaryField();
        String expectedSalary = newSalary;
        Assert.assertEquals(actualSalary,expectedSalary);
    }
}
