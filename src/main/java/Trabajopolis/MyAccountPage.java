package Trabajopolis;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccountPage extends BasePage{

    @FindBy(linkText = "Buscar Empleos")
    WebElement buscarEmpleosLink;

    @FindBy(xpath = "/html/body/div[4]/div[6]/div[2]/div/h1")
    WebElement miCuentaDeCandidatoTxt;

    @FindBy(linkText = "Mi Perfil")
    WebElement miPerfilLink;

    @FindBy(linkText = "Inicio")
    WebElement inicioLink;

    @FindBy(linkText = "Mis Curr�culos")
    WebElement misCurriculosLink;

    public MyAccountPage(){}

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(miPerfilLink));
    }
    public void clickBuscarEmpleos(){
        buscarEmpleosLink.click();
    }

    public String getMiCuentaCantidato(){
        return miPerfilLink.getText();
    }

    public void clickInicio(){
        inicioLink.click();
    }

    public void clickMisCurriculos(){
        misCurriculosLink.click();
    }
}
