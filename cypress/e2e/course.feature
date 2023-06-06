@login
Feature: Course
  As a system administrator
  I want to manage courses
  So that I can perform CRUD operations on the courses table

  @new_course
  Scenario Outline: New Course
  The System Administrator registers a new course
  and new course is inserted into the list

    Given <code> is a new course
    When do I register for this course
    Then I should see the new course in the list

    Examples:
      |   code        |
      | "storytime"   |
      | "literature"  |
      | "writing"     |
      | "computers"   |
      | "technology"  |


  Scenario: without course name
    When I try to register a corso without the name
    Then I must see the notification "Name field is required"

  Scenario: without limit of costumers
    When I try to register a corso without the name
    Then I must see the notification "Limit of costumers is required"

  Scenario: without age
    When I try to register a corso without the name
    Then I must see the notification "Age group is required"

  Scenario: without price
    When I try to register a corso without the name
    Then I must see the notification "Price is required"

  Scenario: without instructor
    When I try to register a corso without the name
    Then I must see the notification "Instructor is required"



  Scenario: Edit Course
    Given I am administratior
    And the course exists
    When I change a information os the course
    Then A new information should be visible in the course list

  Scenario: Delete Course
    Given I am administratior
    And the course exists
    When I delete this course
    Then I course is not visible in the course list
