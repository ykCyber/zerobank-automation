Feature: Find Transactions in Account Activity

  Background:
    Given the user logged in with correct credentials
    And the user accesses the Find Transactions tab

  @wip
  Scenario: Search by dates
    When the user enters date range from "2012-09-01" to "2012-09-06"
    And clicks search
    Then results table should only show transactions dates between "2012-09-01" to "2012-09-06"



    When the user enters date range from "2012-09-02" to "2012-09-06"
    And clicks search
    Then results table should only show transactions dates between "2012-09-01" to "2012-09-06"
    And  clicks search
    And the results table should only not contain transactions dated "2012-09-01"


  Scenario:    Search	description	case	insensitive
    When the user enter "ONLINE" to description
    And    clicks search
    Then results should contain "ONLINE"
    When the user enter "online" to description
    And    clicks search
    Then    when search "online" results should contain "ONLINE"



  Scenario Outline: type
    Given the user accesses the Find Transactions tab
    And clicks search
    Then results should contain "<type>"
    Then results should contain "<otherType>"
    When user selects type "<type>"
    Then results should contain "<type>"
    But there is NO "<otherType>"
    Examples:
      | type       | otherType  |
      | Deposit    | Withdrawal |
      | Withdrawal | Deposit    |