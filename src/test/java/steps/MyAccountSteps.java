package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import trabajopolis.PageTransporter;
import trabajopolis.pages.*;
import trabajopolis.entities.*;
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class MyAccountSteps {
    private MyAccountPage myAccountPage;
    PageTransporter pageTransporter = new PageTransporter();
    private EditProfilePage editProfilePage;
    private String newSalary;
    private MyListingsPage myListingsPage;
    private ManageListingPage manageListingPage;
    private PersonalInformationPage personalInformationPage;
    private ResumeExperiencePage resumeExperiencePage;
    private EducationPage educationPage;
    private GeneralInformationPage generalInformationPage;
    private ResumeDetailsCV resumeDetailsCV;
    private Context context;
    private SearchJobPage searchJobPage;
    private SearchResultJobPage searchResultJobPage;
    private PopUpPage popUpPage;
    private SearchingSaved searchingSaved;
    private Map<String, String> mapPersonalInformation;

    public MyAccountSteps(Context context) {
        this.context = context;
    }

    @Given("^I navitate to My Account Page$")
    public void iNavitateToMyAccountPage() {
        myAccountPage = new MyAccountPage();
        myAccountPage.clickMiPerfil();
        mapPersonalInformation = new HashMap<>();
    }

    @When("^I edit Mi Perfil")
    public void iEdit(final Map<String, String> dataTableSalary) {
        editProfilePage = new EditProfilePage();
        String salary = dataTableSalary.get("Salary");
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
        String actualMessageSuccesful = editProfilePage.getMessageSuccesful();
        Assert.assertEquals(actualMessageSuccesful, expectedMessageSuccesful);
    }

    @And("^I reload the page (.*) and verify the changes$")
    public void iReloadThePageAndVerifyTheChanges(String endPoint) {
        pageTransporter.navigateToPage(endPoint);
        String actualSalary = editProfilePage.getSalaryField();
        String expectedSalary = newSalary;
        Assert.assertEquals(actualSalary, expectedSalary);
    }

    @When("^I navigate to (.*)$")
    public void iNavigateToCurriculums(String endPoint) {
        pageTransporter.navigateToPage(endPoint);
    }

    @And("^I create Curriculums in Personal Information page with$")
    public void iCreateCurriculumsInPersonalInformationPageWith(final Map<String, String> mapPersonalInformation) {
        this.mapPersonalInformation = mapPersonalInformation;
        PersonalInformation personalInformation = context.getCurriculum().getPersonalInformation();
        personalInformation.processInformation(mapPersonalInformation);

        myListingsPage = new MyListingsPage();
        personalInformationPage = myListingsPage.clickAddCV();

        personalInformationPage.setPersonalInformation(personalInformation, mapPersonalInformation.keySet());
    }

    @And("^I fill fields in Resume Experience page with$")
    public void iFillFieldsInResumeExperiencePageWith(final Map<String, String> mapResumeExperience) {
        ResumeExperience resumeExperience = context.getCurriculum().getResumeExperience();
        resumeExperience.proccessInformation(mapResumeExperience);

        resumeExperiencePage = personalInformationPage.clickNextButton();
        resumeExperiencePage.setFillsExperience(resumeExperience, mapResumeExperience.keySet());
    }

    @And("^I fill fields in Education Page with$")
    public void iFillFieldsInEducationPageWith(final Map<String, String> mapEducation) {
        Education education = context.getCurriculum().getEducation();
        education.proccessInformation(mapEducation);

        educationPage = resumeExperiencePage.clickNextButton();
        ;
        educationPage.setFillsEducation(education, mapEducation.keySet());
    }

    @And("^I fill fields in General Information Page with$")
    public void iFillFieldsInGeneralInformationPageWith(final Map<String, String> mapGeneralInformation) {
        GeneralInformation generalInformation = context.getCurriculum().getGeneralInformation();
        generalInformation.proccessInformation(mapGeneralInformation);

        generalInformationPage = educationPage.clickNextButton();
        generalInformationPage.setFillsGeneralInformation(generalInformation, mapGeneralInformation.keySet());
    }

    @Then("^The application displays a page with a button \"([^\"]*)\"$")
    public void theApplicationDisplaysAPageWithAButton(String descargarCV) {
        manageListingPage = generalInformationPage.clickNextButton();
        String actual = manageListingPage.getDonwLadCVText();
        String expected = descargarCV;
        Assert.assertEquals(actual, expected);
    }

    @And("^The Curriculum is created with the basic information entered$")
    public void theCurriculumIsCreatedWithTheBasicInformationEntered() {
        resumeDetailsCV = manageListingPage.clickLookMyCV();
        resumeDetailsCV.setIdType(mapPersonalInformation.get("Id"));
        HashMap<String, String> validatePersonalInformation = resumeDetailsCV.getPersonalInformationToValidate();
        HashMap<String, String> validateResumeExperience = resumeDetailsCV.getResumeExperienceToValidate();
        HashMap<String, String> validateEducation = resumeDetailsCV.getEducationToValidate();
        HashMap<String, String> validateGeneralInformation = resumeDetailsCV.getGeneralInformationToValidate();

        Assert.assertEquals(validatePersonalInformation, context.getCurriculum().getPersonalInformation().processInformationToGet());
        Assert.assertEquals(validateGeneralInformation, context.getCurriculum().getGeneralInformation().processInformationToGet());
        Assert.assertEquals(validateResumeExperience, context.getCurriculum().getResumeExperience().processInformationToGet());
        Assert.assertEquals(validateEducation, context.getCurriculum().getEducation().processInformationToGet());
    }

    @And("^I delete it$")
    public void iDeleteCurriculum() {
        myListingsPage.clickDeleteCV();
    }

    @Given("^I go to (.*) Page$")
    public void iGoToMyAccountPage(String endPoint) {
        pageTransporter.navigateToPage(endPoint);
        myAccountPage = new MyAccountPage();

    }

    @And("^I go to Buscar Empleos$")
    public void iGoToBuscarEmpleos() {
        searchJobPage = myAccountPage.clickBuscarEmpleos();
    }

    @And("^I search the Job with the following$")
    public void iSearchTheJobWithTheFollowing(final Map<String, String> mapSearchJob) {
        SearchJob searchJob = context.getSearchJob();
        searchJob.proccessInformation(mapSearchJob);

        searchJobPage.setFillsSearchJob(searchJob,mapSearchJob.keySet());
        searchResultJobPage = searchJobPage.clickSearchJob();
    }

    @When("^I go Guardar Esta Busqueda$")
    public void iGoGuardarEstaBusqueda() {
        popUpPage = searchResultJobPage.clickSaveThisSearching();
    }

    @And("^I give the name \"([^\"]*)\"$")
    public void iGiveTheName(String name) throws Throwable {
        popUpPage.setSearchName(name);
        PopUp popUp = context.getPopUp();
        popUp.setNameOfSearching(name);
    }

    @Then("^I go to Busquedas guardadas and verify the searches saved$")
    public void iVerifyTheSearchingSaved() {
        searchingSaved = myAccountPage.clickMySearchingSaved();
        String actual = searchingSaved.getSearched(context.getPopUp().getNameOfSearching());
        String expected = context.getPopUp().getNameOfSearching();
        Assert.assertEquals(actual,expected);
    }

    @And("^I delete the searching saved$")
    public void iDeleteTheSearchingSaved() throws InterruptedException {
        searchingSaved.clickDelete();
    }


}
