
Feature: Login de Usuario
  Sendo eu um usuário do sistema Inmetrics
  quero automatizar o login de usuario
  para realizar o desafio de QA

  @loginUsuarioValido
  Scenario Outline: Logar com usuário válido
  Given que estou no site "http://www.inmrobo.tk/accounts/login/"
  And que tenho <usuario> e <senha> validos
  When faco o login
  Then sou redirecionado para página principal
  Examples:
   | usuario          | senha    |
   | "rafaelortola"   | "12345"  |

