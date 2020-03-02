package Trabajopolis.Pages;

import Core.WebDriverManager;
import Trabajopolis.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResumeDetailsCV extends BasePage {

    //armar
    @FindBy(xpath = "//div[strong[contains(text(),'Pasaporte')] and @class=\"item\"]")
    WebElement idType;

    @FindBy(xpath = "//div[strong[contains(text(),'Dirección')] and @class=\"item\"]")
    WebElement address;

    @FindBy(xpath = "//div[strong[contains(text(),'Estado')] and @class=\"item\"]")
    WebElement maritalStatus;


    //armar
    @FindBy(xpath = "//li//span[@style=\"display:block;\" and contains(text(),\"Ingeniero\")]")
    WebElement companyCharge;

    //armar
    @FindBy(xpath = "//li//span[@style=\"display:block;\" and contains(text(),\"Entel\")]")
    WebElement companyName;

 // armar
    @FindBy(xpath = "//li//span[contains(text(),'Quechua')]")
    WebElement laguagues;

    @FindBy(xpath = "//div[strong[contains(text(),'Pa')] and @class=\"item\"]")
    WebElement countryBorn;

//    @FindBy(xpath = "//div[strong[contains(text(),'Pa�s')] and @class=\"item\"]")
//    WebElement countryBorn;
//
//    @FindBy(xpath = "//div[strong[contains(text(),'Pa�s')] and @class=\"item\"]")
//    WebElement countryBorn;
//
//    @FindBy(xpath = "//div[strong[contains(text(),'Pa�s')] and @class=\"item\"]")
//    WebElement countryBorn;
//
//    @FindBy(xpath = "//div[strong[contains(text(),'Pa�s')] and @class=\"item\"]")
//    WebElement countryBorn;
//
//    @FindBy(xpath = "//div[strong[contains(text(),'Pa�s')] and @class=\"item\"]")
//    WebElement countryBorn;
//
//    @FindBy(xpath = "//div[strong[contains(text(),'Pa�s')] and @class=\"item\"]")
//    WebElement countryBorn;
//
//    @FindBy(xpath = "//div[strong[contains(text(),'Pa�s')] and @class=\"item\"]")
//    WebElement countryBorn;
//
//    @FindBy(xpath = "//div[strong[contains(text(),'Pa�s')] and @class=\"item\"]")
//    WebElement countryBorn;
//
//    @FindBy(xpath = "//div[strong[contains(text(),'Pa�s')] and @class=\"item\"]")
//    WebElement countryBorn;
//
//    @FindBy(xpath = "//div[strong[contains(text(),'Pa�s')] and @class=\"item\"]")
//    WebElement countryBorn;

    @FindBy(xpath = "//div[strong[contains(text(),'Pretensión')] and @class=\"item\"]")
    WebElement salary;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(salary));
        webDriverWait.until(ExpectedConditions.visibilityOf(idType));
        webDriverWait.until(ExpectedConditions.visibilityOf(address));
        webDriverWait.until(ExpectedConditions.visibilityOf(maritalStatus));
        webDriverWait.until(ExpectedConditions.visibilityOf(companyCharge));
        webDriverWait.until(ExpectedConditions.visibilityOf(companyName));
    }

    public void prueba(){
        System.out.println(laguagues.getText());
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

    public String getIdType(){
        return idType.getText();
    }

    public String getCompanyCharge(){
        return companyCharge.getText();
    }

    public String getCompanyName(){
        return companyName.getText();
    }

    public String getLanguagues(){
        return laguagues.getText();
    }
}
