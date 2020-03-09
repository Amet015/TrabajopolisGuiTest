package trabajopolis.pages;

import trabajopolis.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccountPage extends BasePage {

    @FindBy(linkText = "Buscar Empleos")
    WebElement buscarEmpleosLink;

    @FindBy(xpath = "//div//h1[contains(text(),'Mi Cuenta de Candidato')]")
    WebElement miCuentaDeCandidatoTxt;

    @FindBy(linkText = "Mi Perfil")
    WebElement miPerfilLink;

    @FindBy(linkText = "Inicio")
    WebElement inicioLink;

    @FindBy(linkText = "Mis Currículos")
    WebElement misCurriculosLink;

    @FindBy(linkText = "Búsquedas Guardadas")
    private WebElement searchingSaved;

    public MyAccountPage() {
    }

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(miPerfilLink));
    }

    public SearchJobPage clickBuscarEmpleos() {
        buscarEmpleosLink.click();
        return new SearchJobPage();
    }

    public String getMiCuentaCantidato() {
        return miPerfilLink.getText();
    }

    public void clickMiPerfil() {
        miPerfilLink.click();
    }

    public void clickInicio() {
        inicioLink.click();
    }

    public void clickMisCurriculos() {
        misCurriculosLink.click();
    }

    public SearchingSaved clickMySearchingSaved() {
        searchingSaved.click();
        return new SearchingSaved();
    }
}
