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
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.io.File;
import java.util.HashMap;

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

        HashMap<String, Object> firefoxPrefs = new HashMap<String, Object>();
        firefoxPrefs.put("profile.default_content_settings.popups", 0);
        //Boolean which specifies whether we should ask the user if we should download a file (true) or just download it
        //automatically.
        firefoxPrefs.put("download.prompt_for_download", "false");
        //This configuration allows to download multiples files
        firefoxPrefs.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1);

        String path = "C:/download";

        File file = new File(path);
        // String which specifies where to download files to by default.
        firefoxPrefs.put("download.default_directory", file.getAbsolutePath());
        // To avoid alert message when download XML Files.
        firefoxPrefs.put("safebrowsing.enabled", "true");

        FirefoxOptions firefoxOptions = new FirefoxOptions();

        //Use to ignore ssl errors
        firefoxOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);

        //Todo Add more code here if need to do some configurations
        return new org.openqa.selenium.firefox.FirefoxDriver(firefoxOptions);


    }
}
