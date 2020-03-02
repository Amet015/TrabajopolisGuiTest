package Trabajopolis.Pages;

import Trabajopolis.BasePage;
import Trabajopolis.entities.GeneralInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class GeneralInformationPage extends BasePage {
    @FindBy(name="Title")
    WebElement titleField;

    @FindBy(name="JobCategory[]")
    WebElement categoryListBox;

    @FindBy(name="JobType[]")
    WebElement contractListBox;

    @FindBy(name="pretension_salarial")
    WebElement salaryField;

    @FindBy(name="Country")
    WebElement countryListBox;

    @FindBy(name="CityBolivia")
    WebElement cityListBox;

    @FindBy(name="privacidad")
    WebElement privacityCV;

    @FindBy(id="btn-add-cv")
    WebElement nextButton;

    Select selectValue;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(titleField));
    }

    private void setTitle(String title){
        titleField.sendKeys(title);
    }

    private void setCategory(String category){
        selectValue = new Select(categoryListBox);
        selectValue.selectByValue(category);
    }

    private void setContractType(String contract) {
        selectValue = new Select(contractListBox);
        selectValue.selectByValue(contract);
    }

    private void setSalary(String salary){
        salaryField.sendKeys(salary);
    }

    private void setCountry(String country){
        selectValue = new Select(countryListBox);
        selectValue.selectByValue(country);
    }

    private void setCity(String city){
        selectValue = new Select(cityListBox);
        selectValue.selectByValue(city);
    }

    private void setPrivacityCV(String privacity){
        selectValue = new Select(privacityCV);
        selectValue.selectByValue(privacity);
    }


    public void setFillsGeneralInformation(GeneralInformation generalInformation){
        setTitle(generalInformation.getTitle());
        setCategory(generalInformation.getCategory());
        setContractType(generalInformation.getContractType());
        setSalary(generalInformation.getSalary());
        setCountry(generalInformation.getCountry());
        setCity(generalInformation.getCity());
        setPrivacityCV(generalInformation.getPrivacityCV());

    }

    public ManageListingPage clickNextButton(){
        nextButton.click();
        return new ManageListingPage();
    }
}
