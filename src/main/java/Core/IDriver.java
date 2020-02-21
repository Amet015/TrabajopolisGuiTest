/*
 * Copyright (c) 2019 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not
 *  disclose such Confidential Information and shall use it only in
 *  accordance with the terms of the license agreement you entered into
 *  with Jalasoft.
 */

package Core;

import org.openqa.selenium.WebDriver;

/**
 * IDriver, this interface is used in order to have a Strategy pattern.
 *
 * @author Maday Alcala.
 * @version 0.0.1
 */
public interface IDriver {
    /**
     * This method initializes the browser according to the classes that implement this interface.
     *
     * @return initDriver, that init the necessary browser.
     */
    WebDriver initDriver();
}
