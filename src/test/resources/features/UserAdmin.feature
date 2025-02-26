Feature: Crear un nuevo usuario
@NewUser1
  Scenario: El usuario agrega un usuario Administrador
    Given El usuario se loguea correctamente en la aplicación
    And  El usuario selecciona en el menu la opcion Admin
    And  El usuario da clic en el boton Add
    When El usuario registra los datos requeridos en el formulario
    Then El sistema guarda el nuevo usuario