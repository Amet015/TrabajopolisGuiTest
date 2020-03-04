package Trabajopolis.Pages;

import Trabajopolis.BasePage;
import Trabajopolis.entities.PersonalInformation;
import Trabajopolis.entities.ResumeExperience;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import Trabajopolis.components.WebComponents;

import java.util.HashMap;
import java.util.Set;


public class ResumeExperiencePage extends BasePage {
    @FindBy(name = "WorkExperience[JobTitle][1]")
    WebElement companyChargeField;

    @FindBy(name = "WorkExperience[CompanyName][1]")
    WebElement companyNameField;

    @FindBy(name = "WorkExperience[pais_0][1]")
    WebElement countryExperienceListBox;

    @FindBy(name = "WorkExperience[ciudad_0][1]")
    WebElement cityExperienceField;

    @FindBy(name = "WorkExperience[StartDate][1]")
    WebElement startDate;

    @FindBy(name = "WorkExperience[EndDate][1]")
    WebElement endDate;

    @FindBy(id = "btn-add-cv")
    WebElement nextButton;

    @FindBy(css = "select.ui-datepicker-year")
    WebElement yearListBox;

    @FindBy(css = "a.:contains()")
    WebElement daySelect;


    @FindBy(css = "select.ui-datepicker-month")
    WebElement monthListBox;

    Select selectvalue;

    private final String COMPANY_CHARGE = "Company Charge";
    private final String COMPANY_NAME = "Company Name";
    private final String COUNTRY = "Country";
    private final String CITY = "City";
    private final String START_DATE = "Start Date";
    private final String END_DATE = "End Date";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(companyChargeField));
    }

    private void setCompanyCharge(String companyCharge) {
        companyChargeField.sendKeys(companyCharge);
    }

    private void setCompanyName(String companyName) {
        companyNameField.sendKeys(companyName);
    }

    private void setCountryExperience(String countryExperience) {
        selectvalue = new Select(countryExperienceListBox);
        selectvalue.selectByValue(countryExperience);
    }

    private void setCityExperience(String cityExperience) {
        cityExperienceField.sendKeys(cityExperience);
    }

    private void setStartDate(String date) {
        startDate.sendKeys(date);
        WebComponents.setDateCalendar(date, yearListBox, monthListBox);
    }

    private void setEndDate(String date) {
        endDate.sendKeys(date);
        WebComponents.setDateCalendar(date, yearListBox, monthListBox);
    }


    public void setFillsExperience(ResumeExperience resumeExperience, final Set<String> fields) {
        HashMap<String, Runnable> strategtyMap = composeStrategyMap(resumeExperience);
        fields.forEach(field -> strategtyMap.get(field).run());
    }

    private HashMap<String, Runnable> composeStrategyMap(ResumeExperience resumeExperience) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(COMPANY_CHARGE, () -> setCompanyCharge(resumeExperience.getCompanyCharge()));
        strategyMap.put(COMPANY_NAME, () -> setCompanyName(resumeExperience.getCompanyName()));
        strategyMap.put(COUNTRY, () -> setCountryExperience(resumeExperience.getCountryExperience()));
        strategyMap.put(CITY, () -> setCityExperience(resumeExperience.getCityExperience()));
        strategyMap.put(START_DATE, () -> setStartDate(resumeExperience.getStartDate()));
        strategyMap.put(END_DATE, () -> setEndDate(resumeExperience.getEndDate()));
        return strategyMap;
    }

    public EducationPage clickNextButton() {
        nextButton.click();
        return new EducationPage();
    }
}
