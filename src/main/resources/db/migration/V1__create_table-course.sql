CREATE TABLE IF NOT EXISTS Course (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255),
  limit_of_customers INT,
  timetable DATETIME,
  age_group VARCHAR(255),
  price_of_class BIGINT,
  instructor_name VARCHAR(255)
);
