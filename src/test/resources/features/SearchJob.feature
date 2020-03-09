#Feature: Search a Job
#
#  Scenario: Search a Job through section buscar empleos page
#    Given I go to Login page
#    And I insert the credentials
#    When I go to buscar empleos section
#      | Category      | Informática |
#      | posted Within | 30          |
#    And I search the Job
#    Then The application displays a page with name board "Resultados de B�squeda de Empleos"
#    #validad el 5% de los resultados.
#    #FindBy(css = td[class*='anuncio-estandar'] span[class*='titulo'] a)
#    #WebElement links;
#   # list WebElements
#
#  Scenario: Search a Job through Home page
#    Given I login to the application with "user" credentials
#    And I insert the credentials
#    When I go to Home Page and fill the fields with
#      | Category        | Internet   |
#      | City List       | Cochabamba |
#      | Employment Type | Full Time  |
#      | Posted Within   | 30         |
#    And I search the Job
#    Then The application displays a page with name board "Resultados de B�squeda de Empleos"