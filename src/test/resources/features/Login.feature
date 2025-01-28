Feature: OrangeHRM Login Functionality

  Scenario: Valid Login
    Given the user is on the login page
    When the user enters valid credentials "Admin" and "admin123"
    Then the user should see the dashboard
