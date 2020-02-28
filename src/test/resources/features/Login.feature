Feature: Login

  Scenario: Login to trabajopolis
    Given I go to Login page
    When I insert the credentials
    Then The application displays "Mi Perfil"
