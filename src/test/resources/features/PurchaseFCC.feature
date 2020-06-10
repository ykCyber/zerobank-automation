Feature: Purchase Foreign Currency

  Scenario: Available currencies
    Given  the user logged in with correct credentials
    Given the user accesses the Purchase foreign currency cash tab
    Then following currencies should be available
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Yozgat (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Singapore (dollar)    |

  Scenario: Error message for not selecting	currency
    Given the user logged in with correct credentials
    Given the user accesses the Purchase foreign currency cash tab
    When    user tries	to	calculate	cost	without	selecting	a	"Currency"
    Then    error message should be displayed

  Scenario:    Error	message for	not	entering	value
    Given the user logged in with correct credentials
    Given the user accesses the Purchase foreign currency cash tab
    When user calculates amount 200 from currency "Norway (krone)"  to "curruncy"
    Then error message should be displayed
