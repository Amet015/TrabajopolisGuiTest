package Trabajopolis;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EducationPage {
    @FindBy(name="EducacionColegio[Institucion][1]")
    WebElement schoolField;

    @FindBy(name="EducacionColegio[NivelEstudio][1]")
    WebElement studioLevelSchoolListBox;

    @FindBy(name="EducacionColegio[pais_0][1]")
    WebElement countrySchoolListBox;

    @FindBy(name="EducacionColegio[ciudad_0][1]")
    WebElement cityField;

    @FindBy(name="EducacionColegio[FechaIngreso][1]")
    WebElement startSchoolField;

    @FindBy(name="EducacionColegio[FechaEgreso][1]")
    WebElement endSchoolField;

    @FindBy(name="EducacionUniversitaria[UniversidadBolivia][1]")
    WebElement universityField;

    @FindBy(name="EducacionUniversitaria[Carrera][1]")
    WebElement careerField;

    @FindBy(name="EducacionUniversitaria[NivelEstudio][1]")
    WebElement studioLevelUniversityListBox;

    @FindBy(name="EducacionUniversitaria[pais_0][1]")
    WebElement countryUniversityListBox;

    @FindBy(name="EducacionUniversitaria[ciudad_0][1]")
    WebElement cityUniversityField;

    @FindBy(name="EducacionUniversitaria[FechaIngreso][1]")
    WebElement StartUniversityField;

    @FindBy(name="EducacionUniversitaria[FechaEgreso][1]")
    WebElement endUniversityField;

    @FindBy(name="idiomas[idioma][1]")
    WebElement languageListBox;

    @FindBy(name="idiomas[nivel_escrito][1]")
    WebElement languagueWritenListBox;

    @FindBy(name="idiomas[nivel_oral][1]")
    WebElement languageOralListBox;

    @FindBy(name="idiomas[nivel_lectura][1]")
    WebElement languageReadingListBox;

    @FindBy(id="btn-add-cv")
    WebElement nextButton;


}
