package Trabajopolis.entities;

import Trabajopolis.Utils.WebUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ResumeExperience {
    private String companyCharge;
    private String companyName;
    private String countryExperience;
    private String cityExperience;
    private String startDate;
    private String endDate;
    private WebUtils webUtils;
    private ArrayList<String> listExperience = new ArrayList<>();

    private final String COMPANY_CHARGE = "Company Charge";
    private final String COMPANY_NAME = "Company Name";
    private final String COUNTRY = "Country";
    private final String CITY = "City";
    private final String START_DATE = "Start Date";
    private final String END_DATE = "End Date";

    private final String RESUME_EXPERIENCE = "%s, desde %s %s hasta %s %s\n" + "%s";

    public ResumeExperience() {
        webUtils = new WebUtils();
    }

    private void fillListExperience() {
        String resumeExperience = String.format(RESUME_EXPERIENCE, getCompanyCharge(), webUtils
                .getMonthWritten(getStartDate()), webUtils.getYear(getStartDate()), webUtils
                .getMonthWritten(getEndDate()), webUtils.getYear(getEndDate()), getCompanyName());
        listExperience.add(resumeExperience);
        Collections.sort(listExperience);
    }

    public String getCompanyCharge() {
        return companyCharge;
    }

    public void setCompanyCharge(String companyCharge) {
        this.companyCharge = companyCharge;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCountryExperience() {
        return countryExperience;
    }

    public void setCountryExperience(String countryExperience) {
        this.countryExperience = countryExperience;
    }

    public String getCityExperience() {
        return cityExperience;
    }

    public void setCityExperience(String cityExperience) {
        this.cityExperience = cityExperience;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void proccessInformation(Map<String, String> mapResumeExperience) {
        HashMap<String, Runnable> strategyMap = composeStrategy(mapResumeExperience);
        mapResumeExperience.keySet().forEach(key -> strategyMap.get(key).run());
        fillListExperience();
    }

    private HashMap<String, Runnable> composeStrategy(Map<String, String> mapResumeExperience) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(COMPANY_CHARGE, () -> setCompanyCharge(mapResumeExperience.get(COMPANY_CHARGE)));
        strategyMap.put(COMPANY_NAME, () -> setCompanyName(mapResumeExperience.get(COMPANY_NAME)));
        strategyMap.put(COUNTRY, () -> setCountryExperience(mapResumeExperience.get(COUNTRY)));
        strategyMap.put(CITY, () -> setCityExperience(mapResumeExperience.get(CITY)));
        strategyMap.put(START_DATE, () -> setStartDate(mapResumeExperience.get(START_DATE)));
        strategyMap.put(END_DATE, () -> setEndDate(mapResumeExperience.get(END_DATE)));
        return strategyMap;
    }

    public ArrayList getListExperience() {
        return listExperience;
    }
}
