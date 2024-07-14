DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id int unsigned AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  age int NOT NULL,
  gender Enum("MALE","FEMALE") NOT NULL,
  height DOUBLE NOT NULL,
  weight DOUBLE NOT NULL,
  activityLevel Enum("LOW","MEDIUM","HIGH") NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO users (name, age, gender, height, weight, activityLevel) VALUES ("yuichi", 39, "MALE", 165.5, 65.0, "MEDIUM");
INSERT INTO users (name, age, gender, height, weight, activityLevel) VALUES ("kana", 31, "FEMALE", 150.5, 46.5, "LOW");

DROP TABLE IF EXISTS pets;

CREATE TABLE pets (
  id int unsigned AUTO_INCREMENT,
  pet_name VARCHAR(255) NOT NULL,
  pet_age int NOT NULL,
  pet_gender Enum("MALE", "FEMALE") NOT NULL,
  bmr DOUBLE NOT NULL,
  daily_energy_requirement DOUBLE NOT NULL,
  daily_calories_consumed DOUBLE,
  daily_calories_burned DOUBLE,
  sleep_time DOUBLE NOT NULL,
  protein DOUBLE NOT NULL,
  fat DOUBLE NOT NULL,
  carbohydrates DOUBLE NOT NULL,
  pet_level int NOT NULL,
  PRIMARY KEY(id)

);

INSERT INTO pets (pet_name, pet_age, pet_gender, bmr, daily_energy_requirement, daily_calories_consumed, daily_calories_burned, sleep_time, protein, fat, carbohydrates, pet_level) VALUES ("ganmo", 1, "MALE", 1780.0, 2639.0, 750, 1450.0, 6.5, 15.0, 9.0, 55.0, 1);
INSERT INTO pets (pet_name, pet_age, pet_gender, bmr, daily_energy_requirement, daily_calories_consumed, daily_calories_burned, sleep_time, protein, fat, carbohydrates, pet_level) VALUES ("yurina", 1, "FEMALE", 1460.0, 1760.5, 120.0,750.5, 4.5, 11.0, 5.0, 75.0, 1);

DROP TABLE IF EXISTS foods;

CREATE TABLE foods (
  id int unsigned AUTO_INCREMENT,
  foodName VARCHAR(255) NOT NULL,
  calories int NOT NULL,
  protein DOUBLE NOT NULL,
  carbohydrates DOUBLE NOT NULL,
  fat DOUBLE NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO foods (foodName, calories, protein, carbohydrates, fat) VALUES ("apple", 95, 0.5, 25, 0.3);
INSERT INTO foods (foodName, calories, protein, carbohydrates, fat) VALUES ("banana", 105, 1.3, 27, 0.3);
