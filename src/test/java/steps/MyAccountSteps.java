package steps;

import Trabajopolis.PageTransporter;
import Trabajopolis.Pages.EditProfilePage;
import Trabajopolis.Pages.EducationPage;
import Trabajopolis.Pages.GeneralInformationPage;
import Trabajopolis.Pages.ManageListingPage;
import Trabajopolis.Pages.MyAccountPage;
import Trabajopolis.Pages.MyListingsPage;
import Trabajopolis.Pages.PersonalInformationPage;
import Trabajopolis.Pages.ResumeDetailsCV;
import Trabajopolis.Pages.ResumeExperiencePage;
import Trabajopolis.entities.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

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

    public MyAccountSteps() {
        context = new Context();
    }

    @Given("^I navitate to My Account Page$")
    public void iNavitateToMyAccountPage() {
        myAccountPage = new MyAccountPage();
        myAccountPage.clickMiPerfil();
    }

    @When("^I edit Mi Perfil")
    public void iEdit(final Map<String, String> dataTableSalary) {
        editProfilePage = new EditProfilePage();
        System.out.println(dataTableSalary.get("Salary"));
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

    @And("^I reload the page and verify the changes$")
    public void iReloadThePageAndVerifyTheChanges() {
        pageTransporter.navigateEditProfilePage();
        String actualSalary = editProfilePage.getSalaryField();
        String expectedSalary = newSalary;
        Assert.assertEquals(actualSalary, expectedSalary);
    }

    @When("^I navigate to Curriculums$")
    public void iNavigateToCurriculums() {
        pageTransporter = new PageTransporter();
        pageTransporter.navigateToMyCurriculums();
    }

    @And("^I create Curriculums in Personal Information page with$")
    public void iCreateCurriculumsInPersonalInformationPageWith(final Map<String, String> mapPersonalInformation) {
        //Set entity information
        PersonalInformation personalInformation = context.getCurriculum().getPersonalInformation();
        personalInformation.processInformation(mapPersonalInformation);

        myListingsPage = new MyListingsPage();
        personalInformationPage = myListingsPage.clickAddCV();

        // ACtion by UI
        personalInformationPage.setPersonalInformation(personalInformation);

    }

    @And("^I fill fields in Resume Experience page with$")
    public void iFillFieldsInResumeExperiencePageWith(final Map<String, String> mapResumeExperience) {
        ResumeExperience resumeExperience = context.getCurriculum().getResumeExperience();
        resumeExperience.proccessInformation(mapResumeExperience);

        resumeExperiencePage = personalInformationPage.clickNextButton();
        resumeExperiencePage.setFillsExperience(resumeExperience);
    }

    @And("^I fill fields in Education Page with$")
    public void iFillFieldsInEducationPageWith(final Map<String, String> mapEducation) {
        Education education = context.getCurriculum().getEducation();
        education.proccessInformation(mapEducation);

        educationPage = resumeExperiencePage.clickNextButton();;
        educationPage.setFillsEducation(education);


    }

    @And("^I fill fields in General Information Page with$")
    public void iFillFieldsInGeneralInformationPageWith(final Map<String, String> mapGeneralInformation) {
        GeneralInformation generalInformation = context.getCurriculum().getGeneralInformation();
        generalInformation.proccessInformation(mapGeneralInformation);

        generalInformationPage =  educationPage.clickNextButton();
        generalInformationPage.setFillsGeneralInformation(generalInformation);

    }

    @Then("^The application displays a page with a button \"([^\"]*)\"$")
    public void theApplicationDisplaysAPageWithAButton(String arg0) throws Throwable {
        manageListingPage = generalInformationPage.clickNextButton();;
        String actual = manageListingPage.getDonwLadCVText();
        String expected = "DESCARGAR CURRÍCULUM EN PDF";
        Assert.assertEquals(actual, expected);
    }

    @And("^The Curriculum is created with the basic information entered$")
    public void theCurriculumIsCreatedWithTheBasicInformationEntered() {
        resumeDetailsCV = manageListingPage.clickLookMyCV();

        Assert.assertTrue(resumeDetailsCV.getAddress().contains(context.getCurriculum().getPersonalInformation().getAddress()) &&
                resumeDetailsCV.getIdType().contains(context.getCurriculum().getPersonalInformation().getIdType()) &&
                resumeDetailsCV.getMaritalStatus().contains(context.getCurriculum().getPersonalInformation()
                        .getMaritalStatus().replace("(a)", "")) && resumeDetailsCV.getCompanyCharge()
                .contains(context.getCurriculum().getResumeExperience().getCompanyCharge()) && resumeDetailsCV.getCompanyName()
                .contains(context.getCurriculum().getResumeExperience().getCompanyName()) && resumeDetailsCV.getLanguagues()
                .contains(context.getCurriculum().getEducation().getLanguage()) && resumeDetailsCV.getLanguagues()
                .contains(context.getCurriculum().getEducation().getLanguageOral()));
    }

    @And("^I delete Curriculum$")
    public void iDeleteCurriculum() {
        pageTransporter.navigateToMyAccountPage();
        myAccountPage = new MyAccountPage();
        myAccountPage.clickMisCurriculos();
        myListingsPage.clickDeleteCV();
    }
}
