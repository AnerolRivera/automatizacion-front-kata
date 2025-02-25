Feature: Login con credenciales incorrectas
  @registroInvalid

  Scenario: El usuario ingresa credenciales incorrectas
    Given El usuario está en la página de login
    When El usuario ingresa un nombre de usuario y una contraseña incorrectos
    And El usuario presiona el botón login
    Then El sistema debe mostrar el mensaje "Invalid credentials"