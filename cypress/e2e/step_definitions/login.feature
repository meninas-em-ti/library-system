Feature: Login
  As an administrator, I want to log into the system

  Scenario: Valid Login
    Given that I am an administrator and I want to log into the library system
    When I enter my username and password
    Then I have a successful login