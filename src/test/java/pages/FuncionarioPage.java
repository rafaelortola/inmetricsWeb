package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FuncionarioPage extends BasePage {

    public FuncionarioPage(WebDriver driver) {
        super(driver);
    }

    public FuncionarioPage preencherNome(String nome){
        driver.findElement(By.name("nome")).sendKeys(nome);
        return this;
    }

    public FuncionarioPage alteraNome(String nomealterado){
        driver.findElement(By.name("nome")).clear();
        driver.findElement(By.name("nome")).sendKeys(nomealterado);
        return this;
    }

    public FuncionarioPage preencherCpf(String cpf) throws InterruptedException {
        WebElement campoCpf = driver.findElement(By.id("cpf"));
        Thread.sleep(2000);
        campoCpf.clear();
        campoCpf.click();
        campoCpf.sendKeys(cpf);
        Thread.sleep(2000);
        return this;
    }

    public FuncionarioPage preencherSexo(String sexo){
        WebElement a = driver.findElement(By.name("sexo"));
        if (sexo.equals("Indiferente")){
            driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div[1]/div[6]/div/select/option[2]")).click();
        }
        else if (sexo.equals("Feminino")) {
            driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div[1]/div[6]/div/select/option[3]")).click();
        }
        else {
            driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div[1]/div[6]/div/select/option[4]")).click();
        }


        return this;
    }

    public FuncionarioPage preencherAdmissao(String admissao){
        driver.findElement(By.name("admissao")).sendKeys(admissao);
        return this;
    }

    public FuncionarioPage preencherCargo(String cargo){
        driver.findElement(By.name("cargo")).sendKeys(cargo);
        return this;
    }

    public FuncionarioPage preencherSalario(String salario){
        driver.findElement(By.name("salario")).sendKeys(salario);
        return this;
    }

    public FuncionarioPage preencherTipoContratacao(String tipoContratacao){
        driver.findElement(By.name("tipo-contratacao")).sendKeys(tipoContratacao);
        return this;
    }




    public FuncionarioPage clicarEnviar(){
        driver.findElement(By.cssSelector("body > div > div.container-login100 > div > form > div:nth-child(4) > input")).click();
        return this;
    }

    public FuncionarioPage preencherTodosOsCamposDeFuncionario(String nome, String cpf, String sexo, String admissao, String cargo, String salario, String tipoContratacao) throws InterruptedException {
        preencherNome(nome);
        preencherCpf(cpf);
        preencherSexo(sexo);
        preencherAdmissao(admissao);
        preencherCargo(cargo);
        preencherSalario(salario);
        preencherTipoContratacao(tipoContratacao);

        return this;
    }

    public FuncionarioPage alteroDadosDoFuncionario(String nomealterado){
        driver.findElement(By.cssSelector("#tabela > tbody > tr > td:nth-child(6) > a:nth-child(2) > button")).click();
        alteraNome(nomealterado);
        return this;
    }

    public FuncionarioPage buscarFuncionario(String nomeFuncionario){
        driver.findElement(By.cssSelector("#tabela_filter > label > input[type=search]")).sendKeys(nomeFuncionario);
        //driver.findElement(By.cssSelector("#tabela > tbody > tr > td:nth-child(6) > a:nth-child(2) > button")).click();
        return this;
    }

    public FuncionarioPage validaMensagemAlteradoComSucesso(String mensagemEsperada){
        String mensagemAtual= driver.findElement(By.cssSelector("body > div > div.container-message > div")).getText().substring(0,44);
        Assert.assertEquals(mensagemEsperada,mensagemAtual);
        return this;
    }

    public FuncionarioPage excluirFuncionario(){
        driver.findElement(By.cssSelector("#delete-btn")).click();
        return this;
    }

    public FuncionarioPage validaMensagemExcluirComSucesso(String mensagemEsperada){
        String mensagemAtual= driver.findElement(By.cssSelector("body > div > div.container-message > div")).getText().substring(0,41);
        Assert.assertEquals(mensagemEsperada,mensagemAtual);
        return this;
    }
}
