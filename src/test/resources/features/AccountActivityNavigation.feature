Feature: Navigating	to	specific	accounts	in	Accounts	Activity

  Background:
    Given the user logged in with correct credentials

  Scenario Outline: "<accountType>"	account	redirect
    When the user clicks on	"<accountType>" link on the Account Summary page
    Then the "Account Activity" page should be displayed
    And Account	drop down should have "<accountType>" selected
    Examples:
      | accountType |
      | Savings     |
      | Brokerage   |
      | Checking    |
      | Credit Card |
      | Loan        |


