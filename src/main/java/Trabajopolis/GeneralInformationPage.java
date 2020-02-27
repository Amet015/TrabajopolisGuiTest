package Trabajopolis;

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

    public void setTitleField(String title){
        titleField.sendKeys(title);
    }

    public void setCategoryListBox(String category){
        selectValue = new Select(categoryListBox);
        selectValue.selectByValue(category);
    }

    public void setContractListBox(String contract) {
        selectValue = new Select(contractListBox);
        selectValue.selectByValue(contract);
    }

    public void setSalaryField(String salary){
        salaryField.sendKeys(salary);
    }

    public void setCountryListBox(String country){
        selectValue = new Select(countryListBox);
        selectValue.selectByValue(country);
    }

    public void setCityListBox(String city){
        selectValue = new Select(cityListBox);
        selectValue.selectByValue(city);
    }

    public void setPrivacityCV(String privacity){
        selectValue = new Select(privacityCV);
        selectValue.selectByValue(privacity);
    }

    public void clickNextButton(){
        nextButton.click();
    }
}
