package trabajopolis.pages;

import trabajopolis.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trabajopolis.entities.EditProfile;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public class EditProfilePage extends BasePage {
    @FindBy(name = "email[original]")
    private WebElement emailField;

    @FindBy(id = "salary")
    private WebElement salaryField;

    @FindBy(css = "input.button")
    private WebElement saveButton;

    @FindBy(css = "p.message")
    private WebElement messageSuccesful;

    private static final String SALARY = "Salary";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(emailField));
    }

    public void setSalaryField(String salary) {
        salaryField.clear();
        salaryField.sendKeys(salary);
    }

    public String getMessageSuccesful() {
        return messageSuccesful.getText();
    }

    public String getSalaryField() {
        return salaryField.getAttribute("value");
    }

    public void clickSave() {
        saveButton.click();
    }

    public void setEditProfile(EditProfile editProfile, final Set<String> fields) {
        HashMap<String, Runnable> strategtyMap = composeStrategyMap(editProfile);
        fields.forEach(field -> strategtyMap.get(field).run());
    }

    private HashMap<String, Runnable> composeStrategyMap(EditProfile editProfile) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(SALARY, () -> setSalaryField(editProfile.getSalary()));
        return strategyMap;
    }


    public void setOldEditProfile(EditProfile editProfile, final Set<String> fields) {
        HashMap<String, Runnable> strategtyMap = composeOldStrategyMap(editProfile);
        fields.forEach(field -> strategtyMap.get(field).run());
    }

    private HashMap<String, Runnable> composeOldStrategyMap(EditProfile editProfile) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(SALARY, () -> setSalaryField(editProfile.getSalaryOld()));
        return strategyMap;
    }



    public HashMap<String, String> getEditProfile() {
        HashMap<String, String> values = new HashMap<>();
        HashMap<String, Supplier> strategyMap = composeStrategyGet();
        for (String key : strategyMap.keySet()) {
            values.put(key, strategyMap.get(key).get().toString());
        }
        return values;
    }

    private HashMap<String, Supplier> composeStrategyGet() {
        HashMap<String, Supplier> strategyMapGet = new HashMap<>();
        strategyMapGet.put(SALARY, () -> getSalaryField());
        return strategyMapGet;
    }
}
