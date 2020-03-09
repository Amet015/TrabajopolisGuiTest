package trabajopolis.pages;

import core.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trabajopolis.BasePage;

public class SearchingSaved extends BasePage {
    @FindBy(linkText = "Eliminar")
    WebElement deleteLink;

    private static final String NAME_SAVED = "//table//tbody//tr//td[strong[contains(text(),'%s')]]";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(deleteLink));
    }
    public String getSearched(String save) {
        String nameSavedXpath = String.format(NAME_SAVED,save);
        WebElement nameSaved = WebDriverManager.getInstance().getWebDriver().findElement(By.xpath(nameSavedXpath));
        return nameSaved.getText();
    }

    public void clickDelete() throws InterruptedException {
        deleteLink.click();
        webDriver.switchTo().alert().accept();
    }
}