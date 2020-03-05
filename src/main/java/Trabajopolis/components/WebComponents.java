package Trabajopolis.components;

import Core.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebComponents {
    private static Select selectValue;
    private static int monthInt;
    private static final String DAY_XPATH = "//td[contains(@data-month,'%s') and contains(@data-year,'%s')]//a[text()='%s']";

    public static void setDateCalendar(String date, WebElement year, WebElement month) {
        String[] dateSplit = date.split("/");
        monthInt = Integer.valueOf(dateSplit[1]) - 1;
        selectValue = new Select(year);
        selectValue.selectByValue(dateSplit[2]);
        selectValue = new Select(month);
        selectValue.selectByValue(String.valueOf(monthInt));
        selectDay(dateSplit);
    }

    private static void selectDay(String[] dateSplit) {
        String day = String.format(DAY_XPATH, monthInt, dateSplit[2], dateSplit[0]);
        WebElement dayToSelect = WebDriverManager.getInstance().getWebDriver().findElement(By.xpath(day));
        dayToSelect.click();
    }

    public static String getTextFromTheElement(String xpathValue , String value ) {
        String element = String.format(xpathValue,value);
        WebElement webElement = WebDriverManager.getInstance().getWebDriver().findElement(By.xpath(element));
        return webElement.getText();
    }
}
