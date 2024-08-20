DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id INT UNSIGNED AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  age INT NOT NULL,
  gender Enum('MALE','FEMALE') NOT NULL,
  height DOUBLE NOT NULL,
  weight DOUBLE NOT NULL,
  activity_level Enum('LOW','MEDIUM','HIGH') NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO users (name, age, gender, height, weight, activity_level) VALUES ("yuichi", 39, 'MALE', 165.5, 65.0, 'MEDIUM');
INSERT INTO users (name, age, gender, height, weight, activity_level) VALUES ("kana", 31, 'FEMALE', 150.5, 46.5, 'LOW');

DROP TABLE IF EXISTS pets;

CREATE TABLE pets (
  user_id INT UNSIGNED,
  pet_name VARCHAR(255),
  age_in_days INT,
  pet_gender ENUM('MALE', 'FEMALE') NOT NULL,
  bmr DOUBLE NOT NULL,
  daily_energy_requirement DOUBLE NOT NULL,
  in_take_calories_today DOUBLE NOT NULL,
  calorie_expenditure_today DOUBLE NOT NULL,
  sleep_time DOUBLE NOT NULL,
  in_take_protein_today DOUBLE NOT NULL,
  in_take_fat_today DOUBLE NOT NULL,
  in_take_carbohydrates_today DOUBLE NOT NULL,
  pet_level INT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id)
);

INSERT INTO pets (user_id, pet_name, age_in_days, pet_gender, bmr, daily_energy_requirement, in_take_calories_today, calorie_expenditure_today, sleep_time, in_take_protein_today, in_take_fat_today, in_take_carbohydrates_today, pet_level) VALUES (1, "ganmo", 0, "MALE", 1770.0, 2124.0, 120.0, 750.5, 4.5, 11.0, 5.0, 75.0, 1);


DROP TABLE IF EXISTS foods;

CREATE TABLE foods (
  id int unsigned AUTO_INCREMENT,
  food_name VARCHAR(255) NOT NULL,
  calories INT NOT NULL,
  protein DOUBLE NOT NULL,
  carbohydrates DOUBLE NOT NULL,
  fat DOUBLE NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO foods (food_name, calories, protein, carbohydrates, fat) VALUES ("apple", 95, 0.5, 25, 0.3);
INSERT INTO foods (food_name, calories, protein, carbohydrates, fat) VALUES ("banana", 105, 1.3, 27, 0.3);
INSERT INTO foods (food_name, calories, protein, carbohydrates, fat) VALUES ("orange", 62, 1.2, 15, 0.2);


