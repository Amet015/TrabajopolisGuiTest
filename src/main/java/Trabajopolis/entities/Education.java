package Trabajopolis.entities;

import Trabajopolis.Utils.WebUtils;
import Trabajopolis.components.WebComponents;
import org.graalvm.compiler.replacements.StandardGraphBuilderPlugins;
import org.openqa.selenium.WebElement;

import java.util.*;

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

    private final String SCHOOL = "School";
    private final String STUDIO_LEVEL_SCHOOL = "Studio Level School";
    private final String COUNTRY_SCHOOL = "Country School";
    private final String CITY_SCHOOL = "City School";
    private final String START_DATE_SCHOOL = "Start Date School";
    private final String END_DATE_SCHOOL = "End Date School";
    private final String UNIVERSITY = "University";
    private final String CAREER = "Career";
    private final String STUDIO_LEVEL_UNIVERSITY = "Studio Level University";
    private final String COUNTRY_UNIVERSITY = "Country University";
    private final String CITY_UNIVERSITY = "City University";
    private final String START_DATE_UNIVERSITY = "Start Date University";
    private final String END_DATE_UNIVERSITY = "End Date University";
    private final String LANGUAGE = "Language";
    private final String LANGUAGE_WRITTEN = "Language Written";
    private final String LANGUAGE_ORAL = "Language Oral";
    private final String LANGUAGE_READING = "Language Reading";


    public Education() {
        webUtils = new WebUtils();
    }


    private void fillListEducation() {
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
        HashMap<String, Runnable> strategyMap = composeStrategy(mapEducation);
        mapEducation.keySet().forEach(key -> strategyMap.get(key).run());
        fillListEducation();
        getLanguageForm();
    }

    private HashMap<String, Runnable> composeStrategy(Map<String, String> mapEducation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(SCHOOL, () -> setSchool(mapEducation.get(SCHOOL)));
        strategyMap.put(STUDIO_LEVEL_SCHOOL, () -> setStudioLevelSchool(mapEducation.get(STUDIO_LEVEL_SCHOOL)));
        strategyMap.put(COUNTRY_SCHOOL, () -> setCountrySchool(mapEducation.get(COUNTRY_SCHOOL)));
        strategyMap.put(CITY_SCHOOL, () -> setCitySchool(mapEducation.get(CITY_SCHOOL)));
        strategyMap.put(START_DATE_SCHOOL, () -> setStartSchool(mapEducation.get(START_DATE_SCHOOL)));
        strategyMap.put(END_DATE_SCHOOL, () -> setEndSchool(mapEducation.get(END_DATE_SCHOOL)));
        strategyMap.put(UNIVERSITY, () -> setUniversity(mapEducation.get(UNIVERSITY)));
        strategyMap.put(CAREER, () -> setCareer(mapEducation.get(CAREER)));
        strategyMap.put(STUDIO_LEVEL_UNIVERSITY, () -> setStudioLevelUniversity(mapEducation.get(STUDIO_LEVEL_UNIVERSITY)));
        strategyMap.put(COUNTRY_UNIVERSITY, () -> setCountryUniversity(mapEducation.get(COUNTRY_UNIVERSITY)));
        strategyMap.put(CITY_UNIVERSITY, () -> setCityUniversity(mapEducation.get(CITY_UNIVERSITY)));
        strategyMap.put(START_DATE_UNIVERSITY, () -> setStartUniversity(mapEducation.get(START_DATE_UNIVERSITY)));
        strategyMap.put(END_DATE_UNIVERSITY, () -> setEndUniversity(mapEducation.get(END_DATE_UNIVERSITY)));
        strategyMap.put(LANGUAGE, () -> setLanguage(mapEducation.get(LANGUAGE)));
        strategyMap.put(LANGUAGE_WRITTEN, () -> setLanguageWritten(mapEducation.get(LANGUAGE_WRITTEN)));
        strategyMap.put(LANGUAGE_ORAL, () -> setLanguageOral(mapEducation.get(LANGUAGE_ORAL)));
        strategyMap.put(LANGUAGE_READING, () -> setLanguageReading(mapEducation.get(LANGUAGE_READING)));
        return strategyMap;
    }

    public String getLanguageForm() {
        String languageForm = String.format(LANGUAGE_FORM, getLanguage(), getLanguageOral(), getLanguageWritten(),
                getLanguageReading());
        return languageForm;
    }

    public ArrayList getListEducation() {
        return educationList;
    }
}
