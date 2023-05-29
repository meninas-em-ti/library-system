@login
Feature: Course

  As a system administrator
  I want to manage courses
  So that I can perform CRUD operations on the courses table

  Scenario Outline: New Course
  As a administrator
  I want to create a new course
  So that I can see a new course in TimeTable

    Given I am administratior
    And I am on the course administration page
    When I add a course name <course name>
    And I add a course time <time>
    And I add a course price <price>
    Then The new course should be visible in the course list


  Examples:
  |  course name                          | limit of costumers |  age group     |   price     | instructor name   |
  |  "Storytime for kids"                 |       40           |  "Kids"        |   5.00      |   "Joyce"         |
  |  "English literature for beginners"   |       30           |  "Teens"       |   10.00     |   "Raquel"        |
  |  "Creative Writing for beginners"     |       30           |  "Teens"       |   15.00     |   "Bruna"         |
  |  "Computers for beginners"            |       30           |  "Adults"      |   20.00     |   "Elaine"        |
  |  "Technology for the over 60s"        |       20           |  "Over 60s"    |   5.00      |   "Ivone"         |


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
