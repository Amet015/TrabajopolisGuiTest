package Trabajopolis.Pages;

import Core.WebDriverManager;
import Trabajopolis.BasePage;
import Trabajopolis.components.WebComponents;
import Trabajopolis.entities.PersonalInformation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Set;
import java.util.function.Supplier;

public class PersonalInformationPage extends BasePage {
    @FindBy(name = "identidad_0")
    WebElement idTypeSelect;

    private final String SEX_XPATH = "//div//label[contains(text(),'%s')]";

    @FindBy(name = "numero_identidad_0")
    WebElement numberId;

    @FindBy(name="nacimiento_0")
    WebElement dateBorn;

    @FindBy(name = "direccion")
    WebElement addressField;

    @FindBy(name = "estado_civil")
    WebElement maritalStatusSelect;

    @FindBy(css = "select.ui-datepicker-month")
    WebElement monthListBox;

    @FindBy(css = "select.ui-datepicker-year")
    WebElement yearListBox;


    @FindBy(id = "btn-add-cv")
    WebElement nextButton;

    private final String ID = "Id";
    private final String NUMBER_ID = "NumberId";
    private final String DATE_BORN = "Date Born";
    private final String SEX = "Sex";
    private final String ADDRESS = "Address";
    private final String MARITAL_STATUS = "Marital Status";
    Select selectValue;

    public PersonalInformationPage() {
    }

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(idTypeSelect));
    }

    private void setIdType(String idType) {
        selectValue = new Select(idTypeSelect);
        selectValue.selectByValue(idType);
    }

    private void setSex(String sex){
        String sexXpath = String.format(SEX_XPATH,sex);
        WebElement setType = WebDriverManager.getInstance().getWebDriver().findElement(By.xpath(sexXpath));
        setType.click();
    }

    private void setNumberId(String idNumber) {
        numberId.clear();
        numberId.sendKeys(idNumber);
    }

    private void setDateBorn(String date) {
        dateBorn.click();
        WebComponents.setDateCalendar(date, yearListBox, monthListBox);
    }

    private void setAddressField(String address) {
        addressField.clear();
        addressField.sendKeys(address);
    }

    private void setMaritalStatus(String maritalstatus) {
        selectValue = new Select(maritalStatusSelect);
        selectValue.selectByValue(maritalstatus);
    }

    public ResumeExperiencePage clickNextButton() {
        nextButton.click();
        return new ResumeExperiencePage();
    }

    public void setPersonalInformation(PersonalInformation personalInformation, final Set<String> fields) {
        HashMap<String, Runnable> strategtyMap = composeStrategyMap(personalInformation);
        fields.forEach(field -> strategtyMap.get(field).run());
    }

    private HashMap<String, Runnable> composeStrategyMap(PersonalInformation personalInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(ID, () -> setIdType(personalInformation.getIdType()));
        strategyMap.put(NUMBER_ID, () -> setNumberId(personalInformation.getNumberId()));
        strategyMap.put(DATE_BORN, () -> setDateBorn(personalInformation.getDateBorn()));
        strategyMap.put(SEX, () -> setSex(personalInformation.getSex()));
        strategyMap.put(ADDRESS, () -> setAddressField(personalInformation.getAddress()));
        strategyMap.put(MARITAL_STATUS, () -> setMaritalStatus(personalInformation.getMaritalStatus()));
        return strategyMap;
    }
}
