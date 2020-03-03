package Trabajopolis.entities;

import Trabajopolis.Utils.WebUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class ResumeExperience {
    private String companyCharge;
    private String companyName;
    private String industry;
    private String countryExperience;
    private String cityExperience;
    private String startDate;
    private String endDate;
    private WebUtils webUtils;
    private ArrayList<String> listExperience = new ArrayList<>();
    private final String RESUME_EXPERIENCE = "%s, desde %s %s hasta %s %s\n" + "%s";

    public ResumeExperience(){
        webUtils = new WebUtils();
    }

    private void fillListExperience(){
        String resumeExperience = String.format(RESUME_EXPERIENCE, getCompanyCharge(),webUtils
                .getMonthWritten(getStartDate()), webUtils.getYear(getStartDate()), webUtils
                .getMonthWritten(getEndDate()),webUtils.getYear(getEndDate()),getCompanyName());
        listExperience.add(resumeExperience);
        Collections.sort(listExperience);
        for (String esto: listExperience ) {
            System.out.println(esto);
        }
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
        String companyCharge = mapResumeExperience.get("Company Charge");
        String companyName = mapResumeExperience.get("Company Name");
        String country = mapResumeExperience.get("Country");
        String city = mapResumeExperience.get("City");
        String startDateSchool = mapResumeExperience.get("Start Date");
        String endDateSchool = mapResumeExperience.get("End Date");
        setCompanyCharge(companyCharge);
        setCompanyName(companyName);
        setCountryExperience(country);
        setCityExperience(city);
        setStartDate(startDateSchool);
        setEndDate(endDateSchool);
        fillListExperience();
    }

    public ArrayList getListExperience(){
        return listExperience;
    }
}
