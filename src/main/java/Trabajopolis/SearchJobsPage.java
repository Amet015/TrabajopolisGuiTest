package Trabajopolis;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class SearchJobsPage extends BasePage {

    @FindBy(id = "keywords")
    WebElement searchField;

    @FindBy(id = "JobCategory")
    WebElement jobCategoryField;

    @FindBy(id = "search_button")
    WebElement searchButton;

    @FindBy(name = "PostedWithin[multi_like][]")
    WebElement postedWithin;

    @FindBy(name = "Country[multi_like][]")
    WebElement countryListBox;

    @FindBy(name = "CityBolivia[multi_like][]")
    WebElement cityListBox;

    @FindBy(id = "EmploymentType")
    WebElement contractTypeListBox;

    Select selectValue;

    public SearchJobsPage() {
    }

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(searchField));
    }

    public void clickSearchJob() {
        searchButton.click();
    }

    public void setCategory(String value) {
        selectValue = new Select(jobCategoryField);
        selectValue.selectByValue(value);
    }

    public void setPostedWithin(String value) {
        selectValue = new Select(postedWithin);
        selectValue.selectByValue(value);
    }

    public void setCountry(String country) {
        selectValue = new Select(countryListBox);
        selectValue.selectByValue(country);
    }

    public void setCity(String city) {
        selectValue = new Select(cityListBox);
        selectValue.selectByValue(city);
    }

    public void setContractType(String contractType) {
        selectValue = new Select(contractTypeListBox);
        selectValue.selectByValue(contractType);
    }
}
