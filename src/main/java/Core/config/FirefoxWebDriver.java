/*
 * Copyright (c) 2019 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not
 *  disclose such Confidential Information and shall use it only in
 *  accordance with the terms of the license agreement you entered into
 *  with Jalasoft.
 */

package Core.config;

import Core.IDriver;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static io.github.bonigarcia.wdm.DriverManagerType.FIREFOX;

/**
 * FirefoxWebDriver, this class is in charge of initializing the specific characteristics of FirefoxWebDriver.
 *
 * @author Maday Alcala
 * @version 0.0.1
 */
public class FirefoxWebDriver implements IDriver {

    /**
     * Initializes FirefoxWebDriver driver.
     *
     * @return a FirefoxDriver.
     */
    @Override
    public WebDriver initDriver() {
        FirefoxDriverManager.getInstance(FIREFOX).version("0.26.0").setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        return new FirefoxDriver(firefoxOptions);
    }
}
