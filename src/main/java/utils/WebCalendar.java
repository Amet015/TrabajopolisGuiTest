package utils;

import Core.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebCalendar {
    private static Select selectValue;

    public static void setDateCalendar(String date, WebElement year, WebElement month) {
        String[] dateSplit = date.split("/");
        int monthInt = Integer.valueOf(dateSplit[0]) - 1;
        selectValue = new Select(year);
        selectValue.selectByValue(dateSplit[2]);
        selectValue = new Select(month);
        selectValue.selectByValue(String.valueOf(monthInt));
        WebElement daySelected = selectDay(dateSplit);
        daySelected.click();

    }

    private static WebElement selectDay(String[] dateSplit) {
        int month = Integer.valueOf(dateSplit[0]) - 1;
        String day = String.format("//td[contains(@data-month,'%s') and contains(@data-year,'%s')]//a[text()='%s']",
                month, dateSplit[2], dateSplit[1]);
        return WebDriverManager.getInstance().getWebDriver().findElement(By.xpath(day));
    }
}
