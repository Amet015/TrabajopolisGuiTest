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
import Trabajopolis.entities.Context;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.Map;

public class MyAccountSteps {
    private MyAccountPage myAccountPage;
    PageTransporter pageTransporter =  new PageTransporter();
    //private Map<String, String> searchCriteria = new HashMap<>();
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

    public MyAccountSteps(){
        context = new Context();
    }

    @Given("^I navitate to My Account Page$")
    public void iNavitateToMyAccountPage() {
        myAccountPage = new MyAccountPage();
        myAccountPage.clickMiPerfil();
        System.out.println("click mi perfil");
    }

    @When("^I edit Mi Perfil")
    public void iEdit(final Map<String, String> dataTableSalary) {
        editProfilePage = new EditProfilePage();
        System.out.println(dataTableSalary.get("Salary"));
        String salary =  String.valueOf(dataTableSalary.get("Salary"));

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
    public void iReloadThePageAndVerifyTheChanges(final Map<String, String> dtPersonalInformationa) {
        pageTransporter.navigateEditProfilePage();
        String actualSalary = editProfilePage.getSalaryField();
        String expectedSalary = newSalary;
        Assert.assertEquals(actualSalary,expectedSalary);
    }

    @When("^I navigate to Curriculums$")
    public void iNavigateToCurriculums() {
        pageTransporter = new PageTransporter();
        pageTransporter.navigateToMyCurriculums();
    }

    @And("^I create Curriculums in Personal Information page with$")
    public void iCreateCurriculumsInPersonalInformationPageWith(final Map<String, String> dtPersonalInformation) {
        myListingsPage = new MyListingsPage();
        myListingsPage.clickAddCV();

        String id = dtPersonalInformation.get("Id");
        String address = dtPersonalInformation.get("Address");
        String maritalStatus = dtPersonalInformation.get("Marital Status");

        context.getPersonalInformation().setIdType(id);
        context.getPersonalInformation().setAddress(address);
        context.getPersonalInformation().setMaritalStatus(maritalStatus);
        personalInformationPage = new PersonalInformationPage();
        personalInformationPage.selectIdType(id);
        personalInformationPage.setAddressField(address);
        personalInformationPage.selectMaritalStatus(maritalStatus);
        personalInformationPage.clickNextButton();
    }

    @And("^I fill fields in Resume Experience page with$")
    public void iFillFieldsInResumeExperiencePageWith(final Map<String, String> dtResumeExperience) {
        String companyCharge = dtResumeExperience.get("Company Charge");
        String companyName = dtResumeExperience.get("Company Name");
        String industry = dtResumeExperience.get("Industry");
        String country = dtResumeExperience.get("Country");
        String city = dtResumeExperience.get("City");
        String startDateSchool = dtResumeExperience.get("Start Date School");
        String endDateSchool = dtResumeExperience.get("End Date School");
        context.getResumeExperience().setCompanyCharge(companyCharge);
        context.getResumeExperience().setCompanyName(companyName);
        context.getResumeExperience().setIndustry(industry);
        context.getResumeExperience().setCountryExperience(country);
        context.getResumeExperience().setCityExperience(city);
        context.getResumeExperience().setStartDate(startDateSchool);
        context.getResumeExperience().setEndDate(endDateSchool);

        resumeExperiencePage = new ResumeExperiencePage();
        resumeExperiencePage.setFillsExperience(companyCharge,companyName, industry, country, city, startDateSchool,
                endDateSchool);
        resumeExperiencePage.clickNextButton();

    }

    @And("^I fill fields in Education Page with$")
    public void iFillFieldsInEducationPageWith(final Map<String, String> dtEducation) {
        String school = dtEducation.get("School");
        String studioLevelSchool = dtEducation.get("Studio Level School");
        String countrySchool = dtEducation.get("Country School");
        String citySchool = dtEducation.get("City School");
        String starDateSchool = dtEducation.get("Start Date School");
        String endDateSchool = dtEducation.get("End Date School");
        String university = dtEducation.get("University");
        String studioLevelUniversity = dtEducation.get("Studio Level University");
        String career = dtEducation.get("Career");
        String countryUniversity = dtEducation.get("Country University");
        String cityUniversity = dtEducation.get("City University");
        String startDateUniversity = dtEducation.get("Start Date University");
        String endDateUniversity = dtEducation.get("End Date University");
        String language = dtEducation.get("Language");
        String languageWritten = dtEducation.get("Language Written");
        String laguageOral = dtEducation.get("Language Oral");
        String languageReading = dtEducation.get("Language Reading");
        context.getEducation().setSchool(school);
        context.getEducation().setStudioLevelSchool(studioLevelSchool);
        context.getEducation().setCountrySchool(countrySchool);
        context.getEducation().setCitySchool(citySchool);
        context.getEducation().setStartSchool(starDateSchool);
        context.getEducation().setEndSchool(endDateSchool);
        context.getEducation().setUniversity(university);
        context.getEducation().setStudioLevelUniversity(studioLevelUniversity);
        context.getEducation().setCareer(career);
        context.getEducation().setCountryUniversity(countryUniversity);
        context.getEducation().setCityUniversity(cityUniversity);
        context.getEducation().setStartUniversity(startDateUniversity);
        context.getEducation().setEndUniversity(endDateUniversity);
        context.getEducation().setLanguage(language);
        context.getEducation().setLanguageWritten(languageWritten);
        context.getEducation().setLanguageOral(laguageOral);
        context.getEducation().setLanguageReading(languageReading);

        educationPage = new EducationPage();
        educationPage.setFillsEducation(school, studioLevelSchool, countrySchool, citySchool, starDateSchool,
                endDateSchool, university, studioLevelUniversity, career, countryUniversity, cityUniversity,
                startDateUniversity, endDateUniversity, language, languageWritten, laguageOral, languageReading);
        educationPage.clickNextButton();

    }

    @And("^I fill fields in General Information Page with$")
    public void iFillFieldsInGeneralInformationPageWith(final Map<String, String> dtGeneralInformation) {
        String title = dtGeneralInformation.get("Title");
        String category = dtGeneralInformation.get("Category");
        String contractType = dtGeneralInformation.get("Contract Type");
        String salary = dtGeneralInformation.get("Salary");
        String country = dtGeneralInformation.get("Country");
        String city = dtGeneralInformation.get("City");
        String privacityCV= dtGeneralInformation.get("PrivacityCV");

        context.getGeneralInformation().setTitle(title);
        context.getGeneralInformation().setCategory(category);
        context.getGeneralInformation().setContractType(contractType);
        context.getGeneralInformation().setSalary(salary);
        context.getGeneralInformation().setCountry(country);
        context.getGeneralInformation().setCity(city);
        context.getGeneralInformation().setPrivacityCV(privacityCV);

        generalInformationPage = new GeneralInformationPage();
        generalInformationPage.setFillsGeneralInformation(title, category, contractType, salary,
                country, city, privacityCV);
        generalInformationPage.clickNextButton();

    }

    @Then("^The application displays a page with a button \"([^\"]*)\"$")
    public void theApplicationDisplaysAPageWithAButton(String arg0) throws Throwable {
        ManageListingPage manageListingPage = new ManageListingPage();
        String actual = manageListingPage.getDonwLadCVText();
        String expected = "DESCARGAR CURRÍCULUM EN PDF";
        Assert.assertEquals(actual,expected);
    }

    @And("^The Curriculum is created with the basic information entered$")
    public void theCurriculumIsCreatedWithTheBasicInformationEntered() {
        manageListingPage = new ManageListingPage();
        manageListingPage.clickLookMyCV();
        resumeDetailsCV = new ResumeDetailsCV();

        Assert.assertTrue(resumeDetailsCV.getAddress().contains(context.getPersonalInformation().getAddress()) &&
                resumeDetailsCV.getIdType().contains(context.getPersonalInformation().getIdType()) &&
                resumeDetailsCV.getMaritalStatus().contains( context.getPersonalInformation()
                        .getMaritalStatus().replace("(a)",""))&& resumeDetailsCV.getCompanyCharge()
                .contains(context.getResumeExperience().getCompanyCharge()) && resumeDetailsCV.getCompanyName()
                .contains(context.getResumeExperience().getCompanyName()) && resumeDetailsCV.getLanguagues()
                .contains(context.getEducation().getLanguage())&&resumeDetailsCV.getLanguagues()
                .contains(context.getEducation().getLanguageOral()) );
    }

    @And("^I delete Curriculum$")
    public void iDeleteCurriculum() {
        pageTransporter.navigateToMyAccountPage();
        myAccountPage = new MyAccountPage();
        myAccountPage.clickMisCurriculos();
        myListingsPage.clickDeleteCV();
    }



}
