Feature: User Product Purchase Flow
 @Sanity
Scenario: Verify that user can successfully purchase a product
Given I am on the Homepage
    When I click on the Appliances category
    And I click on the Hairdryer product
    And I click on any product
    When I am on the Cart page
    Then I click on Proceed
    And I enter "INDIA" as the country
    And I enter "Pranav Patil" as the name
    And I enter "9066179696" as the phone number
    And I enter "413515" as the pin code
    And I click on Ship to this address
    And I select Cash On Delivery  as the payment method
    Then I click on Confirm Order
    And I enter "1234" as the OTP
    And I click on  Submit
    Then I verify the order confirmation message is displayed

  
  @regression
  Scenario Outline: Verify that user can successfully purchase a product
    Given I am on the Homepage
    When I click on the Appliances category
    And I click on the Hairdryer product
    And I click on any product
    When I am on the Cart page
    Then I click on Proceed
    And I enter "<country>" as the country
    And I enter "<name>" as the name
    And I enter "<phone>" as the phone number
    And I enter "<pincode>" as the pin code
    And I click on Ship to this address
    And I select Cash On Delivery  as the payment method
    Then I click on Confirm Order
    And I enter "1234" as the OTP
    And I click on  Submit
    Then I verify the order confirmation message is displayed

    Examples: 
      | country       | name         | phone       | pincode |
      | INDIA         | Pranav Patil |  9066179696 |  413515 |
      |               | Pranav Patil |  9066179696 |  413515 |
      | INDIA         |              |  9066179696 |  413515 |
      | INDIA         | Pranav Patil |         123 |  413515 |
      | INDIA         | Pranav Patil | 90@%$abcde  |  413515 |
      | INDIA         | Pranav Patil |  9066179696 | abc123  |
      | 🇺🇸          | John Doe     |      987654 |     123 |
      | CANADA🇨🇦    | Alice Smith  |  8888888888 | 1234567 |
      | INDIA         | 😊😊         |  9066179696 |  413515 |
      | GERMANY       | Jane$Doe     |  9123456789 |  654321 |
      | AUSTRALIA     | Liam🦘Miller |             |  413515 |
      | USA           | John@Doe     |  9876543210 |  000000 |
      | NEPAL123      | Jane Doe     |       98765 |  654321 |
      | 🇲🇽          | Anna!Taylor  | 12345678901 |   98765 |
      | UNITED-STATES | Mike*Johnson |  9876543210 | 💯      |
      | MEXICO        | Anna Taylor  | 🤔🤔🤔🤔    |  413515 |
      | GERMANY       | 💡💡💡💡     |             |         |
