Feature: Login con campos vacíos
  @registroInvalid2

  Scenario: El usuario deja los campos de nombre de usuario y contraseña vacíos
    Given El usuario accede en la página de login
    When El usuario deja los campos de nombre de usuario y contraseña vacíos
    And El usuario hace clic el en botón login
    Then El sistema debe mostrar el texto "Required" en el campo Username
    And El sistema debe mostrar el texto "Required" en el campo Password