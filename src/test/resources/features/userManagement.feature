Feature: User Management

  Scenario: Add and Delete User
    Given I am on the login page
    When I log in with username "admin" and password "admin123"
    And I navigate to the Admin page
    Then I record the initial number of users
    When I add a new user with a random username
    Then the number of users should increase by 1
    When I search for the newly added user
    And I delete the user
    Then the number of users should be back to the initial count