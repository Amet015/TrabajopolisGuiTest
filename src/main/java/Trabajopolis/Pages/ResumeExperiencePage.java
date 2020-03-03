package Trabajopolis.Pages;

import Trabajopolis.BasePage;
import Trabajopolis.entities.ResumeExperience;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import Trabajopolis.components.WebComponents;


public class ResumeExperiencePage extends BasePage {
    @FindBy(name="WorkExperience[JobTitle][1]")
    WebElement companyChargeField;

    @FindBy(name = "WorkExperience[CompanyName][1]")
    WebElement companyNameField;

    @FindBy(name = "WorkExperience[Industry][1]")
    WebElement industryListBox;

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

    private void setEndDate(String date){
        endDate.sendKeys(date);
        WebComponents.setDateCalendar(date, yearListBox, monthListBox);
    }


    public void setFillsExperience(ResumeExperience resumeExperience){
        setCompanyCharge(resumeExperience.getCompanyCharge());
        setCompanyName(resumeExperience.getCompanyName());
        setCountryExperience(resumeExperience.getCountryExperience());
        setCityExperience(resumeExperience.getCityExperience());
        setStartDate(resumeExperience.getStartDate());
        setEndDate(resumeExperience.getEndDate());

    }

    public EducationPage clickNextButton(){
        nextButton.click();
        return new EducationPage();
    }
}
