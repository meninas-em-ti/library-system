Feature: Login
  So that I can manage the library system
  As a previously registered user
  I cab access the system with my user and password

  @login_happy
  Scenario: Login successfully
    Given I am a system admin
    When When I sign in with "Admin" and "Admin@123"
    Then I acess the Welcome page

  @login_hapless
  Scenario Outline: Unsuccessful login
    Given I am a system admin
    When I sign in with <user> and <pass>
    Then So I must not be authenticated
    And I should to see the message <text>

    Examples:
      |   email           |   senha           |   texto                             |
      |   "Adm"           |   "Admin@123"     |   "Invalid username or password!"   |
      |   "Admim"         |   "Admin@1234"    |   "Invalid username or password!"   |
      |   ""              |   "Admin@123"     |   "The user must be informed!"      |
      |   "Admim"         |   ""              |   "The password must be informed!"  |
