Feature: SearchBar
   @regression
  Scenario: Search for a  product
    Given I launch the browser
    And I navigate to the home page
    When I enter "Hairdryer" in the search bar
    And I click on the search button
    Then I should see a list of products related to "Hairdryer"
