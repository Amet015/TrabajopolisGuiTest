package trabajopolis.pages;

import trabajopolis.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ManageListingPage extends BasePage {
    @FindBy(xpath = "//a[contains(text(),'Descargar Curr')]")
    WebElement downloadCVButton;

    @FindBy(xpath = "//a[contains(text(),'Ver Curr')]")
    WebElement lookMyCV;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(downloadCVButton));
    }

    public String getDonwLadCVText() {
        return downloadCVButton.getText();
    }

    public ResumeDetailsCV clickLookMyCV() {
        lookMyCV.click();
        return new ResumeDetailsCV();
    }
}
