package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private WebDriver webDriver;
    private static WebDriverManager instance;
    private static WebDriverWait webDriverWait;

    private WebDriverManager(){
        initialize();
    }

    public static WebDriverManager getInstance(){
        if (instance == null || instance.webDriver == null) {
            instance = new WebDriverManager();
        }
        return instance;
    }

  private void initialize() {

      String browser;
      //webDriver = WebDriverFactory.getWebDriver(browser);
      this.webDriver = new ChromeDriver();
      webDriver.manage().window().maximize();
      webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      webDriverWait = new WebDriverWait(webDriver, 40);
//        this.webDriver = WebDriverFactory.getWebDriver(WebDriverConfig.getInstance().getBrowser());
//        this.webDriver.manage().window().maximize();
//        this.webDriver.manage().timeouts().implicitlyWait(WebDriverConfig.getInstance().getImplicitWaitTime(),
//                TimeUnit.SECONDS);
//
//        webDriverWait = new WebDriverWait(webDriver, WebDriverConfig.getInstance().getExplicitWaitTime());
    }
    public WebDriver getWebDriver(){
        return this.webDriver;
    }

    public void quitWebDriver(){
        webDriver.quit();
        webDriver = null;
    }
    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }
}
