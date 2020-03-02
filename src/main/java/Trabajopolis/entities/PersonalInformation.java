package Trabajopolis.entities;

import java.util.Map;

public class PersonalInformation {

    private String idType;
    private String address;
    private String maritalStatus;

    public void setIdType(String idType) {
        //this.idType = idType.replace("UNIQUE_ID", getUniqueID());
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

    public void processInformation(Map<String, String> dtPersonalInformation) {
        String id = dtPersonalInformation.get("Id");
        String address = dtPersonalInformation.get("Address");
        String maritalStatus = dtPersonalInformation.get("Marital Status");

        setIdType(id);
        setAddress(address);
        setMaritalStatus(maritalStatus);
    }
}
