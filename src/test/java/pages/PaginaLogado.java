package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaLogado extends BasePage{
    public PaginaLogado(WebDriver driver) {
        super(driver);

    }

    public PaginaLogado realizarLogin(String usuario, String senha){
        driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div[3]/input")).sendKeys(usuario);
        driver.findElement(By.name("pass")).sendKeys(senha);
        return this;
    }

    public PaginaLogado clicarBotaoEntre(){
        driver.findElement(By.cssSelector("body > div > div.container-login100 > div > form > div.container-login100-form-btn.m-t-17.p-t-13 > button")).click();
        return this;
    }

    public PaginaLogado UsuarioAutenticado(){
        String validaAutenticacao = driver.findElement(By.cssSelector("#navbarSupportedContent > ul > li:nth-child(1) > a")).getText();
        validaAutenticacao.contains("Funcionários");
        return this;
    }

    public PaginaLogado clicarNoLinkNovoFuncionario(){
        driver.findElement(By.xpath("/html/body/nav/div/div/ul/li[2]/a")).click();
        return this;
    }

    public PaginaLogado validaMensagemDeSucesso(String mensagemEsperada){
        String mensagemAtual= driver.findElement(By.cssSelector("body > div > div.container-message > div")).getText().substring(0,39);
        Assert.assertEquals(mensagemEsperada,mensagemAtual);
        return this;
    }
}
