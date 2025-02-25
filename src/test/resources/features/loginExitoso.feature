@test
Feature: Login con credenciales correctas
@LoginExitoso
  Scenario: El usuario ingresa credenciales correctas
    Given El usuario accede en la página de login
    When El usuario ingresa su usuario y contraseña
    And El usuario pulsa el botón login
    And El usuario selecciona la opcion Admin
    And El usuario da clik en el boton Add
    And El usuario ingresa los datos de registro
    And El usuario da click en el boton save
    Then El sistema registra el usuario exitosamente