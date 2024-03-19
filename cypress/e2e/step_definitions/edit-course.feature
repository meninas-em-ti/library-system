Feature: Edit-Course
  As a system administrator
  I want to edit course
  So that I can edit this course

  Scenario: Edit Course
    Given I am administratior of system
    And the course exists
    And I click on the Update button
    When I change all information of course
    And I click on the Salve button
    Then A new information should be visible in the main page in the course list

  Scenario: Cancel Edit Course
    Given I am administratior os system
    And the course exists
    And I click on the Update button
    When I change all information of course
    And I click on the Cancel button
    Then I can see the main page without change the information in the course list
