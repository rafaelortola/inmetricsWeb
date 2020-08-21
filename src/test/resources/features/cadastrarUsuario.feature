
Feature: Cadastro de Usuario
  Sendo eu um usuário do sistema Inmetrics
  quero automatizar o cadastro de usuario
  para realizar o desafio de QA

  @CadastrarUsuarioValido @SmokeTest
  Scenario Outline: Cadastrar usuário válido
    Given que estou no site "http://www.inmrobo.tk/accounts/login/"
    And que eu acesso a página de cadastro
    And que tenho <usuario>, <senha> e <confirmarSenha> validos
    When faco o cadastro
    Then sou redirecionado para página de login

    Examples:
      |usuario              |senha    |confirmarSenha  |
#      |"cadastroRafael1"    |"123"    |"123"           |
#      |"cadastroRafael2"    |"123"    |"123"           |
#      |"cadastroRafael3"    |"123"    |"123"           |
#      |"cadastroRafael4"    |"123"    |"123"           |
#      |"cadastroRafael5"    |"123"    |"123"           |
#      |"cadastroRafael6"    |"123"    |"123"           |
#      |"cadastroRafael7"    |"123"    |"123"           |

  @CadastrarUsuario @SmokeTest
  Scenario Outline: Cadastrar usuário já existente
    Given que estou no site "http://www.inmrobo.tk/accounts/login/"
    And que eu acesso a página de cadastro
    And que tenho <usuario>, <senha> e <confirmarSenha> validos
    When faco o cadastro
    Then cadastro é rejeitado devido ao usuário já ser existente

    Examples:
      |usuario          |senha    |confirmarSenha |
      |"rafaelortola"   |"12345"  |"12345"        |

  @CadastrarUsuario @SmokeTest
  Scenario Outline: Cadastrar usuário com senhas divergentes
    Given que estou no site "http://www.inmrobo.tk/accounts/login/"
    And que eu acesso a página de cadastro
    And que tenho <usuario>, <senha> e <confirmarSenha> validos
    When faco o cadastro
    Then cadastro é rejeitado devido a não combinação de senhas

    Examples:
      | usuario          | senha    | confirmarSenha      |
      | "rafaelortolaaaa"   | "123"    | "567"            |
