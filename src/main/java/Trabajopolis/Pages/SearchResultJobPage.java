package Trabajopolis.Pages;

import Trabajopolis.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultJobPage extends BasePage {
    @FindBy(css = "h1.Results")
    WebElement resultTitleTxt;

    @FindBy(id="listings_order_by1")
    WebElement listings;

    @FindBy(linkText = "Desarrollador(a) de Software")
    WebElement addStandardUnivalle;

    @FindBy(xpath = "//*[@id=\"topResults\"]/div[1]/div[2]/div[1]/ul/li[2]/a")
    WebElement saveThisSearch;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(listings));
    }

    public void clickAddUnivalle(){
        addStandardUnivalle.click();
    }
    public String getResultTitle(){
        return resultTitleTxt.getText();
    }
    public void clickSaveThisSearch(){
        saveThisSearch.click();
    }
}
