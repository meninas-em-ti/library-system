

Feature: Course
  As a system administrator
  I want to manage courses
  So that I can perform CRUD operations on the courses table

  @new_course
  Scenario Outline: New Course
  The System Administrator registers a new course
  and new course is inserted into the list

    Given The <code> is a new course
    When do I register for this course
    Then I should see the new course in the list

    Examples:
      |   code        |
      | "storytime"   |
      | "literature"  |
      | "writing"     |
      | "computers"   |
      | "technology"  |

  @attempt_course
  Scenario Outline: Required fields
  The user tries to register a film, but forgets to fill in one of the mandatory fields
  then the system displays a notification to the user

    Given <code> is a new course
    When do I register for this course
    Then I must be notified <text>

    Examples:
      |   code              | text                              |
      | "no_name"           | "Name field is required"          |
      | "no_limit"          | "Limit of costumers is required"  |
      | "no_price"          | "Price is required"               |
      | "no_age"            | "Age group is required"           |
      | "no_instructor"     | "Instructor is required"          |
      | "no_date"           | "Date and time is requered"       |

  @dup_course
  Scenario: Duplicate course
  The user tries to register a new course,
  but this course has already been registered at another time
  and the system notifies the user that the course has already been registered

    Given <database> is a new course
    And this course already exists in the database
    When do I register for this course
    Then I must see the notification "This course already registered"
