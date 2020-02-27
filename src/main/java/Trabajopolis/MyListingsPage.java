package Trabajopolis;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyListingsPage extends BasePage{
    @FindBy(linkText = "aquí")
    WebElement addCV;


    public MyListingsPage(){}
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(addCV));
    }

    public String getAddCVText(){
        return addCV.getText();
    }

    public void clickAddCV(){
        addCV.click();
    }
}
