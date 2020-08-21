
Feature: Cadastro de Funcionario
  Sendo eu um usuário do sistema Inmetrics
  quero automatizar o cadastro de funcionario
  para realizar o desafio de QA

  @CadastrarFuncionario @SmokeTest
  Scenario Outline: Cadastrar funcionário válido
    Given que estou no site "http://www.inmrobo.tk/accounts/login/"
    And que tenho "rafaelortola" e "12345" validos
    When faco o login
    And clico no link de cadastrar funcionário
    And preencho o formulário de cadastro com os dados <nome>, <cpf>, <sexo>, <admissao>, <cargo>, <salario> e <tipoContratacao>
    Then sou redirecionado para página principal
    And deve apresentar a mensagem de sucesso "SUCESSO! Usuário cadastrado com sucesso"

    Examples:
      |nome                |cpf           |sexo        |admissao   |cargo         |salario  |tipoContratacao |
      |"RafaelSilvaOrtola" |13073294708 |"Masculino" |"01011980" |"Analista TI" |"200000" |"PJ"            |

  @EditarFuncionario @SmokeTest
  Scenario Outline: Alterar nome do funcionário
    Given que estou no site "http://www.inmrobo.tk/accounts/login/"
    And que tenho "rafaelortola" e "12345" validos
    When faco o login
    And realizo uma busca pelo funcionario <nomeFuncionario>
    And altero os dados de cadastro <nomeAlterado>
    Then sou redirecionado para página principal
    And deve apresentar a mensagem de alterado com sucesso "SUCESSO! Informações atualizadas com sucesso"
    Examples:
      |nomeFuncionario       | nomeAlterado    |
      |"AlteradoOrtola"      | "AlteradoOrtola12"|


  @ExcluirFuncionario @SmokeTest
  Scenario Outline: Alterar nome do funcionário
    Given que estou no site "http://www.inmrobo.tk/accounts/login/"
    And que tenho "rafaelortola" e "12345" validos
    When faco o login
    And realizo uma busca pelo funcionario <nomeFuncionario>
    And realizo a exclusão do funcionário
    Then sou redirecionado para página principal
    And deve apresentar a mensagem de excluído com sucesso "SUCESSO! Funcionário removido com sucesso"
    Examples:
      |nomeFuncionario      |
      |"Claudia Soares"   |
