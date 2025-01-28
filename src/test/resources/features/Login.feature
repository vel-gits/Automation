Feature: Login Functionality

  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter valid credentials "user1" and "password1"
    Then I should see the dashboard

  Scenario: Unsuccessful login with invalid credentials
    Given I am on the login page
    When I enter invalid credentials "wrongUser" and "wrongPass"
    Then I should see an error message
