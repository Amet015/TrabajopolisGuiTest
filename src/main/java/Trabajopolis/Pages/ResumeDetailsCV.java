package Trabajopolis.Pages;

import Core.WebDriverManager;
import Trabajopolis.BasePage;
import Trabajopolis.components.WebComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ResumeDetailsCV extends BasePage {

    private final String ID_TYPE = "//div[strong[contains(text(),'%s')] and @class=\"item\"]";

    @FindBy(xpath = "//div[strong[contains(text(),'Dirección')] and @class=\"item\"]")
    WebElement address;

    @FindBy(xpath = "//div[strong[contains(text(),'Estado')] and @class=\"item\"]")
    WebElement maritalStatus;


    private final String EXPERIENCE_FIELD =  "//div[h2[contains(text(),\"Experiencia\")]]//ul//li//span[@style="+
            "\"display:block;\" and contains(text(),\"%s\")] ";

//    private final String LANGUAGE_FIELD = "//div[h2[@class=\"title\" and contains(text(), \"Idiomas\")]]//li//span" +
//         "[contains(text(),'%s')]";
    @FindBy(xpath = "//div[h2[@class=\"title\" and contains(text(), \"Idiomas\")]]//li//span")
    WebElement languague;

    private final  String TITLE = "//h1[strong[contains(text(),\"%s\")] and @style=\"color:#1E4B82;"+
            "margin-bottom:10px;\"]";

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


    @FindBy(xpath ="//div[h2[contains(text(),\"Educación\")]]//ul//li" )
    List<WebElement> edutacion;

    ArrayList<String> listEducation;



    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(salary));
        webDriverWait.until(ExpectedConditions.visibilityOf(address));
        webDriverWait.until(ExpectedConditions.visibilityOf(maritalStatus));
        listEducation = new ArrayList<>();
        fillListEducation();

    }

    public String getSalary(){
        return salary.getText();
    }

    public String getAddress(){
        return address.getText();
    }

    public String getMaritalStatus(){
        return maritalStatus.getText();
    }

    public String getIdType(String id){
        return WebComponents.getTextFromTheElement(ID_TYPE,id);
    }

    public String getLanguague(){
        return languague.getText();
    }

    public String getExperience(String value){

        return WebComponents.getTextFromTheElement(EXPERIENCE_FIELD,value);
    }


    public String getTitle(String value){
        return WebComponents.getTextFromTheElement(TITLE,value);
    }

    public String getCategory(){
        return category.getText();
    }

    public String getContractType(){
        return contractType.getText();
    }

    public String getCountry(){
        return country.getText();
    }

    public String getCity(){
        return city.getText();
    }
    private void fillListEducation(){
        for (WebElement e: edutacion  ) {
            listEducation.add(e.getText());
        }
        Collections.sort(listEducation);
    }

    public ArrayList getListEducation(){
     return listEducation;
    }

}
