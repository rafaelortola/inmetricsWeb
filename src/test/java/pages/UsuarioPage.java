package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UsuarioPage extends BasePage {
    public UsuarioPage(WebDriver driver) {
        super(driver);
    }

    public UsuarioPage preencherUsuario(String usuario) {
        driver.findElement(By.name("username")).sendKeys(usuario);
        return this;
    }

    public UsuarioPage preencherSenha(String senha) {
        driver.findElement(By.name("pass")).sendKeys(senha);
        return this;
    }

    public UsuarioPage preencherConfirmarSenha(String confirmarSenha) {
        driver.findElement(By.name("confirmpass")).sendKeys(confirmarSenha);
        return this;
    }

    public UsuarioPage clicarConfirmaCadastro() {
        //driver.findElement(By.cssSelector("input[name=\"commit\"]")).click();
        //return new ConfirmacaoPage(driver);
        driver.findElement(By.cssSelector("body > div > div > div > form > div.container-login100-form-btn.m-t-17 > button")).click();
        return this;
    }

    public UsuarioPage preencherTodosOsCampos(String usuario, String senha, String confirmarSenha) {
        preencherUsuario(usuario);
        preencherSenha(senha);
        preencherConfirmarSenha(confirmarSenha);
        return this;
    }

    public UsuarioPage validaUsuarioCadastradoComSucesso() {
        String validaTitulo = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/span")).getText();
        Assert.assertEquals("Login", validaTitulo);
        return this;
    }

    public UsuarioPage validaMsgSenhaNaoCombinam() {
        String SenhasNaoCombinam = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/span/div")).getText();
        if(SenhasNaoCombinam.contains("Senhas não combinam")){
            Assert.assertEquals("Senhas não combinam",SenhasNaoCombinam);
        }
        else {
            Assert.fail("FALHA NA INCLUSÃO DO USUÁRIO! " + " Motivo: " + SenhasNaoCombinam);
        }
        return this;
    }

    public UsuarioPage validaMsgUsuarioJaCadastrado() {
        String UsuarioJaCadastrado = driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/span/div")).getText();
        if (UsuarioJaCadastrado.contains("Usuário já cadastrado")) {
            Assert.assertEquals("Usuário já cadastrado",UsuarioJaCadastrado);
        }
        else
        {
            Assert.fail("FALHA NA INCLUSÃO DO USUÁRIO! " + " Motivo: " + UsuarioJaCadastrado);
        }
        return this;
    }
}
