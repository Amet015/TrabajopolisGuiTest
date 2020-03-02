package Trabajopolis.Pages;

import Trabajopolis.BasePage;
import Trabajopolis.entities.PersonalInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class PersonalInformationPage extends BasePage {
    @FindBy(name = "identidad_0")
    WebElement idTypeSelect;

    @FindBy(name = "direccion")
    WebElement addressField;

    @FindBy(name = "estado_civil")
    WebElement maritalStatusSelect;

    @FindBy(id = "btn-add-cv")
    WebElement nextButton;

    Select selectValue;

    public PersonalInformationPage(){}

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(idTypeSelect));
    }

    public void selectIdType(String idType) {
        selectValue = new Select(idTypeSelect);
        selectValue.selectByValue(idType);
    }

    public void setAddressField(String address) {
        addressField.clear();
        addressField.sendKeys(address);
    }

    public void selectMaritalStatus(String maritalstatus) {
        selectValue = new Select(maritalStatusSelect);
        selectValue.selectByValue(maritalstatus);
    }

    public ResumeExperiencePage clickNextButton(){
        nextButton.click();
        return new ResumeExperiencePage();
    }

    public String getNextButtonText(){
        return nextButton.getText();
    }

    public void setPersonalInformation(PersonalInformation personalInformation) {
        selectIdType(personalInformation.getIdType());
        setAddressField(personalInformation.getAddress());
        selectMaritalStatus(personalInformation.getMaritalStatus());
    }
}
