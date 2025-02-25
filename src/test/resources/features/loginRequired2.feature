Feature: Login sin credenciales
  @registroRequired2

  Scenario: El usuario no ingresa credenciales
    Given El usuario entra a la página de login
    When El usuario no ingresa datos
    And El usuario da clik el botón
    Then El sistema debe mostrar los campos "Username" y "Pasword" en rojo y con el texto "Required"