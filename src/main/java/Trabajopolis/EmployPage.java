package Trabajopolis;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EmployPage extends BasePage{
    @FindBy(css = "input.buttonApplyext")
    WebElement applyEmployButton;


    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(applyEmployButton));
    }

    public String getApplyEmployText(){
        return applyEmployButton.getText();
    }
}
