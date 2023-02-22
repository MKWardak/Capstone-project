@CompleteTest
Feature: TEK Retail Application SignIn feature

  Background: 
    Given User is on retail website
    When User click on Sign in option


  Scenario: Verify user can sign in into Retail Application
    And User enter email 'mariamkamran47@gmail.com' and password 'Afghanistan@20'
    And User click on login button
    Then User should be logged in into Account

  @smokeTest
  Scenario Outline: Verify user can sign in into Retail Application
    And User enter email '<email>' and password '<password>'
    And User click on login button
    Then User should be logged in into Account

    Examples: 
      | email                     | password  |
      | transformers@tekschool.us | Tek@12345 |
      | phantom.test@gmail.com    | Tek@12345 |

  Scenario: Verify user can create an acount into Retail Website
    And User click on Create New Account button
    And User fill the signUp information with below data
      | name   | email                      | password  | confirmPassword |
      | Mariam | mariam.kamran@tekschool.us | Tek@12345 | Tek@12345       |
    And User click on SignUp button
    Then User should be logged into account page
