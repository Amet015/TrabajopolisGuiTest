package Trabajopolis.Pages;

import Core.WebDriverManager;
import Trabajopolis.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResumeDetailsCV extends BasePage {
    @FindBy(xpath = "//*[@id=\"rounded-lh-cap\"]/ul/li[3]/div/div[2]/div[4]")
    WebElement salary;

    @FindBy(xpath = "//*[@id=\"rounded-lh-cap\"]/ul/li[3]/div/div[2]/div[5]")
    WebElement address;

    @FindBy(xpath = "//*[@id=\"rounded-lh-cap\"]/ul/li[3]/div/div[2]/div[12]")
    WebElement maritalStatus;

    @FindBy(xpath = "//*[@id=\"rounded-lh-cap\"]/ul/li[3]/div/div[2]/div[11]")
    WebElement idType;

    @FindBy(xpath = "//*[@id=\"rounded-lh-cap\"]/ul/li[3]/div/div[3]/ul/li/span[1]")
    WebElement companyCharge;

    @FindBy(xpath = "//*[@id=\"rounded-lh-cap\"]/ul/li[3]/div/div[3]/ul/li/span[2]")
    WebElement companyName;

    @FindBy(xpath = "//*[@id=\"rounded-lh-cap\"]/ul/li[3]/div/div[5]/ul/li/span")
    WebElement laguagues;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(salary));
    }

    public String getSalary(){
        return salary.getText();
    }

    public String getAddress(){
        return address.getText();
    }

    public String getMaritalStatus(){
        return maritalStatus.getText();
    }

    public String getIdType(){
        return idType.getText();
    }

    public String getCompanyCharge(){
        return companyCharge.getText();
    }

    public String getCompanyName(){
        return companyName.getText();
    }

    public String getLanguagues(){
        return laguagues.getText();
    }
}
