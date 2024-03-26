# library-system

# Overall Requirements

## Library holds classes:
- All prices are weekly – total is weekly x 12
- Storytime for kids €5 (must have school name when registering class) limit 40
- English literature for beginners €10 limit 30
- Creative Writing for beginners €15 limit 30
- Computers for beginners €20 limit 30
- Technology for the over 60s €5 limit 20
- Membership of the college costs €20 per year
- If customer is a member of the library, they can avail of free classes to the total of €50, and then get 10% discount off the price (once the account is up to date)
The classes can be paid for weekly, or a course bought and paid for before it starts (all courses are 12 weeks long, and when bought before it starts, customers get a 10% discount)
- Timetable also allows the library to be used by all (walk in service), price depends on age group children and over 60s €5, everyone else €10

## Software should allow: 
### Management
- Login for management
- Add or remove classes
- Change prices
- Change number of people per class
- Check customer accounts to ensure payment up to date etc
### Staff 
- Sign people in
- Ensure account up to date/take payment
- Update classes
- Add / remove people from classes
- See how often people attended classes, how long they’re a member etc
- Email customers to let them know their class is starting/payment due etc
### Customers 
- Find classes / timetable / get prices 
- Register for class (choosing pay weekly / pay in total receiving discount)
- Remove themselves from a class
- Email to ask a question

## Technologies
- Java 17
- Spring
- Docker
- MySql
- Thymeleaf
- Heroku
- JUnit 5
- Integration Tests
- Figma

## PENDING TO DO 
- The current application only saves the start date and we calculate the duration of the course without taking bank holidays into consideration. We need to
  refactor the application to validate this case.
- Check if we need to use select instead of text for instructor name field register course page and if we need to keep the validate icon(bootstrap need-validation)
Refactor welcome page
## Refactored Business Requirement
- Max number of customers should be greater than 0;
- Price should accept fraction number;
- Price should not be less than 0;
- The course should not be register twice;
- The instructor should not be assigned for more than one course at the same date and time;
- Create, update and delete course should only be available for a logged user;
- We should use single sign-on to allow the user to log in once and access services without re-entering authentication factors;
- If the user is not logged in the person should ***only*** be allowed to see the available courses.
- When a logged user clicks on edit course the fields should be already filled;
- Limit of customers should load the value from the database;
- All the course fields should required;
- Delete course should show the correct title (Delete course) and review the close icon;




We can run using h2
Run:
```console
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```
