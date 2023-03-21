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
  | name   | phoneNumber |
  | cat    |  3458796463 |
  | robbit |  5967538475 |
  
  @Address
  Scenario: Scenario: Verify User can add an Address
  When User click on Account option
  And User click on Add address option
  And user fill new address form with below information
  | country   |      fullName  | phoneNumber | streetAddress | apt   | city  | state | zipCode |
  | United States   | Mariam   | 4435256789 | 1357 overbrook ln|  null  | Bowie  | MD     | 48876  |
  And User click Add Your Address button
  Then a message should be displayed 'Address Added Successfully'
  
  @UpdatePassword
  Scenario: Verify User can Update password
  When User click on Account option
  And User enter below information
  | previousPassword | newPassword    | confirmPassword |
  | Rai@2023         | Afghanistan@20 | Afghanistan@20  |
  | Rai@2023         | Mariam@2023    | Mariam@2023     |
  And User click on Change Password button
  Then a message should be displayed ‘Password Updated Successfully’
  @AddPayment
  Scenario: Verify User can add a payment method
  When User click on Account option
  And User click on Add a payment method link
  And User fill Debit or credit card information
  | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
  | 2387969547834607 | Mariam     |               9 |           2030 |          096 |
  | 4596875004597684 | Rai        |              10 |           2023 |          569 |
  And User click on Add your card button
  Then a message should be displayed ‘Payment Method added successfully’
  @UpdatePayment
  Scenario: Verify User can edit Debit or Credit card
  When User click on Account option
  And User click on Edit option of card section
  And user edit information with below data
  | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
  | 1234966778894763 | Waqas      |              10 |           2025 |          986 |
  And user click on Update Your Card button
  Then a message should be displayed ‘Payment Method updated Successfully’
  @removePayment
  Scenario: Verify User can remove Debit or Credit card
  When User click on Account option
  And User click on remove option of card section
  Then payment details should be removed
  @editAddress
  Scenario: Verify User can edit an Address added on account
  When User click on Account option
  And User click on edit address option
  And user fill existing address form with new information
  | country       | fullName  | phoneNumber | streetAddress      | apt  | city  | state    | zipCode |
  | United States | Rai Waqas |  4456707089 | 18549 Overbrook ln | null | Bowie | Maryland |   48642 |
  And User click update Your Address button
  Then a message should be displayed ‘Address Updated Successfully’
  @removeAddress
  Scenario: Verify User can remove Address from Account
    When User click on Account option
    And User click on remove option of Address section
    Then Address details should be removed
