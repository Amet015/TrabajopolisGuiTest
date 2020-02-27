package Trabajopolis;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage{

    @FindBy(name = "JobCategory[multi_like][]")
    WebElement categoryListBox;

    @FindBy(name = "CityBolivia[multi_like][]")
    WebElement cityListBox;

    @FindBy(name = "PostedWithin[multi_like][]")
    WebElement postedWithinListBox;

    @FindBy(name = "EmploymentType[multi_like][]")
    WebElement employementTypeListBox;

    @FindBy(name = "keywords[any_words]")
    WebElement keywordsField;

    @FindBy(id = "btnSearch")
    WebElement searchButton;

    private Select selectListbox;
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(searchButton));
    }


    public void setCategory(String categoryValue) {
        selectListbox = new Select(categoryListBox);
        selectListbox.selectByValue(categoryValue);
    }

    public void setCityListBox(String cityValue) {
        selectListbox = new Select(cityListBox);
        selectListbox.selectByValue(cityValue);
    }

    public void setPostedWithinListBox(String postedWithinValue) {
        selectListbox = new Select(postedWithinListBox);
        selectListbox.selectByValue(postedWithinValue);
    }

    public void setEmployementTypeListBox(String employementTypeValue) {
        selectListbox = new Select(employementTypeListBox);
        selectListbox.selectByValue(employementTypeValue);
    }

    public void setKeywords(String keywordsValue) {
        selectListbox = new Select(keywordsField);
        selectListbox.selectByValue(keywordsValue);
    }

    public void clickSearch(){
        searchButton.click();
    }


}
