package Trabajopolis.Pages;

import Trabajopolis.BasePage;
import Trabajopolis.entities.PersonalInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Set;

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

    private void setIdType(String idType) {
        selectValue = new Select(idTypeSelect);
        selectValue.selectByValue(idType);
    }

    private void setAddressField(String address) {
        addressField.clear();
        addressField.sendKeys(address);
    }

    private void setMaritalStatus(String maritalstatus) {
        selectValue = new Select(maritalStatusSelect);
        selectValue.selectByValue(maritalstatus);
    }

    public ResumeExperiencePage clickNextButton(){
        nextButton.click();
        return new ResumeExperiencePage();
    }

    public void setPersonalInformation(PersonalInformation personalInformation, final Set<String> fields) {
        HashMap<String, Runnable> strategtyMap = composeStrategyMap(personalInformation);
        fields.forEach(field -> strategtyMap.get(field).run());
        //        selectIdType(personalInformation.getIdType());
//        setAddressField(personalInformation.getAddress());
//        selectMaritalStatus(personalInformation.getMaritalStatus());
    }

    private HashMap<String, Runnable> composeStrategyMap(PersonalInformation personalInformation) {
        HashMap<String,Runnable> strategyMap = new HashMap<>();
        strategyMap.put("Id", ()-> setIdType(personalInformation.getIdType()));
        strategyMap.put("Address", ()-> setAddressField(personalInformation.getAddress()));
        strategyMap.put("Marital Status", ()-> setMaritalStatus(personalInformation.getMaritalStatus()));
        return strategyMap;
    }

//
//     ************************** EN EL PAGE********************
//    public TaskListPage createNewPod(final Pod pod, final Set<String> fields) {
//        HashMap<String, Runnable> strategyMAp = composeStrategyMap(pod);
//        fields.forEach(field -> strategyMAp.get(field).run());
//        clickOnCreatePodAndInvitePeopleButton();
//        return new TaskListPage();
//    }
//
//    private HashMap<String, Runnable> composeStrategyMap(Pod pod) {
//        HashMap<String, Runnable> strategyMap = new HashMap<>();
//
//        strategyMap.put("podName", () -> setProjectNameTextBox(pod.getPodName()));
//        strategyMap.put("startDate", () ->  clickOnStartDateTextBox(pod.getStartDate()));
//        strategyMap.put("dueDate", () -> clickOnDueDateTextBox(pod.getDueDate()));
//        strategyMap.put("budgetTime", () -> setBudgetTimeTextBox(pod.getBudgetedTime()));
//        strategyMap.put("client", () -> selectClientComboBox(pod.getClient()));
//        strategyMap.put("projectLead", () -> selectProjectLeadComboBox(pod.getPodLead()));
//        strategyMap.put("color", () -> setColorItem(pod.getPodColor()));
//        strategyMap.put("description", () -> setDescriptionTextEditor(pod.getDescription()));
//        return strategyMap;
//    }



}
