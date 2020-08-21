package steps;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.FuncionarioPage;
import pages.PaginaLogado;
import pages.UsuarioPage;

public class Steps {

    WebDriver driver = new ChromeDriver();

    @Given("^que estou no site \"([^\"]*)\"$")
    public void queEstouNoSite(String site) throws Throwable {
        driver.get(site);
    }

    @Given("^que eu acesso a página de cadastro$")
    public void acessarPaginaDeCadastro() throws Throwable {
        driver.findElement(By.className("txt2")).click();
    }

    @Given("^que tenho \"([^\"]*)\", \"([^\"]*)\" e \"([^\"]*)\" validos$")
    public void queTenhoEValidos(String usuario, String senha, String confirmarSenha) throws Throwable {
        new UsuarioPage(driver)
                .preencherTodosOsCampos(usuario, senha, confirmarSenha);
    }

    @When("^faco o cadastro$")
    public void facoOCadastro() throws Throwable {
        new UsuarioPage(driver)
                .clicarConfirmaCadastro();
    }

    //@Então("^eu vejo a mensagem \"([^\"]*)\"$")
    //public void euVejoAMensagem(String msg) throws Throwable {
    //   String mensagemSistema;
    //   mensagemSistema = new ConfirmacaoPage(driver).retornaMensagem();
    //   Assert.assertEquals("Erro ==>>> NÃO VEIO A MENSAGEM DESEJADA", msg, mensagemSistema);
    //}

    @Then("sou redirecionado para página de login")
    public void cadastroRealizadoComSucesso() {
        new UsuarioPage(driver)
                .validaUsuarioCadastradoComSucesso();
    }

    @Then("cadastro é rejeitado devido a não combinação de senhas")
    public void cadastroNaoRealizadoSenhasNaoCombinam() {
        new UsuarioPage(driver)
                .validaMsgSenhaNaoCombinam();
    }

    @Then("cadastro é rejeitado devido ao usuário já ser existente")
    public void cadastroNaoRealizadoUsuarioJaExistente() {
        new UsuarioPage(driver)
                .validaMsgUsuarioJaCadastrado();
    }

    @Given("^que tenho \"([^\"]*)\" e \"([^\"]*)\" validos$")
    public void realizarLogin(String usuario, String senha) throws Throwable {
        new PaginaLogado(driver)
                .realizarLogin(usuario, senha);
    }

    @When("^faco o login$")
    public void facoOLogin() throws Throwable {
        new PaginaLogado(driver)
                .clicarBotaoEntre();
    }

    @Then("^sou redirecionado para página principal$")
    public void validaAutenticacao(){
        new PaginaLogado(driver)
                .UsuarioAutenticado();
    }

    @Given("^preencho o formulário de cadastro com os dados \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" e \"([^\"]*)\"$")
    public void cadastroFuncionario(String nome, String cpf, String sexo, String admissao, String cargo, String salario, String tipoContratacao) throws InterruptedException {
        new FuncionarioPage(driver)
                .preencherTodosOsCamposDeFuncionario(nome, cpf, sexo, admissao, cargo, salario, tipoContratacao)
                .clicarEnviar();
    }

    @Given("^clico no link de cadastrar funcionário$")
    public void clicarNoLinkCadastroFuncionario(){
        new PaginaLogado(driver)
                .clicarNoLinkNovoFuncionario();
    }

    @Given("^deve apresentar a mensagem de sucesso \"([^\"]*)\"$")
    public void validaMensagemSucesso(String mensagemSucesso){
        new PaginaLogado(driver)
                .validaMensagemDeSucesso(mensagemSucesso);
    }

    @Given("^deve apresentar a mensagem de alterado com sucesso \"([^\"]*)\"$")
    public void validaMensagemAlteradaComSucesso(String mensagemSucesso){
        new FuncionarioPage(driver)
                .validaMensagemAlteradoComSucesso(mensagemSucesso);
    }

    @Given("^altero os dados de cadastro \"([^\"]*)\"$")
    public void alterarFuncionario(String nome){
        new FuncionarioPage(driver)
                .alteroDadosDoFuncionario(nome)
                .clicarEnviar();
    }

    @Given("^realizo uma busca pelo funcionario \"([^\"]*)\"$")
    public void buscarFuncionario(String nomeFuncionario){
        new FuncionarioPage(driver)
                .buscarFuncionario(nomeFuncionario);

    }


    @Given("^realizo a exclusão do funcionário")
    public void excluirFuncionario(){
        new FuncionarioPage(driver)
                .excluirFuncionario();

    }

    @Given("^deve apresentar a mensagem de excluído com sucesso \"([^\"]*)\"$")
    public void validaMensagemExclusaoComSucesso(String mensagemSucesso){
        new FuncionarioPage(driver)
                .validaMensagemExcluirComSucesso(mensagemSucesso);
    }

	/*@After
	public void aScreenshots(){
		String EvidênciaDeTeste = System.getProperty("user.dir")+"\\target\\relatorios\\evidencias\\" + Generator.dataHoraParaArquivo() +".png";
		Screenshot.tirar(driver, EvidênciaDeTeste );
	}*/

    @After
    public void bfechaBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
