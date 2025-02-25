Feature: Login con credenciales incompletas
  @registroRequired

  Scenario: El usuario ingresa credenciales incompletas
    Given El usuario ingresa en la página de login
    When El usuario ingresa una contraseña incorrecta
    And El usuario da clik el botón login
    Then El sistema debe mostrar el campo Username en rojo y con el texto "Required"