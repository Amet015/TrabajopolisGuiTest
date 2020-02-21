package Trabajopolis;

import Core.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;
    private static final String URL = "https://www.trabajopolis.bo/log-in/";

    public BasePage() {
        webDriver = WebDriverManager.getInstance().getWebDriver();
        webDriverWait = WebDriverManager.getInstance().getWebDriverWait();
        PageFactory.initElements(webDriver, this);
        webDriver.get(URL);
        waitUntilPageObjectIsLoaded();
    }

    protected abstract void waitUntilPageObjectIsLoaded();
}
