
Feature: Login

@smoke
  Scenario: the user should be logged in with valid credentials
    Given the user logged in with correct credentials
    Then the "Account Summary" page should be displayed

  Scenario: the user should not be lodged in with inValid credentials
    Given  the user tries to login with inValid credentials
    Then error message displayed

  Scenario: the user should not be lodged in with inValid credentials
    Given  the user tries to login with empty credentials
    Then error message displayed
@smoke
  Scenario Outline: the user should not be lodged in with inValid credentials
    Given user enters "<username>" and "<password>"
    Then error message displayed
    Examples:
      | username | password |
      | aaaa     |          |
      |          | aaaa     |
