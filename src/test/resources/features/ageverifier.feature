@ageverifierbackend
Feature: Age Verifer Backend
  As an adult I should be eligible

  Scenario Outline: My age is correctly validated
    Given I have a BackendConnection
    When I input age <age> json
    Then The status code is <code>
    And I should <isValid> response
    Examples:
      | age    |  isValid   | code |
      | 18 | true  | 200 |
      | 21  |  true | 200 |
      | 50  |  true | 200 |
      | 0 |  false | 200 |
      | 17 |  false | 200 |
      | 51  | bug1 | 200 | # Backend returning null instead of true
      | 100  | bug1 | 200 | # Backend returning null instead of true
      | -5  | bug2 | 500 |

