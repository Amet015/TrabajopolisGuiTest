package Trabajopolis.Pages;

import Trabajopolis.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import Trabajopolis.components.WebCalendar;

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

    private void setStartSchoolField(String date) {
        startSchoolField.click();
        WebCalendar.setDateCalendar(date, yearListBox, monthListBox);
    }

    private void setEndSchoolField(String date) {
        endSchoolField.click();
        WebCalendar.setDateCalendar(date, yearListBox, monthListBox);
    }

    private void setStartUniversityField(String date) {
        startUniversityField.click();
        WebCalendar.setDateCalendar(date, yearListBox, monthListBox);
    }

    private void setEndUniversityField(String date) {
        endUniversityField.click();
        WebCalendar.setDateCalendar(date, yearListBox, monthListBox);
    }

    public void setFillsEducation(String schoolName, String studioLevel, String countrySchool , String citySchool,
                                  String startSchool, String endSchool, String universityName,
                                  String studioLevelUniversity ,String career, String countryUniversity,
                                  String cityUniversity, String startUniversity, String endUniversity, String language,
                                  String languageWritten, String languageOral, String LanguageReading ) {
        schoolField.sendKeys(schoolName);
        selectValue = new Select(studioLevelSchoolListBox);
        selectValue.selectByValue(studioLevel);
        selectValue = new Select(countrySchoolListBox);
        selectValue.selectByValue(countrySchool);
        citySchoolField.sendKeys(citySchool);
        setStartSchoolField(startSchool);
        setEndSchoolField(endSchool);
        universityField.sendKeys(universityName);
        selectValue = new Select(studioLevelUniversityListBox);
        selectValue.selectByValue(studioLevelUniversity);
        careerField.sendKeys(career);
        selectValue = new Select(countryUniversityListBox);
        selectValue.selectByValue(countryUniversity);
        cityUniversityField.sendKeys(cityUniversity);
        setStartUniversityField(startUniversity);
        setEndUniversityField(endUniversity);
        selectValue = new Select(languageListBox);
        selectValue.selectByValue(language);
        selectValue = new Select(languagueWritenListBox);
        selectValue.selectByValue(languageWritten);
        selectValue = new Select(languageOralListBox);
        selectValue.selectByValue(languageOral);
        selectValue = new Select(languageReadingListBox);
        selectValue.selectByValue(LanguageReading);
    }

    public void clickNextButton() {
        nextButton.click();
    }
}
