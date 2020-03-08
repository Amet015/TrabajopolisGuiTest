package trabajopolis.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PopUpPage extends trabajopolis.BasePage {
    @FindBy(name="search_name")
    WebElement searchNameField;

    @FindBy(css = "input.button")
    WebElement saveButton;

    @FindBy(xpath = "//span[@class='ui-button-icon-primary ui-icon ui-icon-closethick']")
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
