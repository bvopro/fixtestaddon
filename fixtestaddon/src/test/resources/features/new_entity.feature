Feature: New entity find by code

  Scenario: Search entity
    Given a empty list of New entity
    When I search the code "code"
    Then I get no new entity

Scenario: Check code is available
    Given a empty list of New entity
    When I search the code "code"
    Then I check it is available

Scenario: Search entity
    Given a empty list of New entity
    When I search the code "code"
    Then I get no new entity v2

