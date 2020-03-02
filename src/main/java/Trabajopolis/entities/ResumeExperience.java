package Trabajopolis.entities;

import java.util.Map;

public class ResumeExperience {
    private String companyCharge;
    private String companyName;
    private String industry;
    private String countryExperience;
    private String cityExperience;
    private String startDate;
    private String endDate;

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

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
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
        setIndustry(industry);
        setCountryExperience(country);
        setCityExperience(city);
        setStartDate(startDateSchool);
        setEndDate(endDateSchool);
    }
}
