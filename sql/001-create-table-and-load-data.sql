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
  health int NOT NULL,
  bmr int NOT NULL,
  daily_calories_consumed int,
  daily_calories_burned int,
  PRIMARY KEY(id)

);

INSERT INTO pets (pet_name, pet_age, health, bmr, daily_calories_consumed, daily_calories_burned) VALUES ("ganmo", 4, 100, 1780, 2000, 750);
INSERT INTO pets (pet_name, pet_age, health, bmr, daily_calories_consumed, daily_calories_burned) VALUES ("yurina", 2, 55, 1460, 1020, 120);

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
