package Trabajopolis;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchingSaved extends BasePage {
    @FindBy(linkText = "Eliminar")
    WebElement deleteLink;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(deleteLink));
    }

    public void clickDelete(){
        deleteLink.click();
        webDriver.switchTo().alert().accept();
    }
}
