package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.HashMap;
import java.util.Map;

public class SearchSteps {

    private HashMap<String, String> searchCriteria = new HashMap<>();


    @When("^I go to buscar empleos section$")
    public void goToBuscarEmpleosSection(final Map<String, String> searchCriteria) {
        this.searchCriteria.putAll(searchCriteria);

        // Paginas para la busqueda
        //searchPAge.setCategory(searchCriteria.get("CAtegory"));


    }

    @Then("^The application displays a page with name board \"([^\"]*)\"$")
    public void theApplicationDisplaysAPageWithNameBoard(String arg0) throws Throwable {
        String expectedCategory = searchCriteria.get("CAtegory");

        // Logica para abrir y cerrar distintos jobs y realizar las validaciones

        // String actualCategories = jobPage.getCategories();

        /*Assert.assertTrue(actualCategories.contains(expectedCategory),
                "The job " + jobName + " doesn't have the expected category: " + expectedCategory
                        + ". The categories for the job are: " + actualCategories);*/
    }


    @And("^I search the Job$")
    public void iSearchTheJob() {
    }

    @When("^I go to Home Page and fill the fields with$")
    public void iGoToHomePageAndFillTheFieldsWith() {
    }


}
