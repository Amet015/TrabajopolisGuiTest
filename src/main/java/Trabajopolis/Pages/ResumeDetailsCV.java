package Trabajopolis.Pages;

import Trabajopolis.BasePage;
import Trabajopolis.components.WebComponents;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

        for (String esto : listExperience) {
            System.out.println(esto);
        }
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

    public String getIdType(String id) {
        String[] idType = WebComponents.getTextFromTheElement(ID_TYPE, id).split(":");
        return idType[0];
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
}
