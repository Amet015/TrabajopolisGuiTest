package trabajopolis.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import trabajopolis.BasePage;
import trabajopolis.entities.SearchJob;

import java.util.HashMap;
import java.util.Set;

public class SearchJobPage extends BasePage {

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

    private static final String COUNTRY = "Country";
    private static final String CATEGORY = "Category";

    public SearchJobPage() {
    }

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(searchField));
    }

    public SearchResultJobPage clickSearchJob() {
        searchButton.click();
        return new SearchResultJobPage();
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

    public void setFillsSearchJob(SearchJob searchJob, Set<String> fields) {
        HashMap<String, Runnable> strategtyMap = composeStrategyMap(searchJob);
        fields.forEach(field -> strategtyMap.get(field).run());
    }

    private HashMap<String, Runnable> composeStrategyMap(SearchJob searchJob) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(CATEGORY, () -> setCategory(searchJob.getCategory()));
        strategyMap.put(COUNTRY, () -> setCountry(searchJob.getCountry()));
        return strategyMap;
    }
}
