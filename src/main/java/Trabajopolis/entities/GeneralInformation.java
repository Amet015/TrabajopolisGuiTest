package Trabajopolis.entities;

import java.util.Map;

public class GeneralInformation {
    private String title;
    private String category;
    private String contractType;
    private String salary;
    private String country;
    private String city;
    private String privacityCV;


    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPrivacityCV(String privacityCV) {
        this.privacityCV = privacityCV;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getContractType() {
        return contractType;
    }

    public String getSalary() {
        return salary;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getPrivacityCV() {
        return privacityCV;
    }

    public void proccessInformation(Map<String, String> mapGeneralInformation) {
        String title = mapGeneralInformation.get("Title");
        String category = mapGeneralInformation.get("Category");
        String contractType = mapGeneralInformation.get("Contract Type");
        String salary = mapGeneralInformation.get("Salary");
        String country = mapGeneralInformation.get("Country");
        String city = mapGeneralInformation.get("City");
        String privacityCV = mapGeneralInformation.get("PrivacityCV");

        setTitle(title);
        setCategory(category);
        setContractType(contractType);
        setSalary(salary);
        setCountry(country);
        setCity(city);
        setPrivacityCV(privacityCV);

    }
}
