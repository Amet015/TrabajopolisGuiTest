Feature: Login

  Scenario: Login to trabajopolis
    Given I login to the application with "user" credentials
    When I insert the credentials
    Then The application displays "Mi Perfil"
