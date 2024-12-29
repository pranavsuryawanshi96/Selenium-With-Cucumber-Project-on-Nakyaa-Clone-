Feature: Login

  @Sanity
  Scenario: Login with valid credentials using OTP
    Given I launch the browser
    And I navigate to the Sign In page
    And I click on the  Enter Phone or Email button
    When I enter the valid phone number "9066189696" into the phone number field
    And I click on the Proceed button
    And I enter the retrieved OTP into the OTP field
    And I enter the full name "Pranav Patil"
    And I enter the email address "prnavpatil@gmail.com"
    And I click on the Proceed submit
    Then I should be successfully logged in

  @regression
  Scenario Outline: Login with valid credentials using DDT
    Given I launch the browser
    And I navigate to the Sign In page
    And I click on the  Enter Phone or Email button
    When I enter the valid phone number "<phone_number>" into the phone number field
    And I click on the Proceed button
    And I enter the retrieved OTP into the OTP field
    And I enter the full name "<full_name>"
    And I enter the email address "<email>"
    And I click on the Proceed submit
    Then I should be successfully logged in

    Examples: 
      | phone_number | full_name    | email                     |
      |   9066189696 | Pranav Patil | prnavpatil@gmail.com      |
      | %^&^(%)( !   | %&&%$        | johndoe@example.com       |
      | ❤️💞🎶😀     |              | prnavpatil@gmail.com      |
      |              | Pranav Patil | prnavpatil@gmail.com      |
      |   9066189696 | Pranav Patil |                           |
      |   9066189696 |              | prnavpatil@.com           |
      |   9066189696 | Pranav Patil | prnavpatil@gmail.com      |
      |   9066189696 | Pranav Patil | 💞💞💞😒email@example.com |
