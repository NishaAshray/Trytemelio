Feature: Add team member

  Background: Login to Temelio Platform
    Given I am logged into the Temelio application
    When I select Admin Setting

  Scenario: Create team member
    When I create a new team member
    Then the team member should be added successfully

  Scenario: Add new foundation tag
    When I new foundation tag
    Then tag should be added successfully

  Scenario: Add Custom Program Areas
    When I create a new custom program area
    Then the custom program area should be added successfully
