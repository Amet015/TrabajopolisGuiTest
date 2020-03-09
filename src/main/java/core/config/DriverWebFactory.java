package core.config;

import core.IDriver;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverWebFactory {
    final static String CHROME = "chrome";
    final static String FIREFOX = "firefox";

    public static WebDriver getWebDriver() {
        Map<String, IDriver> map = new HashMap<>();
        map.put(CHROME, new ChromeWebDriver());
        map.put(FIREFOX, new FirefoxWebDriver());
        return map.get(DriverConfig.getInstance().getDriver()).initDriver();
    }
}

