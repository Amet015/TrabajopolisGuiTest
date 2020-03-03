package Trabajopolis.entities;

import Trabajopolis.Utils.WebUtils;
import Trabajopolis.components.WebComponents;
import org.graalvm.compiler.replacements.StandardGraphBuilderPlugins;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Education {
    private String school;
    private String studioLevelSchool;
    private String countrySchool;
    private String citySchool;
    private String startSchool;
    private String endSchool;
    private String university;
    private String career;
    private String studioLevelUniversity;
    private String countryUniversity;
    private String cityUniversity;
    private String startUniversity;
    private String endUniversity;
    private String language;
    private String languageWritten;
    private String languageOral;
    private String languageReading;

    private WebUtils webUtils;
    private ArrayList<String> educationList = new ArrayList<>();

    private final String SCHOOL_FORM = "%s\n" +
            "%s, desde %s %s hasta %s %s\n" +
            "%s, %s";
    private final String UNIVERSITY_FORM = "%s (%s)\n" +
            "%s, desde %s %s hasta %s %s\n" +
            "%s, %s";
    private final String LANGUAGE_FORM = "%sNivel Oral: %sNivel Escrito: %sNivel Lectura: %s";

    public Education(){
        webUtils = new WebUtils();
    }


    private void fillListEducation(){
        String school = String.format(SCHOOL_FORM, getStudioLevelSchool(), getSchool(),
                webUtils.getMonthWritten(getStartSchool()), webUtils.getYear(getStartSchool()),
                webUtils.getMonthWritten(getEndSchool()), webUtils.getYear(getEndSchool()), getCitySchool(),
                getCountrySchool());

        String university = String.format(UNIVERSITY_FORM, getCareer(), getStudioLevelUniversity(), getUniversity(),
                webUtils.getMonthWritten(getStartUniversity()), webUtils.getYear(getStartUniversity()),
                webUtils.getMonthWritten(getEndUniversity()), webUtils.getYear(getEndUniversity()),
                getCityUniversity(), getCountryUniversity());
        educationList.add(university);
        educationList.add(school);
        Collections.sort(educationList);
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getStudioLevelSchool() {
        return studioLevelSchool;
    }

    public void setStudioLevelSchool(String studioLevelSchool) {
        this.studioLevelSchool = studioLevelSchool;
    }

    public String getCountrySchool() {
        return countrySchool;
    }

    public void setCountrySchool(String countrySchool) {
        this.countrySchool = countrySchool;
    }

    public String getCitySchool() {
        return citySchool;
    }

    public void setCitySchool(String citySchool) {
        this.citySchool = citySchool;
    }

    public String getStartSchool() {
        return startSchool;
    }

    public void setStartSchool(String startSchool) {
        this.startSchool = startSchool;
    }

    public String getEndSchool() {
        return endSchool;
    }

    public void setEndSchool(String endSchool) {
        this.endSchool = endSchool;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getStudioLevelUniversity() {
        return studioLevelUniversity;
    }

    public void setStudioLevelUniversity(String studioLevelUniversity) {
        this.studioLevelUniversity = studioLevelUniversity;
    }

    public String getCountryUniversity() {
        return countryUniversity;
    }

    public void setCountryUniversity(String countryUniversity) {
        this.countryUniversity = countryUniversity;
    }

    public String getCityUniversity() {
        return cityUniversity;
    }

    public void setCityUniversity(String cityUniversity) {
        this.cityUniversity = cityUniversity;
    }

    public String getStartUniversity() {
        return startUniversity;
    }

    public void setStartUniversity(String startUniversity) {
        this.startUniversity = startUniversity;
    }

    public String getEndUniversity() {
        return endUniversity;
    }

    public void setEndUniversity(String endUniversity) {
        this.endUniversity = endUniversity;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguageWritten() {
        return languageWritten;
    }

    public void setLanguageWritten(String languageWritten) {
        this.languageWritten = languageWritten;
    }

    public String getLanguageOral() {
        return languageOral;
    }

    public void setLanguageOral(String languageOral) {
        this.languageOral = languageOral;
    }

    public String getLanguageReading() {
        return languageReading;
    }

    public void setLanguageReading(String languageReading) {
        this.languageReading = languageReading;
    }


    public void proccessInformation(Map<String, String> mapEducation) {
        String school = mapEducation.get("School");
        String studioLevelSchool = mapEducation.get("Studio Level School");
        String countrySchool = mapEducation.get("Country School");
        String citySchool = mapEducation.get("City School");
        String starDateSchool = mapEducation.get("Start Date School");
        String endDateSchool = mapEducation.get("End Date School");
        String university = mapEducation.get("University");
        String studioLevelUniversity = mapEducation.get("Studio Level University");
        String career = mapEducation.get("Career");
        String countryUniversity = mapEducation.get("Country University");
        String cityUniversity = mapEducation.get("City University");
        String startDateUniversity = mapEducation.get("Start Date University");
        String endDateUniversity = mapEducation.get("End Date University");
        String language = mapEducation.get("Language");
        String languageWritten = mapEducation.get("Language Written");
        String laguageOral = mapEducation.get("Language Oral");
        String languageReading = mapEducation.get("Language Reading");

        setSchool(school);
        setStudioLevelSchool(studioLevelSchool);
        setCountrySchool(countrySchool);
        setCitySchool(citySchool);
        setStartSchool(starDateSchool);
        setEndSchool(endDateSchool);
        setUniversity(university);
        setStudioLevelUniversity(studioLevelUniversity);
        setCareer(career);
        setCountryUniversity(countryUniversity);
        setCityUniversity(cityUniversity);
        setStartUniversity(startDateUniversity);
        setEndUniversity(endDateUniversity);
        setLanguage(language);
        setLanguageWritten(languageWritten);
        setLanguageOral(laguageOral);
        setLanguageReading(languageReading);
        fillListEducation();
        getLanguageForm();

    }

    public String getLanguageForm() {
        String languageForm = String.format(LANGUAGE_FORM,getLanguage(),getLanguageOral(), getLanguageWritten(),
                getLanguageReading());
        return languageForm;
    }

    public ArrayList getListEducation() {
        return educationList;
    }
}
