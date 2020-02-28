package Trabajopolis;

import Core.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditProfilePage extends BasePage {
    @FindBy(name="email[original]")
    WebElement emailField;

    @FindBy(id="salary")
    WebElement salaryField;

    @FindBy(css = "input.button")
    WebElement saveButton;

    @FindBy(css = "p.message")
    WebElement messageSuccesful;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(emailField));
    }

    public void setSalaryField(String salary){
        salaryField.clear();
        salaryField.sendKeys(salary);
    }

    public String getMessageSuccesful(){
        return messageSuccesful.getText();
    }

    public String getSalaryField(){
        System.out.println(salaryField.getText());
        return salaryField.getAttribute("value");
    }

    public void clickSave(){
        saveButton.click();
    }


    //Guardados los cambios del perfil
}
