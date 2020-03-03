package Trabajopolis.Pages;

import Trabajopolis.BasePage;
import Trabajopolis.entities.Education;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import Trabajopolis.components.WebComponents;

public class EducationPage extends BasePage {
    @FindBy(name = "EducacionColegio[Institucion][1]")
    WebElement schoolField;

    @FindBy(name = "EducacionColegio[NivelEstudio][1]")
    WebElement studioLevelSchoolListBox;

    @FindBy(name = "EducacionColegio[pais_0][1]")
    WebElement countrySchoolListBox;

    @FindBy(name = "EducacionColegio[ciudad_0][1]")
    WebElement citySchoolField;

    @FindBy(name = "EducacionColegio[FechaIngreso][1]")
    WebElement startSchoolField;

    @FindBy(name = "EducacionColegio[FechaEgreso][1]")
    WebElement endSchoolField;

    @FindBy(name = "EducacionUniversitaria[UniversidadBolivia][1]")
    WebElement universityField;

    @FindBy(name = "EducacionUniversitaria[Carrera][1]")
    WebElement careerField;

    @FindBy(name = "EducacionUniversitaria[NivelEstudio][1]")
    WebElement studioLevelUniversityListBox;

    @FindBy(name = "EducacionUniversitaria[pais_0][1]")
    WebElement countryUniversityListBox;

    @FindBy(name = "EducacionUniversitaria[ciudad_0][1]")
    WebElement cityUniversityField;

    @FindBy(name = "EducacionUniversitaria[FechaIngreso][1]")
    WebElement startUniversityField;

    @FindBy(name = "EducacionUniversitaria[FechaEgreso][1]")
    WebElement endUniversityField;

    @FindBy(name = "idiomas[idioma][1]")
    WebElement languageListBox;

    @FindBy(name = "idiomas[nivel_escrito][1]")
    WebElement languagueWritenListBox;

    @FindBy(name = "idiomas[nivel_oral][1]")
    WebElement languageOralListBox;

    @FindBy(name = "idiomas[nivel_lectura][1]")
    WebElement languageReadingListBox;

    @FindBy(id = "btn-add-cv")
    WebElement nextButton;

    @FindBy(css = "select.ui-datepicker-month")
    WebElement monthListBox;

    @FindBy(css = "select.ui-datepicker-year")
    WebElement yearListBox;

    Select selectValue;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(schoolField));
    }

    private void setSchool(String schoolName) {
        schoolField.sendKeys(schoolName);
    }

    private void setStudioLevelSchool(String studioLevel) {
        selectValue = new Select(studioLevelSchoolListBox);
        selectValue.selectByValue(studioLevel);
    }

    private void setCountrySchool(String country) {
        selectValue = new Select(countrySchoolListBox);
        selectValue.selectByValue(country);
    }

    private void setCitySchool(String city) {
        citySchoolField.sendKeys(city);
    }

    private void setStartSchool(String date) {
        startSchoolField.click();
        WebComponents.setDateCalendar(date, yearListBox, monthListBox);
    }

    private void setEndSchool(String date) {
        endSchoolField.click();
        WebComponents.setDateCalendar(date, yearListBox, monthListBox);
    }

    private void setUniversity(String university) {
        universityField.sendKeys(university);
    }

    private void setStudioLevelUniversity(String studioLevelUniversity) {
        selectValue = new Select(studioLevelUniversityListBox);
        selectValue.selectByValue(studioLevelUniversity);
    }

    private void setCareer(String career) {
        careerField.sendKeys(career);
    }

    private void setCountryUniversity(String countryUniversity) {
        selectValue = new Select(countryUniversityListBox);
        selectValue.selectByValue(countryUniversity);
    }

    private void setCityUniversity(String cityUniversity) {
        cityUniversityField.sendKeys(cityUniversity);
    }

    private void setStartUniversity(String date) {
        startUniversityField.click();
        WebComponents.setDateCalendar(date, yearListBox, monthListBox);
    }

    private void setEndUniversity(String date) {
        endUniversityField.click();
        WebComponents.setDateCalendar(date, yearListBox, monthListBox);
    }

    private void setLanguage(String language) {
        selectValue = new Select(languageListBox);
        selectValue.selectByValue(language);
    }

    private void setLanguageWritten(String languagueWriten) {
        selectValue = new Select(languagueWritenListBox);
        selectValue.selectByValue(languagueWriten);
    }
    private void setLanguageOral(String languageOral) {
        selectValue = new Select(languageOralListBox);
        selectValue.selectByValue(languageOral);
    }

    public void setLanguageReading(String languageReading) {
        selectValue = new Select(languageReadingListBox);
        selectValue.selectByValue(languageReading);
    }

    public void setFillsEducation(Education education) {
        setSchool(education.getSchool());
        setStudioLevelSchool(education.getStudioLevelSchool());
        setCountrySchool(education.getCountrySchool());
        setCitySchool(education.getCitySchool());
        setStartSchool(education.getStartSchool());
        setEndSchool(education.getEndSchool());
        setUniversity(education.getUniversity());
        setStudioLevelUniversity(education.getStudioLevelUniversity());
        setCareer(education.getCareer());
        setCountryUniversity(education.getCountryUniversity());
        setCityUniversity(education.getCityUniversity());
        setStartUniversity(education.getStartUniversity());
        setEndUniversity(education.getEndUniversity());
        setLanguage(education.getLanguage());
        setLanguageWritten(education.getLanguageWritten());
        setLanguageOral(education.getLanguageOral());
        setLanguageReading(education.getLanguageReading());

    }

    public GeneralInformationPage clickNextButton() {
        nextButton.click();
        return new GeneralInformationPage();
    }
}
