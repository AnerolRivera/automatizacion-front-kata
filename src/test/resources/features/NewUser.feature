Feature: Crear un nuevo usuario en el panel de administración
@NewUser
  Scenario: El usuario agrega un nuevo usuario correctamente
    Given El usuario está logueado correctamente en la aplicación
    When El usuario navega a la sección de Admin y agrega un nuevo usuario con el nombre "INGRID"
    Then El sistema debe guardar el nuevo usuario y mostrarlo en la lista de usuarios