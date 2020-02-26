package Trabajopolis;

import Core.WebDriverManager;
import Trabajopolis.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {


    @FindBy(name = "username")
    WebElement userText;

    @FindBy(name = "password")
    WebElement passwordText;

    @FindBy(css = "input.button")
    WebElement ingresarButton;


    public LoginPage() {
    }

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(passwordText));
    }

    public void test_login() {
        setCredentials("at11.fundacion.jala@gmail.com", "at11.2020");
    }


    public void setCredentials(String user, String pass) {
        userText.click();
        userText.sendKeys(user);
        passwordText.sendKeys(pass);
        ingresarButton.click();
    }
}
