Feature: Login con campo de usuario vacío
  @registroInvalid1

  Scenario: El usuario deja el campo de nombre de usuario vacío y coloca la contraseña
    Given El usuario ingresa en la página de login
    When El usuario deja el campo de nombre de usuario vacío y coloca la contraseña
    And El usuario selecciona el botón login
    Then El sistema debe mostrar en el campo usuario el texto "Required"