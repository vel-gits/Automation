## Selenium-Cucumber-Java

This repository contains a collection of sample projects and libraries that demonstrate how to use `selenium-cucumber-java`, a BDD (Behavior-Driven Development) framework with Cucumber  Java. The projects showcase automation script development and utilize chaintest reporters. 

### Installation & Prerequisites

1. Maven (Ensure that the .m2 class path is properly set)
2. Eclipse IDE
3. Required Eclipse Plugins:
   - Maven
   - Cucumber
   - Testng
4. Browser driver (Ensure that you have the appropriate browser driver for your desired browser and that the class path is correctly configured)

Download the framework Setup from github and run in eclipse run as testng and report will be generated target -> Chaintest

Feature: OrangeHRM Login Functionality

  Scenario: Valid Login
    Given the user is on the login page
    When the user enters valid credentials "Admin" and "admin123"
    Then the user should see the dashboard

