Feature: Retail Application Account Feature

  Background: 
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'mariamkamran47@gmail.com' and password 'Afghanistan@20'
    And User click on login button
    And User should be logged in into Account
	
  Scenario Outline: Verify User can update Profile Information
    When User click on Account option
    And User update Name "<name>" and Phone "<phoneNumber>"
    And User click on Update button
    Then User profile information should be updated
    
    Examples:
    | name           | phoneNumber |
    | cat            | 3458796463  |
    | robbit         | 5967538475  |
    
    @Address
    Scenario: Scenario: Verify User can add an Address 
     When User click on Account option 
     And User click on Add address option 
     And user fill new address form with below information 
     |country|fullName|phoneNumber|streetAddress|apt |city | state |zipCode|
     |value | value | value | value | value | value | value | value |
     And User click Add Your Address button 
     Then a message should be displayed 'Address Added Successfully'
    