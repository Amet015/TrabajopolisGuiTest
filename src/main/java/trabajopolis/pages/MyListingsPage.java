package trabajopolis.pages;

import trabajopolis.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyListingsPage extends BasePage {
    @FindBy(linkText = "aquí")
    WebElement addCV;

    @FindBy(linkText = "Eliminar")
    WebElement deleteCV;


    public MyListingsPage() {
    }

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(addCV));
    }

    public String getAddCVText() {
        return addCV.getText();
    }

    public PersonalInformationPage clickAddCV() {
        addCV.click();
        return new PersonalInformationPage();
    }

    public void clickDeleteCV() {
        deleteCV.click();
        webDriver.switchTo().alert().accept();
    }
}
