Feature: My Account

  Scenario: Create new curriculum
    Given I login to the application with "user" credentials
    And I insert the credentials
    When I create Curriculums in Personal Information page with
      | Id             | Pasaporte  |
      | Address        | c/ laredo  |
      | Marital Status | Soltero(a) |
    And I fill fields in Resume Experience page with
      | Company Charge    | Ingeniero  |
      | Company Name      | Entel      |
      | Industry          | Ingeniería |
      | Country           | Bolivia    |
      | City              | Cochabamba |
      | Start Date School | 2/3/2015   |
      | End Date School   | 2/3/2016   |
    And I fill fields in Education Page with
      | School Field          | Sarmiento                |
      | Studio Level          | Bachiller en Humanidades |
      | Country School        | Bolivia                  |
      | City School           | Cochabamba               |
      | Start Date            | 2/10/1997                |
      | End Date              | 11/25/2008               |
      | University Field      | Univalle                 |
      | Career                | Telecomunicaciones       |
      | Country University    | Bolivia                  |
      | City University       | Cochabamba               |
      | Start Date University | 2/10/1997                |
      | End Date University   | 11/25/2008               |
      | Language              | Español                  |
      | Language Written      | Medio                    |
      | Language Oral         | Medio                    |
      | Language Reading      | Medio                    |
    And I fill fields in General Information Page with
      | Title Field   | Ingeniero Telecomunicaciones                            |
      | Category      | Internet                                                |
      | Contract Type | full time                                               |
      | Salary Field  | 4000                                                    |
      | Country List  | Bolivia                                                 |
      | City List     | Cochabamba                                              |
      | PrivacityCV   | Todas las Empresas - Visible en la Base de Datos de CVs |

    Then The application displays a page with a button "DESCARGAR CURRÍCULUM EN PDF"
    And I delete Curriculum