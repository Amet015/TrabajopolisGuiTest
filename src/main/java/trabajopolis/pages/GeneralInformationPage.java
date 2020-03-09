package trabajopolis.pages;

import trabajopolis.BasePage;
import trabajopolis.entities.GeneralInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Set;

public class GeneralInformationPage extends BasePage {
    @FindBy(name = "Title")
    WebElement titleField;

    @FindBy(name = "JobCategory[]")
    WebElement categoryListBox;

    @FindBy(name = "JobType[]")
    WebElement contractListBox;

    @FindBy(name = "pretension_salarial")
    WebElement salaryField;

    @FindBy(name = "Country")
    WebElement countryListBox;

    @FindBy(name = "CityBolivia")
    WebElement cityListBox;

    @FindBy(name = "privacidad")
    WebElement privacityCV;

    @FindBy(id = "btn-add-cv")
    WebElement nextButton;

    Select selectValue;

    private final String TITLE = "Title";
    private final String CATEGORY = "Category";
    private final String CONTRACT_TYPE = "Contract Type";
    private final String SALARY = "Salary";
    private final String COUNTRY = "Country";
    private final String CITY = "City";
    private final String PRIVACITY_CV = "PrivacityCV";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(titleField));
    }

    private void setTitle(String title) {
        titleField.sendKeys(title);
    }

    private void setCategory(String category) {
        selectValue = new Select(categoryListBox);
        selectValue.selectByValue(category);
    }

    private void setContractType(String contract) {
        selectValue = new Select(contractListBox);
        selectValue.selectByVisibleText(contract);
    }

    private void setSalary(String salary) {
        salaryField.sendKeys(salary);
    }

    private void setCountry(String country) {
        selectValue = new Select(countryListBox);
        selectValue.selectByValue(country);
    }

    private void setCity(String city) {
        selectValue = new Select(cityListBox);
        selectValue.selectByValue(city);
    }

    private void setPrivacityCV(String privacity) {
        selectValue = new Select(privacityCV);
        selectValue.selectByValue(privacity);
    }

    public void setFillsGeneralInformation(GeneralInformation generalInformation, final Set<String> fields) {
        HashMap<String, Runnable> strategtyMap = composeStrategyMap(generalInformation);
        fields.forEach(field -> strategtyMap.get(field).run());
    }

    private HashMap<String, Runnable> composeStrategyMap(GeneralInformation generalInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(TITLE, () -> setTitle(generalInformation.getTitle()));
        strategyMap.put(CATEGORY, () -> setCategory(generalInformation.getCategory()));
        strategyMap.put(CONTRACT_TYPE, () -> setContractType(generalInformation.getContractType()));
        strategyMap.put(SALARY, () -> setSalary(generalInformation.getSalary()));
        strategyMap.put(COUNTRY, () -> setCountry(generalInformation.getCountry()));
        strategyMap.put(CITY, () -> setCity(generalInformation.getCity()));
        strategyMap.put(PRIVACITY_CV, () -> setPrivacityCV(generalInformation.getPrivacityCV()));
        return strategyMap;
    }

    public ManageListingPage clickNextButton() {
        nextButton.click();
        return new ManageListingPage();
    }
}
