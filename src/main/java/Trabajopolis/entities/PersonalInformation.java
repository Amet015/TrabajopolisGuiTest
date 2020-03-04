package Trabajopolis.entities;

import java.util.HashMap;
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

    public void processInformation(Map<String, String> mapPersonalInformation) {
        HashMap<String, Runnable> strategyMap = composeStrategy(mapPersonalInformation);
        mapPersonalInformation.keySet().forEach(key -> strategyMap.get(key).run());
    }

    private HashMap<String, Runnable> composeStrategy(Map<String, String> mapPersonalInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("Id", () -> setIdType(mapPersonalInformation.get("Id")));
        strategyMap.put("Address", () -> setAddress(mapPersonalInformation.get("Address")));
        strategyMap.put("Marital Status", () -> setMaritalStatus(mapPersonalInformation.get("Marital Status")));
        return strategyMap;
    }
}
