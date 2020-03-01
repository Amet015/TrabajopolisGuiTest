package Trabajopolis.Pages;

import Trabajopolis.BasePage;
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


    public void setFillsGeneralInformation(String title, String category, String contractType, String salary,
                                           String country, String city, String privacity){
        titleField.sendKeys(title);
        selectValue = new Select(categoryListBox);
        selectValue.selectByValue(category);
        selectValue = new Select(contractListBox);
        selectValue.selectByValue(contractType);
        salaryField.sendKeys(salary);
        selectValue = new Select(countryListBox);
        selectValue.selectByValue(country);
        selectValue = new Select(cityListBox);
        selectValue.selectByValue(city);
        selectValue = new Select(privacityCV);
        selectValue.selectByValue(privacity);
    }

    public void clickNextButton(){
        nextButton.click();
    }
}
