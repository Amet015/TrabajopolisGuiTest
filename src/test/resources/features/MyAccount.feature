Feature: My Account

#  Scenario: Create new curriculum
#    When I navigate to Mis curriculos
#    And I create Curriculums in Personal Information page with
#      | Id             | Cédula de Identidad |
#      | NumberId       | 8049555             |
#      | Date Born      | 2/3/1990            |
#      | Sex            | Masculino           |
#      | Address        | c/ laredo           |
#      | Marital Status | Soltero(a)          |
#    And I fill fields in Resume Experience page with
#      | Company Charge | Ingeniero  |
#      | Company Name   | Entel      |
#      | Country        | Bolivia    |
#      | City           | Cochabamba |
#      | Start Date     | 2/3/2015   |
#      | End Date       | 2/3/2016   |
#    And I fill fields in Education Page with
#      | School                  | Sarmiento                |
#      | Studio Level School     | Bachiller en Humanidades |
#      | Country School          | Bolivia                  |
#      | City School             | Cochabamba               |
#      | Start Date School       | 2/10/1997                |
#      | End Date School         | 25/11/2008               |
#      | University              | Univalle                 |
#      | Career                  | Telecomunicaciones       |
#      | Studio Level University | Licenciatura             |
#      | Country University      | Bolivia                  |
#      | City University         | Cochabamba               |
#      | Start Date University   | 2/10/1997                |
#      | End Date University     | 25/11/2008               |
#      | Language                | Quechua                  |
#      | Language Written        | Medio                    |
#      | Language Oral           | Medio                    |
#      | Language Reading        | Medio                    |
#    And I fill fields in General Information Page with
#      | Title         | Ingeniero Telecomunicaciones                            |
#      | Category      | Internet                                                |
#      | Contract Type | Tiempo Completo                                         |
#      | Salary        | 4000                                                    |
#      | Country       | Bolivia                                                 |
#      | City          | Cochabamba                                              |
#      | PrivacityCV   | Todas las Empresas - Visible en la Base de Datos de CVs |
#    Then The application displays a page with a button "DESCARGAR CURRÍCULUM EN PDF"
#    And The Curriculum is created with the basic information entered
#    And I navigate to Mis curriculos
#    And I delete it


  Scenario: Edit Salary
    Given I navitate to My Account Page
    When I edit Mi Perfil
      | Salary | 4000 |
    And I save changes
    Then The application displays a message "Guardados los cambios del perfil"
    And I reload the page Mi perfil and verify the changes


#  Scenario: Save Searching
#    Given I go to Mi cuenta Page
#    And I go to Buscar Empleos
#    And I search the Job with the following
#      | Category | Internet |
#      | Country  | Bolivia  |
#    When I go Guardar Esta Busqueda
#    And I give the name "Busqueda internet"
#    Then I go to Mi cuenta Page
#    And I go to Busquedas guardadas and verify the searches saved
#    And I delete the searching saved