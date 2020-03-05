package Trabajopolis.Pages;

import Trabajopolis.BasePage;
import Trabajopolis.components.WebComponents;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.*;
import java.util.function.Supplier;

public class ResumeDetailsCV extends BasePage {

    private final String ID_TYPE = "//div[strong[contains(text(),'%s')] and @class=\"item\"]";

    @FindBy(xpath = "//div[strong[contains(text(),'Dirección')] and @class=\"item\"]")
    WebElement address;

    @FindBy(xpath = "//div[strong[contains(text(),'Estado')] and @class=\"item\"]")
    WebElement maritalStatus;

    //div[@class="item"]//strong[contains(text(),"Dirección")]/following-sibling::text()

//    private final String EXPERIENCE_FIELD = "//div[h2[contains(text(),\"Experiencia\")]]//ul//li//span[@style=" +
//            "\"display:block;\" and contains(text(),\"%s\")] ";

    @FindBy(xpath = "//div[strong[contains(text(),'Fecha de Nacimiento')] and @class='item']")
    WebElement dateBorn;

    @FindBy(xpath = "//div[h2[@class=\"title\" and contains(text(), \"Idiomas\")]]//li//span")
    WebElement languague;

    @FindBy(xpath = "//h1[@style=\"color:#1E4B82; margin-bottom:10px;\"]")
    WebElement title;

    @FindBy(xpath = "//div[strong[contains(text(),'Categoría')] and @class=\"item\"]")
    WebElement category;

    @FindBy(xpath = "//div[strong[contains(text(),'Contrato')] and @class=\"item\"]")
    WebElement contractType;

    @FindBy(xpath = "//div[strong[contains(text(),'Pretensión')] and @class=\"item\"]")
    WebElement salary;

    @FindBy(xpath = "//div[strong[contains(text(),'País')] and @class=\"item\"]")
    WebElement country;

    @FindBy(xpath = "//div[strong[contains(text(),'Ciudad')] and @class=\"item\"]")
    WebElement city;

    @FindBy(xpath = "//div[h2[contains(text(),\"Educación\")]]//ul//li")
    List<WebElement> edutacion;

    ArrayList<String> listEducation;

    @FindBy(xpath = "//div[h2[contains(text(),\"Experiencia\")]]//ul//li")
    List<WebElement> experience;


    ArrayList<String> listExperience;

    private final String DATE_FORMAT = "%s/%s/%s";

    private final String ID = "Id";
    private final String NUMBER_ID = "NumberId";
    private final String DATE_BORN = "Date Born";
    private final String SEX = "Sex";
    private final String ADDRESS = "Address";
    private final String MARITAL_STATUS = "Marital Status";
    private final String COMPANY_CHARGE = "Company Charge";
    private final String COMPANY_NAME = "Company Name";
    private final String COUNTRY = "Country";
    private final String CITY = "City";
    private final String START_DATE = "Start Date";
    private final String END_DATE = "End Date";
    private final String SCHOOL = "School";
    private final String STUDIO_LEVEL_SCHOOL = "Studio Level School";
    private final String COUNTRY_SCHOOL = "Country School";
    private final String CITY_SCHOOL = "City School";
    private final String START_DATE_SCHOOL = "Start Date School";
    private final String END_DATE_SCHOOL = "End Date School";
    private final String UNIVERSITY = "University";
    private final String CAREER = "Career";
    private final String STUDIO_LEVEL_UNIVERSITY = "Studio Level University";
    private final String COUNTRY_UNIVERSITY = "Country University";
    private final String CITY_UNIVERSITY = "City University";
    private final String START_DATE_UNIVERSITY = "Start Date University";
    private final String END_DATE_UNIVERSITY = "End Date University";
    private final String LANGUAGE = "Language";
    private final String LANGUAGE_WRITTEN = "Language Written";
    private final String LANGUAGE_ORAL = "Language Oral";
    private final String LANGUAGE_READING = "Language Reading";
    private final String TITLE = "Title";
    private final String CATEGORY = "Category";
    private final String CONTRACT_TYPE = "Contract Type";
    private final String SALARY = "Salary";
    private final String PRIVACITY_CV = "PrivacityCV";
    private final String EXPERIENCE = "Experience";
    private final String EDUCATION = "Education";

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

    private String getIdType(){
        return this.id;
    }

    public String getDateBorn() {
        String date = dateBorn.getText();
        System.out.println(date);
        System.out.println(date);
        date = date.replace("Fecha de Nacimiento: ", "");
        date = date.substring(0, date.indexOf(" ")).replace(".", "/");
        String [] dateFormat = date.split("/");
        for (int i = 0; i < dateFormat.length -1 ; i++) {
            if(dateFormat[i].startsWith("0")){
                dateFormat[i] = dateFormat[i].replace("0","");
            }
        }
        return String.format(DATE_FORMAT,dateFormat[0],dateFormat[1],dateFormat[2]);
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

    public HashMap<String,String> getPersonalInformationToValidate() {
        HashMap<String,String> values = new HashMap<>();
        HashMap<String, Supplier> strategyMapPersonal = composeStrategyMapPersonalInformationToGet();
        for (String key: strategyMapPersonal.keySet() ) {
            values.put(key , strategyMapPersonal.get(key).get().toString());
        }
        return values;
    }

    public HashMap<String,String> getResumeExperienceToValidate() {
        HashMap<String,String> values = new HashMap<>();
        HashMap<String, Supplier> strategyMapExperience = composeStrategyMapResumeExperienceToGet();
        for (String key: strategyMapExperience.keySet() ) {
            values.put(key , strategyMapExperience.get(key).get().toString());
        }
        return values;
    }

    private HashMap<String, Supplier> composeStrategyMapResumeExperienceToGet() {
        HashMap<String,Supplier> strategyMap = new HashMap<>();
        strategyMap.put(EXPERIENCE, () -> getListExperience());
        return strategyMap;
    }

    public HashMap<String,String> getEducationToValidate () {
        HashMap<String,String> values = new HashMap<>();
        HashMap<String, Supplier> strategyMapEducation = composeStrategyMapEducationToGet();
        for (String key: strategyMapEducation.keySet() ) {
            values.put(key , strategyMapEducation.get(key).get().toString());
        }
        return values;
    }

    private HashMap<String, Supplier> composeStrategyMapEducationToGet() {
        HashMap<String,Supplier> strategyMap = new HashMap<>();
        strategyMap.put(EDUCATION, () -> getListEducation());
        return strategyMap;
    }

    public HashMap<String,String> getGeneralInformationToValidate() {
        HashMap<String,String> values = new HashMap<>();
        HashMap<String, Supplier> strategyMapGeneralIformation = composeStrategyMapPersonalInformationToGet();
        for (String key: strategyMapGeneralIformation.keySet() ) {
            values.put(key , strategyMapGeneralIformation.get(key).get().toString());
        }
        return values;
    }

    private HashMap<String, Supplier> composeStrategyMapPersonalInformationToGet() {
        HashMap<String,Supplier> strategyMap = new HashMap<>();
        strategyMap.put(ID, () -> getIdType());
        strategyMap.put(NUMBER_ID, () -> getNumberID(getIdType()));
        strategyMap.put(DATE_BORN, () -> getDateBorn());
        strategyMap.put(ADDRESS, () -> getAddress());
        strategyMap.put(MARITAL_STATUS, () -> getMaritalStatus());

        return strategyMap;
    }

    private HashMap<String, Supplier> composeStrategyMapGeneralInformationToGet() {
        HashMap<String,Supplier> strategyMap = new HashMap<>();
        strategyMap.put(TITLE, () -> getTitle());
        strategyMap.put(CATEGORY, () -> getCategory());
        strategyMap.put(CONTRACT_TYPE, () -> getContractType());
        strategyMap.put(SALARY, () -> getSalary());
        strategyMap.put(COUNTRY, () -> getCountry());
        strategyMap.put(CITY, () -> getCity());

        return strategyMap;
    }
}
