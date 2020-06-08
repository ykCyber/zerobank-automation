Feature: Add new Payee under Pay Bills

  Background:
    Given the user logged in with correct credentials
    Then the user accesses the Add New Payee tab


  Scenario: Add a new payee
    Then creates new payee using following information
      | Payee Name    | The Law Offices of Hyde, Price & Scharks |
      | Payee Address | 100 Same st, Anytown, USA, 10001         |
      | Account       | Checking                                 |
      | Payee details | XYZ account                              |
    Then message "The new payee asd was successfully created" displayed