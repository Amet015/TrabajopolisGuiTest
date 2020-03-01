package Trabajopolis.Pages;

import Trabajopolis.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccountPage extends BasePage {

    @FindBy(linkText = "Buscar Empleos")
    WebElement buscarEmpleosLink;

    @FindBy(xpath = "/html/body/div[4]/div[6]/div[2]/div/h1")
    WebElement miCuentaDeCandidatoTxt;

    @FindBy(linkText = "Mi Perfil")
    WebElement miPerfilLink;

    @FindBy(linkText = "Inicio")
    WebElement inicioLink;

    @FindBy(xpath = "//*[@id=\"rounded-lh\"]/ul/li[3]/div/div[1]/ul/li[2]/a")
    WebElement misCurriculosLink;

    @FindBy(xpath = "//*[@id=\"rounded-lh\"]/ul/li[3]/div/div[2]/ul/li[2]/a")
    WebElement busquedasGuardadsLink;

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
    public void clickMiPerfil(){
        miPerfilLink.click();
    }

    public void clickInicio(){
        inicioLink.click();
    }

    public void clickMisCurriculos(){
        misCurriculosLink.click();
    }

    public void clickBusquedasGuardadas() {
        busquedasGuardadsLink.click();
    }
}
