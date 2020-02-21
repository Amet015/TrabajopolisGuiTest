package Trabajopolis;

import Core.WebDriverManager;
import Trabajopolis.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private static final String URL = "https://www.trabajopolis.bo/log-in/";

    @FindBy(name="username")
    WebElement userText;

    @FindBy(name="password")
    WebElement passwordText;

    @FindBy(how = How.CSS, css = "input.button")
    WebElement ingresarButton;

    public LoginPage() {
    }

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        //webDriverWait.until(ExpectedConditions.visibilityOf(passwordText));
    }

    public void test_login() {
        webDriver.get(URL);
        setCredentials("at11.fundacion.jala@gmail.com", "at11.2020");
    }

    public void setCredentials(String user, String pass){
        //webDriverWait.until(ExpectedConditions.visibilityOf(passwordText));
        userText.click();
        userText.sendKeys(user);
        passwordText.sendKeys(pass);
        ingresarButton.click();
        WebDriverManager.getInstance().quitWebDriver();
    }

}
