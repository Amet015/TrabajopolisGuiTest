package trabajopolis.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class EditProfile {
    private String Salary;
    private String SalaryOld;
    private static final String SALARY = "Salary";

    public String getSalaryOld() {
        return SalaryOld;
    }

    public void setSalaryOld(String salaryOld) {
        SalaryOld = salaryOld;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }

    public void proccessInformation(Map<String, String> mapEditProfile) {
        HashMap<String, Runnable> strategyMap = composeStrategy(mapEditProfile);
        mapEditProfile.keySet().forEach(key -> strategyMap.get(key).run());
    }

    private HashMap<String, Runnable> composeStrategy(Map<String, String> mapEditProfile) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(SALARY, () -> setSalary(mapEditProfile.get(SALARY)));
        return strategyMap;
    }

    public HashMap<String, String> getEditProfileToValidate() {
        HashMap<String, String> values = new HashMap<>();
        HashMap<String, Supplier> strategyMap = composeStrategyGet();
        for (String key : strategyMap.keySet()) {
            values.put(key, strategyMap.get(key).get().toString());
        }
        return values;
    }

    private HashMap<String, Supplier> composeStrategyGet() {
        HashMap<String, Supplier> strategyMapGet = new HashMap<>();
        strategyMapGet.put(SALARY, () -> getSalary());

        return strategyMapGet;
    }



    public void oldProccessInformation(HashMap<String, String> mapOldEditPrifile) {
        HashMap<String, Runnable> strategyMap = composeStrategytoOld(mapOldEditPrifile);
        mapOldEditPrifile.keySet().forEach(key -> strategyMap.get(key).run());
    }

    private HashMap<String, Runnable> composeStrategytoOld(HashMap<String, String> mapOldEditPrifile) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(SALARY, () -> setSalaryOld(mapOldEditPrifile.get(SALARY)));
        return strategyMap;
    }
}
