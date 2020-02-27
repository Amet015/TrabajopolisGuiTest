package Trabajopolis;

import Core.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utils.WebCalendar;

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

    public void setSchoolField(String schoolName) {
        schoolField.sendKeys(schoolName);
    }

    public void setStudioLevelSchoolListBox(String studioLevel) {
        selectValue = new Select(studioLevelSchoolListBox);
        selectValue.selectByValue(studioLevel);
    }

    public void setCountrySchoolListBox(String country) {
        selectValue = new Select(countrySchoolListBox);
        selectValue.selectByValue(country);
    }

    public void setCitySchoolField(String city) {
        citySchoolField.sendKeys(city);
    }

    public void setStartSchoolField(String date) {
        startSchoolField.click();
        WebCalendar.setDateCalendar(date, yearListBox, monthListBox);
    }

    public void setEndSchoolField(String date) {
        endSchoolField.click();
        WebCalendar.setDateCalendar(date, yearListBox, monthListBox);
    }

    public void setUniversityField(String university) {
        universityField.sendKeys(university);
    }

    public void setStudioLevelUniversityListBox(String studioLevelUniversity) {
        selectValue = new Select(studioLevelUniversityListBox);
        selectValue.selectByValue(studioLevelUniversity);
    }

    public void setCareerField(String career) {
        careerField.sendKeys(career);
    }

    public void setCountryUniversityListBox(String countryUniversity) {
        selectValue = new Select(countryUniversityListBox);
        selectValue.selectByValue(countryUniversity);
    }

    public void setCityUniversityField(String cityUniversity) {
        cityUniversityField.sendKeys(cityUniversity);
    }

    public void setStartUniversityField(String date) {
        startUniversityField.click();
        WebCalendar.setDateCalendar(date, yearListBox, monthListBox);
    }

    public void setEndUniversityField(String date) {
        endUniversityField.click();
        WebCalendar.setDateCalendar(date, yearListBox, monthListBox);
    }

    public void setLanguageListBox(String language) {
        selectValue = new Select(languageListBox);
        selectValue.selectByValue(language);
    }

    public void setLanguagueWritenListBox(String languagueWriten) {
        selectValue = new Select(languagueWritenListBox);
        selectValue.selectByValue(languagueWriten);
    }

    public void setLanguageOralListBox(String languageOral) {
        selectValue = new Select(languageOralListBox);
        selectValue.selectByValue(languageOral);
    }

    public void setLanguageReadingListBox(String languageReading) {
        selectValue = new Select(languageReadingListBox);
        selectValue.selectByValue(languageReading);
    }

    public void clickNextutton() {
        nextButton.click();
    }
}
