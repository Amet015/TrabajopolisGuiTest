package trabajopolis.entities;

import trabajopolis.utils.WebUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PersonalInformation {

    private String idType;
    private String numberId;
    private String dateBorn;
    private String sex;
    private String address;
    private String maritalStatus;

    private final String ID = "Id";
    private final String NUMBER_ID = "NumberId";
    private final String DATE_BORN = "Date Born";
    private final String SEX = "Sex";
    private final String ADDRESS = "Address";
    private final String MARITAL_STATUS = "Marital Status";

    private WebUtils webUtils = new WebUtils();

    public void setIdType(String idType) {
        //this.idType = idType.replace("UNIQUE_ID", getUniqueID());
        this.idType = idType;
    }

    public String getNumberId() {
        return numberId;
    }

    public void setNumberId(String numberId) {
        this.numberId = numberId;
    }

    public String getDateBorn() {
        return dateBorn;
    }

    public void setDateBorn(String dateBorn) {
        this.dateBorn = dateBorn;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public String getMartialStatusResume(){
        return webUtils.getSexMaritalStatus(this.sex, this.maritalStatus);
    }

    public void processInformation(Map<String, String> mapPersonalInformation) {
        HashMap<String, Runnable> strategyMap = composeStrategy(mapPersonalInformation);
        mapPersonalInformation.keySet().forEach(key -> strategyMap.get(key).run());
    }

    private HashMap<String, Runnable> composeStrategy(Map<String, String> mapPersonalInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(ID, () -> setIdType(mapPersonalInformation.get(ID)));
        strategyMap.put(NUMBER_ID, () -> setNumberId(mapPersonalInformation.get(NUMBER_ID)));
        strategyMap.put(DATE_BORN, () -> setDateBorn(mapPersonalInformation.get(DATE_BORN)));
        strategyMap.put(SEX, () -> setSex(mapPersonalInformation.get(SEX)));
        strategyMap.put(ADDRESS, () -> setAddress(mapPersonalInformation.get(ADDRESS)));
        strategyMap.put(MARITAL_STATUS, () -> setMaritalStatus(mapPersonalInformation.get(MARITAL_STATUS)));
        return strategyMap;
    }

    public HashMap<String,String> processInformationToGet() {
        HashMap<String, String> values = new HashMap<>();
        HashMap<String,Supplier> strategyMap = composeStrategyGet();
        for (String key : strategyMap.keySet() ) {
            values.put(key , strategyMap.get(key).get().toString());
        }
        return values;
    }

    private HashMap<String, Supplier> composeStrategyGet() {
        HashMap<String,Supplier> strategyMapGet = new HashMap<>();
        strategyMapGet.put(ID,() -> getIdType());
        strategyMapGet.put(NUMBER_ID,() -> getNumberId());
        strategyMapGet.put(DATE_BORN,() -> getDateBorn());
        strategyMapGet.put(ADDRESS,() -> getAddress());
        strategyMapGet.put(MARITAL_STATUS,() -> getMartialStatusResume());

        return strategyMapGet;
    }
}
