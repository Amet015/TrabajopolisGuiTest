package Trabajopolis;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

    @FindBy(name = "uid")
    WebElement userTrabajopolis;

    @FindBy(name = "password")
    WebElement passwordTrabajopolis;

    @FindBy(how = How.CSS, css = "input.button")
    WebElement ingresar;

    public void setCredentials(String user, String pass) {
        userTrabajopolis.sendKeys(user);
        passwordTrabajopolis.sendKeys(pass);
        ingresar.click();
    }

}
