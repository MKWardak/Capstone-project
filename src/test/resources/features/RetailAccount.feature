@CompleteTest
Feature: Retail Application Account Feature

  Background: 
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'mariamkamran47@gmail.com' and password 'Afghanistan@20'
    And User click on login button
    And User should be logged in into Account
	
	 @smoke
  Scenario Outline: Verify User can update Profile Information
    When User click on Account option
    And User update Name "<name>" and Phone "<phoneNumber>"
    And User click on Update button
    Then User profile information should be updated
    
    Examples:
    | name           | phoneNumber |
    | cat            | 3458796463  |
    | robbit         | 5967538475  |