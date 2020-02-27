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

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(saveButton));
    }
}
