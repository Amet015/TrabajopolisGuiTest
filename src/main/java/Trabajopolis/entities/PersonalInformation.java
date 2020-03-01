package Trabajopolis.entities;

public class PersonalInformation {
    private String idType;
    private String address;
    private String maritalStatus;

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getIdType() {
        return idType;
    }

    public String getAddress() {
        return address;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }
}
