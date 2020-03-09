package trabajopolis.pages;

import trabajopolis.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultJobPage extends BasePage {
    @FindBy(css = "h1.Results")
    WebElement resultTitleTxt;

    @FindBy(id = "listings_order_by1")
    WebElement listings;

    @FindBy(linkText = "Desarrollador(a) de Software")
    WebElement addStandardUnivalle;

    @FindBy(linkText = "Guardar esta Búsqueda")
    private WebElement saveSearching;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(listings));
    }

    public void clickAddUnivalle() {
        addStandardUnivalle.click();
    }

    public String getResultTitle() {
        return resultTitleTxt.getText();
    }

    public PopUpPage clickSaveThisSearching() {
        saveSearching.click();
        return new PopUpPage();
    }
}
