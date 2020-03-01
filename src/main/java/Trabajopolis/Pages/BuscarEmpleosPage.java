package Trabajopolis.Pages;

import Core.WebDriverManager;
import Trabajopolis.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import javax.xml.xpath.XPath;

public class BuscarEmpleosPage extends BasePage {

    @FindBy(id="keywords")
    WebElement searchField;

    @FindBy(id = "JobCategory")
    WebElement jobCategoryField;

    @FindBy(id = "search_button")
    WebElement searchButton;

    @FindBy(name ="PostedWithin[multi_like][]")
    WebElement postedWithin;

    Select selectCategoryField;

    public BuscarEmpleosPage(){}

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(searchField));
    }

    public void clickSearchJob(){
        searchButton.click();
    }

    public void selectCategory(String value){
        selectCategoryField = new Select(jobCategoryField);
        selectCategoryField.selectByValue(value);
    }

    public void selectPostedWithin(String value) {
        selectCategoryField = new Select(postedWithin);
        selectCategoryField.selectByValue(value);
    }



}
