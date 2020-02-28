// Generated by Selenium IDE

import Core.WebDriverManager;
import Trabajopolis.*;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrabajopolisLoginTest {

  @After
  public void afterTest(){
    WebDriverManager.getInstance().quitWebDriver();
  }

  @Test
  public void login_trabajopolis() {
    LoginPage loginPage = new LoginPage();
    loginPage.test_login();
    MyAccountPage myAccountPage = new MyAccountPage();
    String expected = myAccountPage.getMiCuentaCantidato();
    String actual = "Mi Perfil";
    assertEquals(expected,actual);
  }

  @Test
  public void search_trabajopolis() {
    LoginPage loginPage = new LoginPage();
    loginPage.test_login();
    MyAccountPage myAccountPage = new MyAccountPage();
    myAccountPage.clickBuscarEmpleos();
    BuscarEmpleosPage buscarEmpleosPage = new BuscarEmpleosPage();
    buscarEmpleosPage.selectCategory("Informática");
    buscarEmpleosPage.selectPostedWithin("30");
    buscarEmpleosPage.clickSearchJob();
    SearchResultJobPage searchResultJobPage = new SearchResultJobPage();
    String actual = searchResultJobPage.getResultTitle();
    String expected = "Resultados de Búsqueda de Empleos";
    assertEquals(expected,actual);
  }

  @Test
  public void search_ThroughtHomePage(){
    LoginPage loginPage = new LoginPage();
    loginPage.test_login();
    MyAccountPage myAccountPage = new MyAccountPage();
    myAccountPage.clickInicio();
    HomePage homePage = new HomePage();
    homePage.setCategory("Internet");
    homePage.setCityListBox("Cochabamba");
    homePage.setEmployementTypeListBox("Full time");
    homePage.setPostedWithinListBox("30");
    homePage.clickSearch();
    SearchResultJobPage searchResultJobPage = new SearchResultJobPage();
    String actual = searchResultJobPage.getResultTitle();
    String expected = "Resultados de Búsqueda de Empleos";
    assertEquals(expected,actual);

  }

  @Test
  public void create_Curriculum(){
    LoginPage loginPage = new LoginPage();
    loginPage.test_login();
    MyAccountPage myAccountPage = new MyAccountPage();
    myAccountPage.clickMisCurriculos();
    MyListingsPage myListingsPage = new MyListingsPage();
    myListingsPage.clickAddCV();
    PersonalInformationPage personalInformationPage = new PersonalInformationPage();
    personalInformationPage.selectIdType("Pasaporte");
    personalInformationPage.setAddressField("c/ laredo");
    personalInformationPage.selectMaritalStatus("Soltero(a)");
    personalInformationPage.clickNextButton();
    ResumeExperiencePage resumeExperiencePage = new ResumeExperiencePage();
    resumeExperiencePage.setCompanyCharge("ingeniero");
    resumeExperiencePage.setCompanyName("entel");
    resumeExperiencePage.selectIndustry("Ingeniería");
    resumeExperiencePage.setCountryExperience("Bolivia");
    resumeExperiencePage.setCityExperience("cochabamba");
    resumeExperiencePage.setStartDate("2/3/2015");
    resumeExperiencePage.setEndDate("2/3/2016");
    resumeExperiencePage.clickNextButton();
    EducationPage educationPage = new EducationPage();
    educationPage.setSchoolField("Sarmiento");
    educationPage.setStudioLevelSchoolListBox("Bachiller en Humanidades");
    educationPage.setCountrySchoolListBox("Bolivia");
    educationPage.setCitySchoolField("Cochabamba");
    educationPage.setStartSchoolField("2/10/1997");
    educationPage.setEndSchoolField("11/25/2008");
    educationPage.setUniversityField("univalle");
    educationPage.setCareerField("Telecomunicaciones");
    educationPage.setCountryUniversityListBox("Bolivia");
    educationPage.setCityUniversityField("Cochabamba");
    educationPage.setStudioLevelUniversityListBox("Licenciatura");
    educationPage.setStartUniversityField("2/10/2009");
    educationPage.setEndUniversityField("10/30/2014");
    educationPage.setLanguageListBox("Español");
    educationPage.setLanguagueWritenListBox("Medio");
    educationPage.setLanguageOralListBox("Medio");
    educationPage.setLanguageReadingListBox("Medio");
    educationPage.clickNextutton();
    GeneralInformationPage generalInformationPage = new GeneralInformationPage();
    generalInformationPage.setTitleField("Ingeniero");
    generalInformationPage.setCategoryListBox("Internet");
    generalInformationPage.setContractListBox("full time");
    generalInformationPage.setSalaryField("4000");
    generalInformationPage.setCountryListBox("Bolivia");
    generalInformationPage.setCityListBox("Cochabamba");
    generalInformationPage.setPrivacityCV("Todas las Empresas - Visible en la Base de Datos de CVs");
    generalInformationPage.clickNextButton();
    ManageListingPage manageListingPage = new ManageListingPage();
    String actual = manageListingPage.getDonwLadCVText();
    String expected = "DESCARGAR CURRÍCULUM EN PDF";

    assertEquals(expected,actual);

    PageTransporter pageTransporter = new PageTransporter();
    pageTransporter.navigateToMyAccountPage();
    myAccountPage.clickMisCurriculos();
    myListingsPage.clickDeleteCV();
  }

  @Test
  public void edit_EditSalary() {
    String newSalary = "4000";
    LoginPage loginPage = new LoginPage();
    loginPage.test_login();
    MyAccountPage myAccountPage = new MyAccountPage();
    myAccountPage.clickMiPerfil();
    EditProfilePage editProfilePage = new EditProfilePage();
    String salaryOld = editProfilePage.getSalaryField();
    editProfilePage.setSalaryField(newSalary);
    String actualSalary = editProfilePage.getSalaryField();
    editProfilePage.clickSave();
    String messageExpected = "Guardados los cambios del perfil";
    String messageActual = editProfilePage.getMessageSuccesful();
    assertEquals(messageExpected,messageActual);
    assertEquals(newSalary,actualSalary);

    PageTransporter pageTransporter = new PageTransporter();
    pageTransporter.navigateEditProfilePage();
    editProfilePage.setSalaryField(salaryOld);
    editProfilePage.clickSave();

  }
}
