Feature: Login con credenciales correctas
  @RegistroExitoso
  Scenario: El usuario ingresa credenciales correctas y es redirigido al dashboard
    Given El usuario inicia en la página de login
    When El usuario ingresa un nombre de usuario y una contraseña correctos
    And El usuario da clic sobre el botón de login
    Then El sistema debe mostrar la página de inicio