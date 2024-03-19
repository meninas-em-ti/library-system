Feature: Delete
  As a system administrator
  I want to delete course
  So that I can delete this course

  Scenario: Delete Course
    Given I am administratior
    And the course exists
    When I delete this course
    Then I course is not visible in the course list
