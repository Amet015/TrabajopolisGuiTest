package Trabajopolis;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PopUpTrabajopolis extends BasePage {
    @FindBy(name="search_name")
    WebElement searchNameField;

    @FindBy(css = "input.button")
    WebElement saveButton;

    @FindBy(xpath = "/html/body/div[10]/div[1]/button/span[1]")
    WebElement closeButton;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(searchNameField));
    }
    public void setSearchName(String name){
        searchNameField.sendKeys(name);
        saveButton.click();
        closeButton.click();
    }


}
