package Trabajopolis.Pages;

import Core.WebDriverManager;
import Trabajopolis.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ManageListingPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"maindDivBg\"]/div[6]/p[4]/a[1]")
    WebElement downloadCVButton;

    @FindBy(xpath = "//*[@id=\"maindDivBg\"]/div[6]/p[4]/a[2]")
    WebElement lookMyCV;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(downloadCVButton));
    }

    public String getDonwLadCVText(){
        return downloadCVButton.getText();
    }

    public ResumeDetailsCV clickLookMyCV(){
        lookMyCV.click();
        return new ResumeDetailsCV();
    }
}
