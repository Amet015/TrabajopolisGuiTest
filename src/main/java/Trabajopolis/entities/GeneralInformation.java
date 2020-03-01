package Trabajopolis.entities;

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
}
