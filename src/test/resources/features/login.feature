Feature: Login

  @loginExitoso
  Scenario: Iniciar sesión
    Given que me encuentro en la página de login
    When inicio sesión con las credenciales correctas
    Then valido que deber redirigido a la página de home

  @loginFallido
  Scenario Outline: Iniciar sesión con credenciales incorrectas
    Given que me encuentro en la página de login
    When inicio sesión con las credenciales usuario: "<usuario>" y contraseña: "<contraseña>"
    Then valido que debería aparecer el mensaje de error "Error de autenticación."

    Examples:
      | usuario        | contraseña  |
      | standard@gmail.com  | wrong_pass  |
      | wrong_user@gmail.com     | secret_sauce |