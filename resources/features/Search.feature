@Smoke
Feature: Search functionality

  @Smoke
  Scenario: User searches for a valid product
    Given User opens the Application
    When User enters valid product "HP" into Search box field
    And User clicks on Search button
    Then User should get valid product displayed in search results

  @Regression
  Scenario: User searches for an invalid product
    Given User opens the Application
    When User enters invalid product "Honda" into Search box field
    And User clicks on Search button
    Then User should get a message about no product matching

  @Smoke
  Scenario: User searches without any product
    Given User opens the Application
    When User dont enter any product name into Search box field
    And User clicks on Search button
    Then User should get a message about no product matching

  @Regression
  Scenario: User searches with partial product name
    Given User opens the Application
    When User enters partial product name "Mac" into Search box field
    And User clicks on Search button
    Then User should get relevant products displayed in search results
