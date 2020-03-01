Feature: My Account

  #Scenario: Create new curriculum
#    When I create Curriculums in Personal Information page with
#      | Id             | Pasaporte  |
#      | Address        | c/ laredo  |
#      | Marital Status | Soltero(a) |
#    And I fill fields in Resume Experience page with
#      | Company Charge    | Ingeniero  |
#      | Company Name      | Entel      |
#      | Industry          | Ingenier�a |
#      | Country           | Bolivia    |
#      | City              | Cochabamba |
#      | Start Date School | 2/3/2015   |
#      | End Date School   | 2/3/2016   |
#    And I fill fields in Education Page with
#      | School Field          | Sarmiento                |
#      | Studio Level          | Bachiller en Humanidades |
#      | Country School        | Bolivia                  |
#      | City School           | Cochabamba               |
#      | Start Date            | 2/10/1997                |
#      | End Date              | 11/25/2008               |
#      | University Field      | Univalle                 |
#      | Career                | Telecomunicaciones       |
#      | Country University    | Bolivia                  |
#      | City University       | Cochabamba               |
#      | Start Date University | 2/10/1997                |
#      | End Date University   | 11/25/2008               |
#      | Language              | Espa�ol                  |
#      | Language Written      | Medio                    |
#      | Language Oral         | Medio                    |
#      | Language Reading      | Medio                    |
#    And I fill fields in General Information Page with
#      | Title Field   | Ingeniero Telecomunicaciones                            |
#      | Category      | Internet                                                |
#      | Contract Type | full time                                               |
#      | Salary Field  | 4000                                                    |
#      | Country List  | Bolivia                                                 |
#      | City List     | Cochabamba                                              |
#      | PrivacityCV   | Todas las Empresas - Visible en la Base de Datos de CVs |
#    Then The application displays a page with a button "DESCARGAR CURR�CULUM EN PDF"
#    And I delete Curriculum


  Scenario: Edit Salary
    Given I navitate to My Account Page
    When I edit Mi Perfil
      | Salary | 4000 |
    And I save changes
    Then The application displays a message "Guardados los cambios del perfil"
    And I reload the page and verify the changes
