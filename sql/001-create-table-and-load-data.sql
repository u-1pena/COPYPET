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
  food_id INT unsigned AUTO_INCREMENT,
  food_name VARCHAR(255) NOT NULL,
  food_calories INT NOT NULL,
  food_protein DOUBLE NOT NULL,
  food_fat DOUBLE NOT NULL,
  food_carbohydrates DOUBLE NOT NULL,
  PRIMARY KEY(food_id)
);

INSERT INTO foods (food_id, food_name, food_calories, food_protein, food_fat, food_carbohydrates) VALUES (1, "apple", 52, 0.3, 14, 0.2);
INSERT INTO foods (food_id, food_name, food_calories, food_protein, food_fat, food_carbohydrates) VALUES (2, "banana", 105, 1.3, 27, 0.3);
INSERT INTO foods (food_id, food_name, food_calories, food_protein, food_fat, food_carbohydrates) VALUES (3, "orange", 62, 1.2, 15, 0.2);


