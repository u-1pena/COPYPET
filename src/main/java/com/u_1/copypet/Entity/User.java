package com.u_1.copypet.Entity;

import com.u_1.copypet.Entity.Enum.ActivityLevel;
import com.u_1.copypet.Entity.Enum.Gender;
import java.util.Objects;
import lombok.Data;

@Data
public class User {

  private int id;

  private String name;

  private int age;
  private Gender gender;

  private Double height;

  private Double weight;

  private ActivityLevel activityLevel;


  public User(int id, String name, int age, Gender gender, double height, double weight,
      ActivityLevel activityLevel) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.height = height;
    this.weight = weight;
    this.activityLevel = activityLevel;
  }

  public User(String name, int age, Gender gender, double height, double weight,
      ActivityLevel activityLevel) {

    this.name = name;
    this.age = age;
    this.gender = gender;
    this.height = height;
    this.weight = weight;
    this.activityLevel = activityLevel;
  }


  @Override //別のインスタンスだったとしても同じものと扱うメソットequal
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(id, user.id) &&
        Objects.equals(name, user.name) &&
        Objects.equals(age, user.age) &&
        Objects.equals(gender, user.gender) &&
        Objects.equals(height, user.height) &&
        Objects.equals(weight, user.weight) &&
        Objects.equals(activityLevel, user.activityLevel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, age, gender, height, weight, activityLevel);
  }

}

