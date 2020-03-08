package trabajopolis.entities;

import java.util.HashMap;
import java.util.Map;

public class SearchJob {
    private String category;
    private String country;

    private static final String CATEGORY = "Category";
    private static final String COUNTRY = "Country";
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void proccessInformation(Map<String,String> mapSearhcJob) {
        HashMap<String, Runnable> strategyMap = composeStrategy(mapSearhcJob);
        mapSearhcJob.keySet().forEach(key -> strategyMap.get(key).run());
    }

    private HashMap<String, Runnable> composeStrategy(Map<String, String> mapSearhcJob) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(CATEGORY, () -> setCategory(mapSearhcJob.get(CATEGORY)));
        strategyMap.put(COUNTRY, () -> setCountry(mapSearhcJob.get(COUNTRY)));
        return strategyMap;
    }
}
