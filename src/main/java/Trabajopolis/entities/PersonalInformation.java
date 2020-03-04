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
        HashMap<String,Runnable> strategyMap = composeStrategy(mapPersonalInformation);
        mapPersonalInformation.keySet().forEach(key -> strategyMap.get(key).run());
//        String id = dtPersonalInformation.get("Id");
////        String address = dtPersonalInformation.get("Address");
////        String maritalStatus = dtPersonalInformation.get("Marital Status");
////
////        setIdType(id);
////        setAddress(address);
////        setMaritalStatus(maritalStatus);
    }

    private HashMap<String, Runnable> composeStrategy(Map<String, String> mapPersonalInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("Id", () -> setIdType(mapPersonalInformation.get("Id")));
        strategyMap.put("Address", () -> setAddress(mapPersonalInformation.get("Address")));
        strategyMap.put("Marital Status", () -> setMaritalStatus(mapPersonalInformation.get("Marital Status")));
        return  strategyMap;

    }
//      En el ENTITY

    //    public void setPodInformation(final Map<String, String> podInformation) {
//        HashMap<String, Runnable> strategyMAp = composeStrategyMap(podInformation);
//        podInformation.keySet().forEach(key -> strategyMAp.get(key).run());
//    }

//
//    private HashMap<String, Runnable> composeStrategyMap(Map<String, String> podInformation) {
//        HashMap<String, Runnable> strategyMap = new HashMap<>();
//
//        strategyMap.put("podName", () -> setPodName(podInformation.get("podName")));
//        strategyMap.put("startDate", () ->  setStartDate(podInformation.get("startDate")));
//        strategyMap.put("dueDate", () -> setDueDate(podInformation.get("dueDate")));
//        strategyMap.put("budgetTime", () -> setBudgetedTime(podInformation.get("budgetTime")));
//        strategyMap.put("client", () -> setClient(podInformation.get("client")));
//        strategyMap.put("projectLead", () -> setPodLead(podInformation.get("projectLead")));
//        strategyMap.put("color", () -> setPodColor(podInformation.get("color")));
//        strategyMap.put("description", () -> setDescription(podInformation.get("description")));
//        return strategyMap;
//    }
//
}
