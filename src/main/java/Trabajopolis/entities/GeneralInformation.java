package Trabajopolis.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public class GeneralInformation {
    private String title;
    private String category;
    private String contractType;
    private String salary;
    private String country;
    private String city;
    private String privacityCV;

    private final String TITLE = "Title";
    private final String CATEGORY = "Category";
    private final String CONTRACT_TYPE = "Contract Type";
    private final String SALARY = "Salary";
    private final String COUNTRY = "Country";
    private final String CITY = "City";
    private final String PRIVACITY_CV = "PrivacityCV";


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
        HashMap<String, Runnable> strategyMap = composeStrategy(mapGeneralInformation);
        mapGeneralInformation.keySet().forEach(key -> strategyMap.get(key).run());
    }

    private HashMap<String, Runnable> composeStrategy(Map<String, String> mapGeneralInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(TITLE, () -> setTitle(mapGeneralInformation.get(TITLE)));
        strategyMap.put(CATEGORY, () -> setCategory(mapGeneralInformation.get(CATEGORY)));
        strategyMap.put(CONTRACT_TYPE, () -> setContractType(mapGeneralInformation.get(CONTRACT_TYPE)));
        strategyMap.put(SALARY, () -> setSalary(mapGeneralInformation.get(SALARY)));
        strategyMap.put(COUNTRY, () -> setCountry(mapGeneralInformation.get(COUNTRY)));
        strategyMap.put(CITY, () -> setCity(mapGeneralInformation.get(CITY)));
        strategyMap.put(PRIVACITY_CV, () -> setPrivacityCV(mapGeneralInformation.get(PRIVACITY_CV)));
        return strategyMap;
    }

    public HashMap<String,String> processInformationToGet() {
        HashMap<String, String> values = new HashMap<>();
        HashMap<String, Supplier> strategyMap = composeStrategyGet();
        for (String key : strategyMap.keySet() ) {
            values.put(key , strategyMap.get(key).get().toString());
        }
        return values;
    }

    private HashMap<String, Supplier> composeStrategyGet() {
        HashMap<String,Supplier> strategyMapGet = new HashMap<>();
        strategyMapGet.put(TITLE,() -> getTitle());
        strategyMapGet.put(CATEGORY,() -> getCategory());
        strategyMapGet.put(CONTRACT_TYPE,() -> getContractType());
        strategyMapGet.put(SALARY,() -> getSalary());
        strategyMapGet.put(COUNTRY,() -> getCountry());
        strategyMapGet.put(CITY,() -> getCity());
        return strategyMapGet;
    }
}
