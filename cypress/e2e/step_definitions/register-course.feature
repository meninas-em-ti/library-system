Feature: Register Course
  As a system administrator
  I want to manage courses
  So that I can perform CRUD operations on the courses table

  Scenario: Register a New Course
  The System Administrator registers a new course
  and new course is inserted into the list

    Given I am logged in as an administrator
    And I fill in all the fields on the page
    When I click the Register button
    Then I should see the new course in the list on the main page
