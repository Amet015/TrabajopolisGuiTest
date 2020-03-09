package trabajopolis.pages;

import trabajopolis.BasePage;
import trabajopolis.components.WebComponents;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.*;
import java.util.function.Supplier;

public class ResumeDetailsCV extends BasePage {

    private final String ID_TYPE = "//div[strong[contains(text(),'%s')] and @class=\"item\"]";

    @FindBy(xpath = "//div[strong[contains(text(),'Dirección')] and @class=\"item\"]")
    private WebElement address;

    @FindBy(xpath = "//div[strong[contains(text(),'Estado')] and @class=\"item\"]")
    private WebElement maritalStatus;

    //div[@class="item"]//strong[contains(text(),"Dirección")]/following-sibling::text()

//    private final String EXPERIENCE_FIELD = "//div[h2[contains(text(),\"Experiencia\")]]//ul//li//span[@style=" +
//            "\"display:block;\" and contains(text(),\"%s\")] ";

    @FindBy(xpath = "//div[strong[contains(text(),'Fecha de Nacimiento')] and @class='item']")
    private WebElement dateBorn;

    @FindBy(xpath = "//div[h2[@class=\"title\" and contains(text(), \"Idiomas\")]]//li//span")
    private WebElement languague;

    @FindBy(xpath = "//h1[@style=\"color:#1E4B82; margin-bottom:10px;\"]")
    private WebElement title;

    @FindBy(xpath = "//div[strong[contains(text(),'Categoría')] and @class=\"item\"]")
    private WebElement category;

    @FindBy(xpath = "//div[strong[contains(text(),'Contrato')] and @class=\"item\"]")
    private WebElement contractType;

    @FindBy(xpath = "//div[strong[contains(text(),'Pretensión')] and @class=\"item\"]")
    private WebElement salary;

    @FindBy(xpath = "//div[strong[contains(text(),'País')] and @class=\"item\"]")
    private WebElement country;

    @FindBy(xpath = "//div[strong[contains(text(),'Ciudad')] and @class=\"item\"]")
    private WebElement city;

    @FindBy(xpath = "//div[h2[contains(text(),\"Educación\")]]//ul//li")
    private List<WebElement> edutacion;

    private ArrayList<String> listEducation;

    @FindBy(xpath = "//div[h2[contains(text(),\"Experiencia\")]]//ul//li")
    private List<WebElement> experience;


    private ArrayList<String> listExperience;

    private final String DATE_FORMAT = "%s/%s/%s";

    private final String ID = "Id";
    private final String NUMBER_ID = "NumberId";
    private final String DATE_BORN = "Date Born";
    private final String ADDRESS = "Address";
    private final String MARITAL_STATUS = "Marital Status";
    private final String COUNTRY = "Country";
    private final String CITY = "City";
    private final String TITLE = "Title";
    private final String CATEGORY = "Category";
    private final String CONTRACT_TYPE = "Contract Type";
    private final String SALARY = "Salary";
    private final String EXPERIENCE = "Experience";
    private final String EDUCATION = "Education";
    private final String LANGUAGE = "Language";

    private String id;


    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(salary));
        webDriverWait.until(ExpectedConditions.visibilityOf(address));
        webDriverWait.until(ExpectedConditions.visibilityOf(maritalStatus));
        listEducation = new ArrayList<>();
        listExperience = new ArrayList<>();
        fillListEducation();
        fillListExperience();

    }

    private void fillListExperience() {
        for (WebElement element : experience) {
            listExperience.add(element.getText());
        }
        Collections.sort(listExperience);
    }

    private void fillListEducation() {
        for (WebElement element : edutacion) {
            listEducation.add(element.getText());
        }
        Collections.sort(listEducation);
    }

    public String getSalary() {
        String salaryClean = salary.getText().replace("Pretensión Salarial: Bs. ", "");
        return salaryClean;
    }

    public String getAddress() {
        String addressClean = address.getText().replace("Dirección: ", "");
        return addressClean;
    }

    public String getMaritalStatus() {
        String maritalStatusClean = maritalStatus.getText().replace("Estado Civil: ", "");
        return maritalStatusClean;
    }

    public void setIdType(String id) {
        String[] idType = WebComponents.getTextFromTheElement(ID_TYPE, id).split(":");
        this.id = idType[0];

    }

    private String getIdType() {
        return this.id;
    }

    public String getDateBorn() {
        String date = dateBorn.getText();
        date = date.replace("Fecha de Nacimiento: ", "");
        date = date.substring(0, date.indexOf(" ")).replace(".", "/");
        String[] dateFormat = date.split("/");
        for (int i = 0; i < dateFormat.length - 1; i++) {
            if (dateFormat[i].startsWith("0")) {
                dateFormat[i] = dateFormat[i].replace("0", "");
            }
        }
        return String.format(DATE_FORMAT, dateFormat[0], dateFormat[1], dateFormat[2]);
    }

    public String getNumberID(String id) {
        String[] number = WebComponents.getTextFromTheElement(ID_TYPE, id).split(":");
        return number[1].trim();
    }

    public String getLanguague() {
        return languague.getText();
    }

    public String getTitle() {
        return title.getText();
    }

    public String getCategory() {
        String categoryClean = category.getText().replace("Categoría: ", "");
        return categoryClean;
    }

    public String getContractType() {
        String ContractTypeClean = contractType.getText().replace("Contrato: ", "");
        return ContractTypeClean;
    }

    public String getCountry() {
        String countryClean = country.getText().replace("País: ", "");
        return countryClean;
    }

    public String getCity() {
        String cityClean = city.getText().replace("Ciudad: ", "");
        return cityClean;
    }

    public ArrayList getListEducation() {
        return listEducation;
    }

    public ArrayList getListExperience() {
        return listExperience;
    }

    public HashMap<String, String> getPersonalInformationToValidate() {
        HashMap<String, String> values = new HashMap<>();
        HashMap<String, Supplier> strategyMapPersonal = composeStrategyMapPersonalInformationToGet();
        for (String key : strategyMapPersonal.keySet()) {
            values.put(key, strategyMapPersonal.get(key).get().toString());
        }
        return values;
    }

    public HashMap<String, String> getResumeExperienceToValidate() {
        HashMap<String, String> values = new HashMap<>();
        HashMap<String, Supplier> strategyMapExperience = composeStrategyMapResumeExperienceToGet();
        for (String key : strategyMapExperience.keySet()) {
            values.put(key, strategyMapExperience.get(key).get().toString());
        }
        return values;
    }

    private HashMap<String, Supplier> composeStrategyMapResumeExperienceToGet() {
        HashMap<String, Supplier> strategyMap = new HashMap<>();
        strategyMap.put(EXPERIENCE, () -> getListExperience());
        return strategyMap;
    }

    public HashMap<String, String> getEducationToValidate() {
        HashMap<String, String> values = new HashMap<>();
        HashMap<String, Supplier> strategyMapEducation = composeStrategyMapEducationToGet();
        for (String key : strategyMapEducation.keySet()) {
            values.put(key, strategyMapEducation.get(key).get().toString());
        }
        return values;
    }

    private HashMap<String, Supplier> composeStrategyMapEducationToGet() {
        HashMap<String, Supplier> strategyMap = new HashMap<>();
        strategyMap.put(EDUCATION, () -> getListEducation());
        strategyMap.put(LANGUAGE, () -> getLanguague());
        return strategyMap;
    }

    public HashMap<String, String> getGeneralInformationToValidate() {
        HashMap<String, String> values = new HashMap<>();
        HashMap<String, Supplier> strategyMapGeneralIformation = composeStrategyMapGeneralInformationToGet();
        for (String key : strategyMapGeneralIformation.keySet()) {
            values.put(key, strategyMapGeneralIformation.get(key).get().toString());
        }
        return values;
    }

    private HashMap<String, Supplier> composeStrategyMapPersonalInformationToGet() {
        HashMap<String, Supplier> strategyMap = new HashMap<>();
        strategyMap.put(ID, () -> getIdType());
        strategyMap.put(NUMBER_ID, () -> getNumberID(getIdType()));
        strategyMap.put(DATE_BORN, () -> getDateBorn());
        strategyMap.put(ADDRESS, () -> getAddress());
        strategyMap.put(MARITAL_STATUS, () -> getMaritalStatus());

        return strategyMap;
    }

    private HashMap<String, Supplier> composeStrategyMapGeneralInformationToGet() {
        HashMap<String, Supplier> strategyMap = new HashMap<>();
        strategyMap.put(TITLE, () -> getTitle());
        strategyMap.put(CATEGORY, () -> getCategory());
        strategyMap.put(CONTRACT_TYPE, () -> getContractType());
        strategyMap.put(SALARY, () -> getSalary());
        strategyMap.put(COUNTRY, () -> getCountry());
        strategyMap.put(CITY, () -> getCity());

        return strategyMap;
    }
}
